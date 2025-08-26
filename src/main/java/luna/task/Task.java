package luna.task;

import java.io.Serializable;

import luna.exception.LunaException;

public abstract class Task implements Serializable {
    private final String name;
    private boolean isDone;

    public Task(String name) throws LunaException {
        if (name.isEmpty()) {
            throw new LunaException("The description of a " + taskType() + " cannot be empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    public abstract String taskType();

    public String markAsDone() {
        isDone = true;

        return "Nice! I've marked this task as done:\n  " + this;
    }

    public String unmarkAsDone() {
        isDone = false;

        return "OK, I've marked this task as not done yet:\n  " + this;
    }
}