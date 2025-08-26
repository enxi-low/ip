package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.ui.Ui;

/**
 * Represents the {@code bye} command.
 */
public class ByeCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.showFarewell();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}