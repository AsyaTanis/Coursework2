package diary;

import diary.Tasks.DailyTask;
import diary.Tasks.MonthlyTask;
import diary.Tasks.OneTimeTask;
import diary.Tasks.Task;
import diary.Tasks.WeeklyTask;
import diary.Tasks.YearlyTask;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class Diary {

    Map<Integer, Task> tasksForDay = new HashMap<>();
    private final Map<Integer, Task> tasks;
    private Task task;

    public Diary() {
        this.tasks = new HashMap<>();
    }

    public boolean addMapTask(Task task) {
        return tasks.put(task.getId(), task) == null;
    }

    public void removeMapTask(int id) {
        if (getTasks().containsKey(id)) {
            tasks.remove(id);
        }
    }

    public List<Task> getTaskForDay(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Entry<Integer, Task> entry : tasks.entrySet()) {
            Task task = entry.getValue();
            if (task instanceof Appear && ((Appear) task).appearsIn(date)
                    || !(task instanceof Appear) && task.getDate().toLocalDate().equals(date)) {
                result.add(task);
            }
        }
        result.sort(Comparator.comparing(Task::getDate));
        return result;
    }

    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Diary diary = (Diary) o;
        return Objects.equals(tasksForDay, diary.tasksForDay) && Objects.equals(tasks,
                diary.tasks) && Objects.equals(task, diary.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasksForDay, tasks, task);
    }

    @Override
    public String toString() {
        return "" + tasks;
    }
}
