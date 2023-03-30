package diary.Tasks;

import diary.Type;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    private String name;
    private String description;
    private final Type type;
    private final int id;
    private static int counter = 0;
    protected LocalDateTime date;

    public Task(String name, String description, Type type, LocalDateTime date) {
        this.name = setName(name);
        this.description = setDescription(description);
        this.type = type;
        this.date = date;
        counter++;
        this.id = counter;
    }

    public String setName(String name) {
        if ((name != null && !name.trim().isEmpty())) {
            this.name = name;
        } else {
            System.out.println("Введите корректно имя!");
        }
        return name;
    }

    public String setDescription(String description) {
        if ((name != null && !name.trim().isEmpty())) {
            this.description = description;
        } else {
            System.out.println("Введите корректно описание!");
        }
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public abstract String getTypeRepeatability();

    @Override
    public String toString() {
        return "\n\"" + name + "\"" +
                ", необходимо " + description +
                ". " + type + ", дата выполнения: " + date + ", повторяемость: " + getTypeRepeatability();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(
                description, task.description) && type == task.type && Objects.equals(date,
                task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, id, date);
    }
}
