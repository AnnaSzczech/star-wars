package star.wars.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private String date;
    private String message;
    private List<String> details;

    public ErrorResponse(final String message, final List<String> details) {
        this.message = message;
        this.details = details;
        date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
