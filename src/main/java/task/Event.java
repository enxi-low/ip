package task;

import java.time.LocalDate;

public class Event extends Task {
    private final LocalDate start;
    private final LocalDate end;

    public Event(String name, LocalDate start, LocalDate end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String taskType() {
        return "event";
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), start, end);
    }
}