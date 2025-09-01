package luna.ui;

import luna.task.Task;
import luna.task.TaskList;

/**
 * Represents the user interface of the program.
 */
public class Ui {
    /**
     * Greets the user.
     */
    public void showWelcome() {
        printBlock("Hello! I'm Luna.\nWhat can I do for you?");
    }

    /**
     * Says goodbye to the user.
     */
    public void showFarewell() {
        printBlock("Bye. Hope to see you again soon!");
    }

    public void showAddNewTask(Task task, TaskList taskList) {
        printBlock("Got it. I've added this task:\n  " + task + "\nNow you have " + taskList.getSize()
                + " tasks in the list.");
    }

    public void showDeleteTask(Task task, TaskList taskList) {
        printBlock("Noted. I've removed this task:\n  " + task + "\nNow you have " + taskList.getSize()
                + " tasks in the list.");
    }

    public void showMatchingTasks(TaskList tasks) {
        printBlock("Here are the matching tasks in your list:\n" + tasks);
    }

    public void showMarkAsDone(Task task) {
        printBlock("Nice! I've marked this task as done:\n  " + task);
    }

    public void showUnmarkAsDone(Task task) {
        printBlock("OK, I've marked this task as not done yet:\n  " + task);
    }

    /**
     * Show the contents of an object to the user.
     */
    public void show(Object obj) {
        printBlock(obj.toString());
    }

    /**
     * Display an error message to the user.
     */
    public void showError(String message) {
        printBlock("OOPS!!! " + message);
    }

    /**
     * Display an error message to the user.
     */
    public void showError(Exception error) {
        showError(error.getMessage());
    }

    private void printBlock(String content) {
        printSeparator();
        System.out.println(content);
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}