import exception.LunaException;
import save.FileHandler;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;

import java.io.IOException;
import java.util.Scanner;

public class Luna {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("./data/luna.txt");
        TaskList list;
        try {
            list = fileHandler.load();
        } catch (IOException | ClassNotFoundException e) {
            list = new TaskList();
        }

        printSeparator();
        System.out.println("Hello! I'm Luna.");
        System.out.println("What can I do for you?");
        printSeparator();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            printSeparator();
            try {
                if (command.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    printSeparator();
                    break;
                } else if (command.equals("list")) {
                    System.out.println(list);
                } else if (command.startsWith("mark")) {
                    list.markAsDone(Integer.parseInt(command.substring(5)));
                    fileHandler.save(list);
                } else if (command.startsWith("unmark")) {
                    list.unmarkAsDone(Integer.parseInt(command.substring(7)));
                    fileHandler.save(list);
                } else if (command.startsWith("delete")) {
                    list.delete(Integer.parseInt(command.substring(7)));
                    fileHandler.save(list);
                } else if (command.startsWith("todo")) {
                    list.add(new ToDo(command.substring(5)));
                    fileHandler.save(list);
                } else if (command.startsWith("deadline")) {
                    String[] nameAndDeadline = command.substring(9).split(" /by ");
                    list.add(new Deadline(nameAndDeadline[0], nameAndDeadline[1]));
                    fileHandler.save(list);
                } else if (command.startsWith("event")) {
                    String[] nameAndRest = command.substring(6).split(" /from ");
                    String[] fromAndTo = nameAndRest[1].split(" /to ");
                    list.add(new Event(nameAndRest[0], fromAndTo[0], fromAndTo[1]));
                    fileHandler.save(list);
                } else {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (LunaException e) {
                System.out.println("OOPS!!! " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("OOPS!!! The argument needs to be an integer");
            } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
                System.out.println("OOPS!!! Missing arguments.");
            } catch (IOException e) {
                System.out.println("OOPS!!! Saving failed.");
            }
            printSeparator();
        }
        scanner.close();
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}