package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.task.ToDo;

/**
 * Represents the {@code todo} command.
 */
public class TodoCommand extends Command {
    private final String name;

    public TodoCommand(String name) {
        this.name = name;
    }

    @Override
    public String execute(TaskList taskList, Storage<TaskList> storage) {
        ToDo newTask = new ToDo(name);
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
