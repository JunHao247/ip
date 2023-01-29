package james;

import james.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    String filePath = "data/james.txt";
    File file;

    public Storage() throws JamesException {
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new JamesException("File could not be created.");
        }
    }

    public TaskList loadFile() throws JamesException {
        TaskList taskList = new TaskList();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] task = sc.nextLine().split(" \\| ");
                switch (task[0]) {
                    case "T":
                        taskList.addToTaskList(new ToDo(task[2]));
                        break;
                    case "D":
                        taskList.addToTaskList(new Deadline(task[2], task[3]));
                        break;
                    case "E":
                        taskList.addToTaskList(new Event(task[2], task[3], task[4]));
                        break;
                }
                if (task[1].equals("1")) {
                    taskList.markTask(taskList.getTaskList().size() - 1);
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new JamesException("File could not be loaded.");
        }
        return taskList;
    }

    public void writeToFile(TaskList taskList) throws JamesException {
        try {
            FileWriter file = new FileWriter(filePath);
            for (int i = 0; i < taskList.getSize(); i++) {
                Task task = taskList.getTask(i);
                file.write(task.toStoreString());
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new JamesException("Path could not be found.");
        }
    }

}
