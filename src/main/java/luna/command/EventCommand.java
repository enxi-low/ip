package luna.command;

import java.time.LocalDate;

import luna.storage.Storage;
import luna.task.Event;
import luna.task.TaskList;
import luna.ui.Ui;

<<<<<<< HEAD
import java.time.LocalDate;

/**
 * Represents the {@code event} command.
 */
=======
>>>>>>> branch-A-CodingStandard
public class EventCommand extends Command {
    private final String name;
    private final LocalDate start;
    private final LocalDate end;

    public EventCommand(String name, LocalDate start, LocalDate end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage<TaskList> storage) {
        ui.show(taskList.add(new Event(name, start, end)));
        saveTaskList(taskList, storage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}