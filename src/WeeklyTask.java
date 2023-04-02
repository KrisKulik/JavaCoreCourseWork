import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfWeek().equals(dateTime.getDayOfWeek());
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        LocalDate localDate = dateTime.toLocalDate();
        return localDate.plusDays(7);
    }

    @Override
    public String toString() {
        return super.toString() + " еженедельный повтор";
    }
}
