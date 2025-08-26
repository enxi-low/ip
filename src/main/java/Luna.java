import command.Command;
import exception.LunaException;
import storage.Storage;
import task.TaskList;
import ui.Parser;
import ui.Ui;

import java.io.IOException;
import java.util.Scanner;

public class Luna {
    public static void main(String[] args) {
        Ui ui = new Ui();
        Storage<TaskList> storage = new Storage<>("./data/luna.txt");
        TaskList list;
        try {
            list = storage.load();
        } catch (IOException | ClassNotFoundException e) {
            list = new TaskList();
        }

        ui.showWelcome();

        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        while (!isExit) {
            String userCommand = scanner.nextLine();
            try {
                Command command = Parser.parse(userCommand);
                command.execute(list, ui, storage);
                isExit = command.isExit();
            } catch (LunaException e) {
                ui.showError(e);
            }
        }
        scanner.close();
    }
}