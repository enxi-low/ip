package task;

import exception.LunaException;

public class Event extends Task {
    private final String start;
    private final String end;

    public Event(String name, String start, String end) {
        super(name);
        if (start.isEmpty()) {
            throw new LunaException("The start of an event cannot be empty.");
        } else if (end.isEmpty()) {
            throw new LunaException("The end of an event cannot be empty.");
        }
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