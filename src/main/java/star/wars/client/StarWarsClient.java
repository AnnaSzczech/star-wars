package star.wars.client;

import feign.Param;
import feign.RequestLine;
import star.wars.model.Homeworld;
import star.wars.model.Starship;
import star.wars.model.swapi.Character;
import star.wars.model.swapi.SwApiResponse;

public interface StarWarsClient {
    @RequestLine("GET /people/?page={pageNumber}")
    SwApiResponse getCharacters(@Param("pageNumber") Long pageNumber);

    @RequestLine("GET /planets/{id}")
    Homeworld getPlanets(@Param("id") Long id);

    @RequestLine("GET /starships/{id}")
    Starship getStarships(@Param("id") Long id);

    @RequestLine("GET /people/{id}")
    Character getCharacter(@Param("id") Long id);
}
