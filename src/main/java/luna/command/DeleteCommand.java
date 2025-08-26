package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;
import luna.ui.Ui;

public class DeleteCommand extends Command {
    private final int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.show(taskList.delete(taskNumber));
        saveTaskList(taskList, storage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}