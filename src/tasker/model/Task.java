package model;


import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by V&R on 24.12.15.
 */
public class Task implements Serializable{

    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
