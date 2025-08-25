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

    public String add(Task task) {
        tasks.add(task);
        return "Got it. I've added this task:\n  " + task + "\nNow you have " + tasks.size() + " tasks in the list.";
    }

    public String delete(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            throw new LunaException("Task " + taskNumber + " doesn't exist.");
        }
        Task deletedTask = tasks.remove(taskNumber - 1);

        return "Noted. I've removed this task:\n  " + deletedTask + "\nNow you have " + tasks.size()
                + " tasks in the list.";
    }

    public String markAsDone(int taskNumber) {
        return tasks.get(taskNumber - 1).markAsDone();
    }

    public String unmarkAsDone(int taskNumber) {
        return tasks.get(taskNumber - 1).unmarkAsDone();
    }
}