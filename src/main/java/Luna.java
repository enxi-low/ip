import exception.LunaException;
import storage.Storage;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;
import ui.Parser;
import ui.Ui;

import java.io.IOException;
import java.time.LocalDate;
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

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            try {
                Object[] arguments = Parser.parse(command);
                if (arguments[0].equals("bye")) {
                    ui.showFarewell();
                    break;
                }

                switch ((String) arguments[0]) {
                case "list":
                    ui.show(list);
                    break;
                case "mark":
                    ui.show(list.markAsDone((int) arguments[1]));
                    storage.save(list);
                    break;
                case "unmark":
                    ui.show(list.unmarkAsDone((int) arguments[1]));
                    storage.save(list);
                    break;
                case "delete":
                    ui.show(list.delete((int) arguments[1]));
                    storage.save(list);
                    break;
                case "todo":
                    ui.show(list.add(new ToDo((String) arguments[1])));
                    storage.save(list);
                    break;
                case "deadline":
                    ui.show(list.add(new Deadline((String) arguments[1], (LocalDate) arguments[2])));
                    storage.save(list);
                    break;
                case "event":
                    ui.show(list.add(
                            new Event((String) arguments[1], (LocalDate) arguments[2], (LocalDate) arguments[3])));
                    storage.save(list);
                    break;
                default:
                    throw new LunaException("I'm sorry, but I don't know what that means :-(");
                }
            } catch (LunaException e) {
                ui.showError(e);
            } catch (IOException e) {
                ui.showError("Saving failed.");
            }
        }
        scanner.close();
    }
}