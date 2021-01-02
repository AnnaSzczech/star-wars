package star.wars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Starship {
    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty(value = "costInCredits")
    private String cost_in_credits;
    private String length;
    @JsonProperty(value = "maxAtmosphericSpeed")
    private String max_atmosphering_speed;
    private String crew;
    private String passengers;
    @JsonProperty(value = "cargoCapacity")
    private String cargo_capacity;
    private String consumables;
    @JsonProperty(value = "hyperdriveRating")
    private String hyperdrive_rating;
    @JsonProperty(value = "mglt")
    private String MGLT;
    @JsonProperty(value = "starshipClass")
    private String starship_class;
}
