package ui;

import exception.LunaException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Object[] parse(String command) {
        try {
            if (command.equals("bye") || command.equals("list")) {
                return new String[]{command};
            } else if (command.startsWith("mark ")) {
                return new Object[]{"mark", Integer.parseInt(command.substring(5))};
            } else if (command.startsWith("unmark ")) {
                return new Object[]{"mark", Integer.parseInt(command.substring(7))};
            } else if (command.startsWith("delete ")) {
                return new Object[]{"delete", Integer.parseInt(command.substring(7))};
            } else if (command.startsWith("todo ")) {
                return new String[]{"todo", command.substring(5)};
            } else if (command.startsWith("deadline ")) {
                String[] nameAndDeadline = command.substring(9).split(" /by ");
                return new Object[]{"deadline", nameAndDeadline[0], LocalDate.parse(nameAndDeadline[1])};
            } else if (command.startsWith("event ")) {
                String[] nameAndRest = command.substring(6).split(" /from ");
                String[] fromAndTo = nameAndRest[1].split(" /to ");
                return new Object[]{"event", nameAndRest[0], LocalDate.parse(fromAndTo[0]),
                        LocalDate.parse(fromAndTo[1])};
            } else {
                throw new LunaException("I'm sorry, but I don't know what that means :-(");
            }
        } catch (NumberFormatException e) {
            throw new LunaException("The argument needs to be an integer");
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            throw new LunaException("Missing arguments.");
        } catch (DateTimeParseException e) {
            throw new LunaException("Please provide a valid date in yyyy-mm-dd format.");
        }
    }
}