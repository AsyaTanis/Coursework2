package diary;

public enum Type {
    PERSONAL_TASK("\"личная\""),
    WORK_TASK("\"рабочая\"");

    private final String typeOfTask;

    Type(String typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }


    @Override
    public String toString() {
        return "Тип задачи: " + typeOfTask;
    }
}
