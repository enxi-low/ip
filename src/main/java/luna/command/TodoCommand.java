package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.task.ToDo;
import luna.ui.Ui;

public class TodoCommand extends Command {
    private final String name;

    public TodoCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.show(taskList.add(new ToDo(name)));
        saveTaskList(taskList, storage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}