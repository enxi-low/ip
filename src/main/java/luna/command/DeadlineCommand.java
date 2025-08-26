package luna.command;

import java.time.LocalDate;

import luna.storage.Storage;
import luna.task.Deadline;
import luna.task.TaskList;
import luna.ui.Ui;

/**
 * Represents the {@code deadline} command.
 */
=======
        >>>>>>>branch-A-CodingStandard

public class DeadlineCommand extends Command {
    private final String name;
    private final LocalDate deadline;

    public DeadlineCommand(String name, LocalDate deadline) {
        this.name = name;
        this.deadline = deadline;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.show(taskList.add(new Deadline(name, deadline)));
        saveTaskList(taskList, storage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}