package luna.command;

import java.time.LocalDate;

import luna.storage.Storage;
import luna.task.Deadline;
import luna.task.TaskList;

/**
 * Represents the {@code deadline} command.
 */
public class DeadlineCommand extends Command {
    private final String name;
    private final LocalDate deadline;

    public DeadlineCommand(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    @Override
    public String execute(TaskList taskList, Storage<TaskList> storage) {
        Deadline newTask = new Deadline(name, deadline);
        taskList.add(newTask);
        saveTaskList(taskList, storage);
        return "Got it. I've added this task:\n  " + newTask + "\nNow you have " + taskList.getSize()
                + " tasks in the list.";
    }

    @Override
    public boolean isExit() {
        return false;
    }
}