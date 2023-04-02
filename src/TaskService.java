import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaskService{
    private Map<Integer, Task> currentTask = new HashMap<>();
    private List<Task> deletedTask = new ArrayList<>();

    public Map<Integer, Task> getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Map<Integer, Task> currentTask) {
        this.currentTask = currentTask;
    }

    public List<Task> getDeletedTask() {
        return deletedTask;
    }

    public void setDeleteTask(List<Task> deletedTask) {
        this.deletedTask = deletedTask;
    }

    public void addTask(Task task) {
        currentTask.put(task.getId(), task);
    }

    public Task deleteTask(int id) throws TaskNotFoundException {
        for (Map.Entry<Integer, Task> task : getCurrentTask().entrySet()) {
            if (task.getKey() == id) {
                return currentTask.remove(id);
            }
        }
        throw new TaskNotFoundException("Нет задачи");

    }
    public void viewTasks (Map<Integer, Task> currentTask) throws IncorrectArgumentException {
        for (Map.Entry<Integer, Task> entry : currentTask.entrySet()) {
            Integer key = entry.getKey();
            Task value = entry.getValue();
            System.out.println(key + ". " + value);
        }
    }
}
