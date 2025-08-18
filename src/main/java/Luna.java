import java.util.Scanner;

public class Luna {
    public static void main(String[] args) {
        UserList list = new UserList();

        printSeparator();
        System.out.println("Hello! I'm Luna.");
        System.out.println("What can I do for you?");
        printSeparator();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.next();
            printSeparator();
            if (command.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                printSeparator();
                break;
            } else if (command.equals("list")) {
                list.print();
            } else {
                list.add(command);
            }
            printSeparator();
        }
        scanner.close();
    }

    public static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}