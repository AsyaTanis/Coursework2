package diary.Tasks;

import diary.Appear;
import diary.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task implements Appear {

    public OneTimeTask(String name, String description, Type type, LocalDateTime date) {
        super(name, description, type, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return date.toLocalDate().equals(dateTime);
    }

    @Override
    public String getTypeRepeatability() {
        return "однократная ";
    }
}
