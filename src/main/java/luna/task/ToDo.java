package luna.task;

public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String taskType() {
        return "todo";
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}