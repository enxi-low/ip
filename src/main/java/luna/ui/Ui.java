package luna.ui;

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