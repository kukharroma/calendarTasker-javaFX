package model;

import serializable.TaskSerializator;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by V&R on 24.12.15.
 */
public class Tasker implements Serializable {

    private static Tasker instance;
    private static boolean isSaved;
    private static File taskerFile;

    private Map<String, List<Task>> taskMap = new HashMap<>();


    private Tasker() {

    }

    public static Tasker getInstance(File file) {
        if (instance == null) {
            instance = TaskSerializator.deserialize(file);
            if (instance == null)
                instance = new Tasker();
        }
        return instance;
    }

    public Map<String, List<Task>> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, List<Task>> taskMap) {
        this.taskMap = taskMap;
    }

    public static boolean isSaved() {
        return isSaved;
    }

    public static void setIsSaved(boolean isSaved) {
        Tasker.isSaved = isSaved;
    }

    public static File getTaskerFile() {
        return taskerFile;
    }

    public static void setTaskerFile(File taskerFile) {
        Tasker.taskerFile = taskerFile;
    }



}

