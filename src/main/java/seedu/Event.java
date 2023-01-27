package seedu;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String description, String start, String end) {
        super(description);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm");
        this.start = LocalDateTime.parse(start, format);
        this.end = LocalDateTime.parse(end, format);

    }

    @Override
    public String toString() {
        String startFormat =  this.start.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
        String endFormat = this.end.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
        return "[E]" + super.toString() + " (from:" + startFormat + " to:" + endFormat + ")";
    }

    @Override
    public String toStoreString() {
        return "E | " + super.toStoreString() + " |" + this.start + "| " + this.end + "\n";
    }

}


