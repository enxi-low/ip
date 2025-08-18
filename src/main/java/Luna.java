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
            System.out.println(command);
            printSeparator();
        }
        scanner.close();
    }

    public static void printSeparator() {
        System.out.println("-------------------------------------");
    }
}