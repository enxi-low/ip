import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            string.append(i + 1).append(". ").append(tasks.get(i));
        }
        return string.toString();
    }

    public void add(Task task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }
}