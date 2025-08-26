import command.Command;
import exception.LunaException;
import storage.Storage;
import task.TaskList;
import ui.Parser;
import ui.Ui;

import java.io.IOException;
import java.util.Scanner;

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