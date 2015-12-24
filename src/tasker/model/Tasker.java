package model;

import javafx.scene.control.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roma on 24.12.15.
 */
public class Tasker implements Serializable {
    Map<String, List<String>> taskMap = new HashMap<>();



    public Map<String, List<String>> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, List<String>> taskMap) {
        this.taskMap = taskMap;

    }

}
