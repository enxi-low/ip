package ui;

public class Ui {
    public void showWelcome() {
        printBlock("Hello! I'm Luna.\nWhat can I do for you?");
    }

    public void showFarewell() {
        printBlock("Bye. Hope to see you again soon!");
    }

    public void show(Object obj) {
        printBlock(obj.toString());
    }

    public void showError(String message) {
        printBlock("OOPS!!! " + message);
    }

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