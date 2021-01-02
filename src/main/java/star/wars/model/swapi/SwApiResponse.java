package star.wars.model.swapi;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SwApiResponse {
    private int count;
    private List<Character> results;
}
