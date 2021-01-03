package star.wars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import star.wars.client.StarWarsClient;
import star.wars.exception.RecordNotFoundException;
import star.wars.model.Starship;
import star.wars.model.api.CharacterDescription;
import star.wars.model.api.Response;
import star.wars.model.swapi.Character;
import star.wars.model.swapi.SwApiResponse;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarWarsService {

    private final Logger logger = LoggerFactory.getLogger(StarWarsService.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private static Long id;

    @Autowired
    private StarWarsClient starWarsClient;

    public CharacterDescription getCharacter(final Long id) {
        StarWarsService.id = id;
        try {
            final Character character = starWarsClient.getCharacter(id);
            return mapCharacter(character);
        } catch (final Exception e) {
            logger.error(e.getMessage());
            throw new RecordNotFoundException("Character id '" + id + "' not exist");
        }
    }

    public Response getCharacters(final Long pageNumber) {
        id = (pageNumber - 1) * 10 + 1;
        try {
            final SwApiResponse swApiResponse = starWarsClient.getCharacters(pageNumber);
            final List<CharacterDescription> characters = new ArrayList<>();
            swApiResponse.getResults().forEach(character -> characters.add(mapCharacter(character)));
            return new Response(swApiResponse.getCount(), (swApiResponse.getCount() / 10) + 1, characters);
        } catch (final Exception e) {
            logger.error(e.getMessage());
            throw new RecordNotFoundException("Page number '" + pageNumber + "' not exist");
        }
    }

    private CharacterDescription mapCharacter(final Character character) {
        final CharacterDescription characterDescription = mapper.convertValue(character, CharacterDescription.class);
        characterDescription.setId(id++);
        characterDescription.setHomeworld(starWarsClient.getPlanets(getId(character.getHomeworld())));
        characterDescription.setStarships(mapStarShipList(character));
        return characterDescription;
    }

    private List<Starship> mapStarShipList(final Character character) {
        final List<Starship> starships = new ArrayList<>();
        character.getStarships().forEach(starship -> starships.add(mapStarShip(starship)));
        return starships;
    }

    private Starship mapStarShip(final String starship) {
        return starWarsClient.getStarships(getId(starship));
    }

    private Long getId(final String url) {
        final String[] path = url.split("/");
        return Long.valueOf(path[path.length - 1]);
    }
}
