package luna.command;

import java.io.IOException;

import luna.exception.LunaException;
import luna.storage.Storage;
import luna.task.TaskList;
import luna.ui.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage<TaskList> storage);

    public abstract boolean isExit();

    public void saveTaskList(TaskList taskList, Storage<TaskList> storage) {
        try {
            storage.save(taskList);
        } catch (IOException e) {
            throw new LunaException("Saving failed.");
        }
    }
}