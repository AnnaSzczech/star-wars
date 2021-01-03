package star.wars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Homeworld {
    private String name;
    @JsonProperty(value = "rotationPeriod")
    private String rotation_period;
    @JsonProperty(value = "orbitalPeriod")
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonProperty(value = "surfaceWater")
    private String surface_water;
    private String population;

    @Override
    public String toString() {
        return "{name=" + name +
                ", diameter=" + diameter +
                ", climate=" + climate +
                ", gravity=" + gravity +
                ", terrain=" + terrain +
                ", population=" + population +
                ", rotationPeriod=" + rotation_period +
                ", orbitalPeriod=" + orbital_period +
                ", surfaceWater=" + surface_water +
                '}';
    }
}
