package task;

import exception.LunaException;

public abstract class Task {
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

    public void markAsDone() {
        isDone = true;

        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + this);
    }

    public void unmarkAsDone() {
        isDone = false;

        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + this);
    }
}