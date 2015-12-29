package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.Task;
import model.Tasker;
import serializable.TaskSerializator;

import java.net.URL;

import java.time.LocalDate;
import java.util.*;

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
        initTasker();
        initCurentDate();
        setBtnAddListener();
        setDatePickerListener();
        setBtnSaveListener();
    }

    public void initTasker() {
        tasker = Tasker.getInstance();
    }

    public void initCurentDate(){
        dpDate.setValue(LocalDate.now());
        showListByDate();
    }

    public void setDatePickerListener() {
        dpDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showListByDate();
            }
        });
    }

    public void showListByDate(){

        String localDate = dpDate.getValue().toString();

        if (tasker.getTaskMap().get(localDate) == null) {
            tasker.getTaskMap().put(localDate, new ArrayList<Task>());
        }

        List<Task> data = tasker.getTaskMap().get(localDate);
        ObservableList<Task> tasks = FXCollections.observableArrayList(data);
        lvTaskList.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {

            @Override
            public ListCell<Task> call(ListView<Task> param) {
                ListCell<Task> cell = new ListCell<Task>() {

                    @Override
                    protected void updateItem(Task task, boolean empty) {
                        super.updateItem(task, empty);
                        if (task != null) {
                            setText(task.getTaskName());
                        }
                    }
                };
                return cell;
            }
        });
        lvTaskList.setItems(tasks);
    }

    public void setBtnAddListener() {
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task task = new Task(tfTask.getText());
                LocalDate localDate = dpDate.getValue();
                List<Task> data = tasker.getTaskMap().get(localDate.toString());
                data.add(task);
                ObservableList<Task> tasks = FXCollections.observableArrayList(data);
                lvTaskList.setItems(tasks);
                Tasker.setIsSaved(false);
            }
        });
    }

    public void setBtnSaveListener(){
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TaskSerializator.serialize(Tasker.getInstance());
                Tasker.setIsSaved(true);
            }
        });
    }


}

