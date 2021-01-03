package star.wars.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private int count;
    private int pages;
    private List<CharacterDescription> elements;

    @Override
    public String toString() {
        return "{count=" + count +
                ", pages=" + pages +
                ", elements=" + elements +
                '}';
    }
}
