package luna.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import luna.command.ByeCommand;
import luna.command.Command;
import luna.command.DeadlineCommand;
import luna.command.DeleteCommand;
import luna.command.EventCommand;
import luna.command.FindCommand;
import luna.command.FixedDurationTaskCommand;
import luna.command.ListCommand;
import luna.command.MarkCommand;
import luna.command.TodoCommand;
import luna.command.UnmarkCommand;
import luna.exception.LunaException;

/**
 * Parses the user input.
 */
public class Parser {
    /**
     * Returns the {@code Command} from the user input.
     *
     * @param command User input
     */
    public static Command parse(String command) {
        try {
            if (command.equals("bye")) {
                return new ByeCommand();
            } else if (command.equals("list")) {
                return new ListCommand();
            } else if (command.startsWith("mark ")) {
                return new MarkCommand(Integer.parseInt(getParameters(command, "mark ").get(0)));
            } else if (command.startsWith("unmark ")) {
                return new UnmarkCommand(Integer.parseInt(getParameters(command, "unmark ").get(0)));
            } else if (command.startsWith("delete ")) {
                return new DeleteCommand(Integer.parseInt(getParameters(command, "delete ").get(0)));
            } else if (command.startsWith("todo ")) {
                return new TodoCommand(getParameters(command, "todo ").get(0));
            } else if (command.startsWith("deadline ")) {
                ArrayList<String> parameters = getParameters(command, "deadline ", " /by ");
                return new DeadlineCommand(parameters.get(0), LocalDate.parse(parameters.get(1)));
            } else if (command.startsWith("event ")) {
                ArrayList<String> parameters = getParameters(command, "event ", " /from ", " /to ");
                return new EventCommand(parameters.get(0), LocalDate.parse(parameters.get(1)),
                        LocalDate.parse(parameters.get(2)));
            } else if (command.startsWith("find ")) {
                return new FindCommand(getParameters(command, "find ").get(0));
            } else if (command.startsWith("task ")) {
                ArrayList<String> parameters = getParameters(command, "task ", " /duration ");
                return new FixedDurationTaskCommand(
                        parameters.get(0),
                        Duration.ofHours(Long.parseLong(parameters.get(1))));
            } else {
                throw new LunaException("I'm sorry, but I don't know what that means :-(");
            }
        } catch (NumberFormatException e) {
            throw new LunaException("The argument needs to be an integer");
        } catch (DateTimeParseException e) {
            throw new LunaException("Please provide a valid date in yyyy-mm-dd format.");
        }
    }

    private static ArrayList<String> getParameters(String input, String... separators) {
        assert input.startsWith(separators[0]);

        ArrayList<String> result = new ArrayList<>();
        String rest = input.substring(separators[0].length());
        for (int i = 1; i < separators.length; i++) {
            String[] splitBySeparator = rest.split(separators[i], 2);
            if (splitBySeparator.length != 2) {
                throw new LunaException("Missing arguments.");
            }
            result.add(splitBySeparator[0]);
            rest = splitBySeparator[1];
        }
        result.add(rest);

        assert result.size() == separators.length;
        return result;
    }
}
