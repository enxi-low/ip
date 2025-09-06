package luna.command;

import java.time.LocalDate;

import luna.storage.Storage;
import luna.task.Event;
import luna.task.TaskList;

/**
 * Represents the {@code event} command.
 */
public class EventCommand extends IntermediateCommand {
    private final String name;
    private final LocalDate start;
    private final LocalDate end;

    public EventCommand(String name, LocalDate start, LocalDate end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public String execute(TaskList taskList, Storage<TaskList> storage) {
        Event newTask = new Event(name, start, end);
        taskList.add(newTask);
        saveTaskList(taskList, storage);
        return "Got it. I've added this task:\n  " + newTask + "\nNow you have " + taskList.getSize()
                + " tasks in the list.";
    }
}
