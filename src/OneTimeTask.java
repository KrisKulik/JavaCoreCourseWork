import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return true;
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        return LocalDate.from(getDateTime().plusDays(1));
    }
}
