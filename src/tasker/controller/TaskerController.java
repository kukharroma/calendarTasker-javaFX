package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Task;
import model.Tasker;
import serializable.TaskSerializator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by V&R on 17.12.15.
 */
public class TaskerController implements Initializable {
    @FXML
    private DatePicker dpDate;
    @FXML
    private ListView<Task> lvTaskList;
    @FXML
    private TextField tfTask;
    @FXML
    private Button btnAdd, btnDelete, btnSave;

    private Tasker tasker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskDeserialization();
        // ініціалізація лісенерів на всі елементи

    }

    public void taskDeserialization() {
        tasker = TaskSerializator.deserialize();
        if (tasker == null) {
            tasker = new Tasker();
        }
    }

    public void initListeners() {

    }

    public void setDatePickerListener() {
        dpDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    public void setLvTaskListListener(){
        lvTaskList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {

            }
        });
    }

}
