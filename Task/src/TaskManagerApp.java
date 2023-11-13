import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

class Task {
    private String title;
    private String description;
    private Date creationDate;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.creationDate = new Date();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

class DeadlineTask extends Task {
    private Date deadline;

    public DeadlineTask(String title, String description, Date deadline) {
        super(title, description);
        this.deadline = deadline;
    }


    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}

class RecurringTask extends Task {
    private String repetitionInterval;
    private Date startDate;

    public RecurringTask(String title, String description, String repetitionInterval, Date startDate) {
        super(title, description);
        this.repetitionInterval = repetitionInterval;
        this.startDate = startDate;
    }

    public String getRepetitionInterval() {
        return repetitionInterval;
    }

    public void setRepetitionInterval(String repetitionInterval) {
        this.repetitionInterval = repetitionInterval;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

class TaskManager {
    private static int taskCount = 0;
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        taskCount++;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        taskCount--;
    }

    public void displayTasksByCreationDate() {

        Collections.sort(tasks, (task1, task2) -> task1.getCreationDate().compareTo(task2.getCreationDate()));

        for (Task task : tasks) {
            System.out.println(task.getTitle() + " - " + task.getCreationDate());
        }
    }

    public static int getTaskCount() {
        return taskCount;
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1", "Description for Task 1");
        DeadlineTask task2 = new DeadlineTask("Task 2", "Description for Task 2", new Date());
        RecurringTask task3 = new RecurringTask("Task 3", "Description for Task 3", "Weekly", new Date());

        System.out.println("Total tasks created: " + TaskManager.getTaskCount());

        TaskManager taskManager = new TaskManager();

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("Tasks sorted by creation date:");
        taskManager.displayTasksByCreationDate();
    }
}