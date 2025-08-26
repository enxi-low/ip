package command;

import storage.Storage;
import task.Event;
import task.TaskList;
import ui.Ui;

import java.time.LocalDate;

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