package save;

import task.TaskList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler {
    private final String pathname;

    public FileHandler(String pathname) {
        this.pathname = pathname;
    }

    public void save(TaskList contents) throws IOException {
        createFile();
        FileOutputStream fileOutputStream = new FileOutputStream(pathname);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contents);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public TaskList load() throws ClassNotFoundException, IOException {
        createFile();
        FileInputStream fileInputStream = new FileInputStream(pathname);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TaskList list;
        try {
            list = (TaskList) objectInputStream.readObject();
        } finally {
            objectInputStream.close();
        }
        return list;
    }

    private void createFile() throws IOException {
        File file = new File(pathname);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }
}