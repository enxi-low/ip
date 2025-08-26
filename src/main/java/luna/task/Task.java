package luna.task;

import java.io.Serializable;

import luna.exception.LunaException;

/**
 * Represents a task that has a name and a done status.
 */
public abstract class Task implements Serializable {
    private final String name;
    private boolean isDone;

    public Task(String name) throws LunaException {
        if (name.isEmpty()) {
            throw new LunaException("The description of a " + taskType() + " cannot be empty");
        }
        this.name = name;
    }

    /**
     * Returns the {@code String} representation of the {@code Task}.
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        } else {
            return "[ ] " + name;
        }
    }

    /**
     * Returns the {@code String} representation of the {@code Task} type.
     */
    public abstract String taskType();

    /**
     * Returns the {@code String} description of the action of marking the task as done.
     * Marks the task as done.
     */
    public String markAsDone() {
        isDone = true;

        return "Nice! I've marked this task as done:\n  " + this;
    }

    /**
     * Returns the {@code String} description of the action of unmarking the task as done.
     * Unmarks the task as done.
     */
    public String unmarkAsDone() {
        isDone = false;

        return "OK, I've marked this task as not done yet:\n  " + this;
    }

    public boolean contains(String search) {
        return name.contains(search);
    }
}