package luna.ui;

import java.io.IOException;
import java.util.Scanner;

import luna.command.Command;
import luna.exception.LunaException;
import luna.storage.Storage;
import luna.task.TaskList;


/**
 * Represents the chatbot.
 */
public class Luna {
    private final Storage<TaskList> storage;
    private TaskList taskList;
    private final Ui ui = new Ui();

    public Luna(String filePath) {
        storage = new Storage<>(filePath);
        try {
            taskList = storage.load();
        } catch (IOException | ClassNotFoundException e) {
            taskList = new TaskList();
        }
    }

    /**
     * Runs the program.
     */
    public void run() {
        ui.showWelcome();

        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        while (!isExit) {
            String userCommand = scanner.nextLine();
            try {
                Command command = Parser.parse(userCommand);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (LunaException e) {
                ui.showError(e);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Luna("./data/luna.txt").run();
    }
}