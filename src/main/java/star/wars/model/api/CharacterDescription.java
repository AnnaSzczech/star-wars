package star.wars.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.wars.model.Homeworld;
import star.wars.model.Starship;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CharacterDescription {
    private Long id;
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hairColor")
    private String hair_color;
    @JsonProperty("skinColor")
    private String skin_color;
    @JsonProperty("eyeColor")
    private String eye_color;
    @JsonProperty("birthYear")
    private String birth_year;
    private String gender;
    private Homeworld homeworld;
    private List<Starship> starships;
}
