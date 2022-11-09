package task;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private Map<Integer, Task> taskService = new HashMap<>();
    private Collection<Task> removedTask;

    public void add(Task task) {
        taskService.put(task.getId(), task);
    }

    public void remove(int id) {
        taskService.remove(id);
    }

   public Collection<Task> getAllByDate(LocalDate inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : taskService.entrySet()) {
            var task = integerTaskEntry.getValue();
            if (task.isAvailable(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;
    }
}
