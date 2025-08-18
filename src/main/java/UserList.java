import java.util.ArrayList;

public class UserList {
    private final ArrayList<String> tasks = new ArrayList<>();

    public void add(String task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }
}
