package model;


import java.util.LinkedList;

/**
 * Created by V&R on 24.12.15.
 */
public class Task {
    LinkedList<String> taskList = new LinkedList<String>();

    public LinkedList<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(LinkedList<String> taskList) {
        this.taskList = taskList;
    }

    public void setElementToTaskList(String s){
        taskList.add(s);
    }
}
