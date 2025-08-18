public class Task {
    private final String name;
    private boolean isDone;

    public Task(String name) {
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