package task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        int taskCount = tasks.size();
        for (int i = 0; i < taskCount; i++) {
            string.append(i + 1).append(". ").append(tasks.get(i));
            if (i != taskCount - 1) {
                string.append("\n");
            }
        }
        return string.toString();
    }

    public void add(Task task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }

    public void markAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markAsDone();
    }

    public void unmarkAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).unmarkAsDone();
    }
}