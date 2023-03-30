package diary.Tasks;

import diary.Appear;
import diary.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Appear {

    public YearlyTask(String name, String description, Type type, LocalDateTime date) {
        super(name, description, type, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return date.toLocalDate().equals(dateTime) || date.toLocalDate().plusYears(dateTime.getYear() -
                date.toLocalDate().getYear()).equals(dateTime);
    }

    @Override
    public String getTypeRepeatability() {
        return "ежегодная ";
    }
}
