package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.ui.Ui;

public class FindCommand extends Command {
    private final String search;

    public FindCommand(String search) {
        this.search = search;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.showMatchingTasks(taskList.find(search));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}