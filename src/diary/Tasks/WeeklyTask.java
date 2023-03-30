package diary.Tasks;

import diary.Appear;
import diary.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class WeeklyTask extends Task implements Appear {

    public WeeklyTask(String name, String description, Type type, LocalDateTime date) {
        super(name, description, type, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return date.toLocalDate().equals(dateTime) || (date.toLocalDate().isBefore(
                ChronoLocalDate.from(dateTime)) &&
                date.toLocalDate().getDayOfWeek().equals(dateTime.getDayOfWeek()));
    }
    @Override
    public String getTypeRepeatability() {
        return "еженедельная ";
    }

}