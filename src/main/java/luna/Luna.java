package luna;

import task.*;

import java.util.Scanner;

public class Luna {
    public static void main(String[] args) {
        TaskList list = new TaskList();

        printSeparator();
        System.out.println("Hello! I'm Luna.");
        System.out.println("What can I do for you?");
        printSeparator();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            printSeparator();
            if (command.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                printSeparator();
                break;
            } else if (command.equals("list")) {
                System.out.println(list);
            } else if (command.startsWith("mark")) {
                list.markAsDone(Integer.parseInt(command.substring(5)));
            } else if (command.startsWith("unmark")) {
                list.unmarkAsDone(Integer.parseInt(command.substring(7)));
            } else if (command.startsWith("todo")) {
                list.add(new ToDo(command.substring(5)));
            } else if (command.startsWith("deadline")) {
                String[] nameAndDeadline = command.substring(9).split(" /by ");
                list.add(new Deadline(nameAndDeadline[0], nameAndDeadline[1]));
            } else if (command.startsWith("event")) {
                String[] nameAndRest = command.substring(6).split(" /from ");
                String[] fromAndTo = nameAndRest[1].split(" /to ");
                list.add(new Event(nameAndRest[0], fromAndTo[0], fromAndTo[1]));
            } else {
                list.add(new Task(command));
            }
            printSeparator();
        }
        scanner.close();
    }

    private static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}