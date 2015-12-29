package model;

import serializable.TaskSerializator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by V&R on 24.12.15.
 */
public class Tasker implements Serializable {

    private static Tasker instance;
    private static boolean isSaved;
    private Map<String, LinkedList<String>> taskMap = new HashMap<>();


    private Tasker() {

    }

    public static Tasker getInstance() {
        if (instance == null) {
            instance = TaskSerializator.deserialize();
            if (instance == null)
                instance = new Tasker();
        }
        return instance;
    }

    public Map<String, LinkedList<String>> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, LinkedList<String>> taskMap) {
        this.taskMap = taskMap;
    }

    public static boolean isSaved() {
        return isSaved;
    }

    public static void setIsSaved(boolean isSaved) {
        Tasker.isSaved = isSaved;
    }
}

