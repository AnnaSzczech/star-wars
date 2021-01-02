package star.wars.model.swapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Character {
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
    @JsonIgnore
    private String homeworld;
    @JsonIgnore
    private List<String> starships;
}
