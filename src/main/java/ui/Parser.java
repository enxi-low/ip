package ui;

import command.ByeCommand;
import command.Command;
import command.DeadlineCommand;
import command.DeleteCommand;
import command.EventCommand;
import command.ListCommand;
import command.MarkCommand;
import command.TodoCommand;
import command.UnmarkCommand;
import exception.LunaException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parse(String command) {
        try {
            if (command.equals("bye")) {
                return new ByeCommand();
            } else if (command.equals("list")) {
                return new ListCommand();
            } else if (command.startsWith("mark ")) {
                return new MarkCommand(Integer.parseInt(command.substring(5)));
            } else if (command.startsWith("unmark ")) {
                return new UnmarkCommand(Integer.parseInt(command.substring(7)));
            } else if (command.startsWith("delete ")) {
                return new DeleteCommand(Integer.parseInt(command.substring(7)));
            } else if (command.startsWith("todo ")) {
                return new TodoCommand(command.substring(5));
            } else if (command.startsWith("deadline ")) {
                String[] nameAndDeadline = command.substring(9).split(" /by ");
                return new DeadlineCommand(nameAndDeadline[0], LocalDate.parse(nameAndDeadline[1]));
            } else if (command.startsWith("event ")) {
                String[] nameAndRest = command.substring(6).split(" /from ");
                String[] fromAndTo = nameAndRest[1].split(" /to ");
                return new EventCommand(nameAndRest[0], LocalDate.parse(fromAndTo[0]), LocalDate.parse(fromAndTo[1]));
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