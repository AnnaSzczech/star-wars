package star.wars.model.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Response {
    private int count;
    private int pages;
    private List<CharacterDescription> elements;
}
