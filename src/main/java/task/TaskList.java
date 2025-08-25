package task;

import exception.LunaException;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
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
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void delete(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            throw new LunaException("Task " + taskNumber + " doesn't exist.");
        }
        Task deletedTask = tasks.remove(taskNumber - 1);

        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + deletedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void markAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).markAsDone();
    }

    public void unmarkAsDone(int taskNumber) {
        tasks.get(taskNumber - 1).unmarkAsDone();
    }
}