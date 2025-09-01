package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.task.ToDo;
import luna.ui.Ui;

/**
 * Represents the {@code todo} command.
 */
public class TodoCommand extends Command {
    private final String name;

    public TodoCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ToDo newTask = new ToDo(name);
        taskList.add(newTask);
        saveTaskList(taskList, storage);
        ui.showAddNewTask(newTask, taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}