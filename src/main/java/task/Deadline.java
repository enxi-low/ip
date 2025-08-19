package task;

import exception.LunaException;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String name, String deadline) {
        super(name);
        if (deadline.isEmpty()) {
            throw new LunaException("The deadline of a deadline cannot be empty.");
        }
        this.deadline = deadline;
    }

    @Override
    public String taskType() {
        return "deadline";
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), deadline);
    }
}