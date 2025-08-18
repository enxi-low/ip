import java.util.Scanner;

public class Luna {
    public static void main(String[] args) {
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
            } else {
                System.out.println(command);
                printSeparator();
            }
        }
        scanner.close();
    }

    public static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}