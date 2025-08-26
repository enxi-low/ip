package command;

import exception.LunaException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

import java.io.IOException;

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