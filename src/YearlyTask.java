import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfMonth() == dateTime.getDayOfMonth() && getDateTime().getMonthValue() == dateTime.getMonthValue();
    }

    @Override
    public LocalDate getNextDate(LocalDateTime dateTime) {
        LocalDate localdate = dateTime.toLocalDate();
        return localdate.plusYears(1);
    }
    @Override
    public String toString() {
        return super.toString() + " ежегодный повтор";
    }
}
