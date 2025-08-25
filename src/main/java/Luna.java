import exception.LunaException;
import storage.Storage;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;
import ui.Ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
                if (command.equals("bye")) {
                    ui.showFarewell();
                    break;
                } else if (command.equals("list")) {
                    ui.show(list);
                } else if (command.startsWith("mark")) {
                    ui.show(list.markAsDone(Integer.parseInt(command.substring(5))));
                    storage.save(list);
                } else if (command.startsWith("unmark")) {
                    ui.show(list.unmarkAsDone(Integer.parseInt(command.substring(7))));
                    storage.save(list);
                } else if (command.startsWith("delete")) {
                    ui.show(list.delete(Integer.parseInt(command.substring(7))));
                    storage.save(list);
                } else if (command.startsWith("todo")) {
                    ui.show(list.add(new ToDo(command.substring(5))));
                    storage.save(list);
                } else if (command.startsWith("deadline")) {
                    String[] nameAndDeadline = command.substring(9).split(" /by ");
                    ui.show(list.add(new Deadline(nameAndDeadline[0], LocalDate.parse(nameAndDeadline[1]))));
                    storage.save(list);
                } else if (command.startsWith("event")) {
                    String[] nameAndRest = command.substring(6).split(" /from ");
                    String[] fromAndTo = nameAndRest[1].split(" /to ");
                    ui.show(list.add(new Event(nameAndRest[0], LocalDate.parse(fromAndTo[0]),
                            LocalDate.parse(fromAndTo[1]))));
                    storage.save(list);
                } else {
                    ui.showError("I'm sorry, but I don't know what that means :-(");
                }
            } catch (LunaException e) {
                ui.showError(e);
            } catch (NumberFormatException e) {
                ui.showError("The argument needs to be an integer");
            } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                ui.showError("Missing arguments.");
            } catch (IOException e) {
                ui.showError("Saving failed.");
            } catch (DateTimeParseException e) {
                ui.showError("Please provide a valid date in yyyy-mm-dd format.");
            }
        }
        scanner.close();
    }
}