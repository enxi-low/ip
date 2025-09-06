package luna.command;

import luna.storage.Storage;
import luna.task.TaskList;

/**
 * Represents the {@code list} command.
 */
public class ListCommand extends IntermediateCommand {
    @Override
    public String execute(TaskList taskList, Storage<TaskList> storage) {
        return taskList.toString();
    }
}
