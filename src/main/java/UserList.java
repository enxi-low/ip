import java.util.ArrayList;

public class UserList {
    private final ArrayList<String> tasks = new ArrayList<>();

    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ". " + tasks.get(i));
        }
    }

    public void add(String task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }
}
