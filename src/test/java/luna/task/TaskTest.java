package luna.task;

import luna.exception.LunaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TaskTest {
    @Test
    public void constructor_emptyName_exceptionThrown() {
        Assertions.assertThrows(LunaException.class, () -> new ToDo(""));
        Assertions.assertThrows(LunaException.class, () -> new Deadline("", LocalDate.now()));
        Assertions.assertThrows(LunaException.class, () -> new Event("", LocalDate.now(), LocalDate.now()));
    }

    @Test
    public void constructor_nonEmptyName_success() {
        Assertions.assertDoesNotThrow(() -> new ToDo("testing"));
        Assertions.assertDoesNotThrow(() -> new Deadline("a", LocalDate.now()));
        Assertions.assertDoesNotThrow(() -> new Event("JNaDJNKNj", LocalDate.now(), LocalDate.now()));
    }

    @Test
    public void markAsDone() {
        ToDo todo = new ToDo("hi");
        Deadline deadline = new Deadline("HOMEWORK", LocalDate.now());
        Event event = new Event("Some event", LocalDate.now(), LocalDate.now());

        for (boolean toRepeat = true; toRepeat; toRepeat = false) {
            todo.markAsDone();
            deadline.markAsDone();
            event.markAsDone();

            Assertions.assertTrue(todo.toString().startsWith("[T][X]"));
            Assertions.assertTrue(deadline.toString().startsWith("[D][X]"));
            Assertions.assertTrue(event.toString().startsWith("[E][X]"));
        }
    }
}