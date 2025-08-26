package luna.task;

import luna.exception.LunaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskListTest {
    @Test
    public void delete_invalidTaskNumber_exceptionThrown() {
        TaskList list = new TaskList();
        Assertions.assertThrows(LunaException.class, () -> list.delete(-5));
        Assertions.assertThrows(LunaException.class, () -> list.delete(0));
        Assertions.assertThrows(LunaException.class, () -> list.delete(1));
        Assertions.assertThrows(LunaException.class, () -> list.delete(300));

        list.add(null);
        Assertions.assertThrows(LunaException.class, () -> list.delete(0));
        Assertions.assertThrows(LunaException.class, () -> list.delete(2));
    }

    @Test
    public void delete_validTaskNumber_success() {
        TaskList list = new TaskList();
        list.add(new ToDo("1"));
        Assertions.assertEquals(
                "Noted. I've removed this task:\n  [T][ ] 1\nNow you have 0 tasks in the list.",
                list.delete(1));

        list.add(new ToDo("2"));
        list.add(new ToDo("3"));
        Assertions.assertEquals(
                "Noted. I've removed this task:\n  [T][ ] 2\nNow you have 1 tasks in the list.",
                list.delete(1));
        Assertions.assertEquals(
                "Noted. I've removed this task:\n  [T][ ] 3\nNow you have 0 tasks in the list.",
                list.delete(1));
    }
}