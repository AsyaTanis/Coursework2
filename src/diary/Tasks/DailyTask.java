package diary.Tasks;

import diary.Appear;
import diary.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class DailyTask extends Task implements Appear {

    public DailyTask(String name, String description, Type type, LocalDateTime date) {
        super(name, description, type, date);
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return date.toLocalDate().isBefore(ChronoLocalDate.from(dateTime))
                || date.toLocalDate().equals(dateTime);
    }

    @Override
    public String getTypeRepeatability() {
        return "ежедневная ";
    }
}
