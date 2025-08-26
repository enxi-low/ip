package luna.task;

import luna.exception.LunaException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a list of tasks.
 */
public class TaskList implements Serializable {
    private final ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Returns the {@code String} representation of the {@code TaskList}.
     */
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

    /**
     * Adds a {@code Task} to the {@code TaskList}.
     */
    public String add(Task task) {
        tasks.add(task);
        return "Got it. I've added this task:\n  " + task + "\nNow you have " + tasks.size() + " tasks in the list.";
    }

    /**
     * Deletes a {@code Task} from the {@code TaskList}.
     * @param taskNumber Task number of the task to be deleted.
     */
    public String delete(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            throw new LunaException("Task " + taskNumber + " doesn't exist.");
        }
        Task deletedTask = tasks.remove(taskNumber - 1);

        return "Noted. I've removed this task:\n  " + deletedTask + "\nNow you have " + tasks.size()
                + " tasks in the list.";
    }

    /**
     * Marks a {@code Task} from the {@code TaskList} as done.
     * @param taskNumber Task number of the task to be marked as done.
     */
    public String markAsDone(int taskNumber) {
        return tasks.get(taskNumber - 1).markAsDone();
    }

    /**
     * Unmarks a {@code Task} from the {@code TaskList} as done.
     * @param taskNumber Task number of the task to be unmarked as done.
     */
    public String unmarkAsDone(int taskNumber) {
        return tasks.get(taskNumber - 1).unmarkAsDone();
    }
}