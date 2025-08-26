package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.show(taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}