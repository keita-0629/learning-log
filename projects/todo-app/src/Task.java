import java.util.ArrayList;

public class Task {
    private String taskName;
    private boolean doneTask;

    Task(String taskName) {
        this.taskName = taskName;
        this.doneTask = false;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isDoneTask() {
        return this.doneTask;
    }

    public void setDoneTask(boolean doneTask) {
        this.doneTask = doneTask;
    }



}
