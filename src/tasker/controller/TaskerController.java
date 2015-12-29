package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ListView<String> lvTaskList;
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
            tasker.getTaskMap().put(localDate, new LinkedList<String>());
        }

        LinkedList<String> data = tasker.getTaskMap().get(localDate);
        ObservableList<String> tasks = FXCollections.observableArrayList(data);
        lvTaskList.setItems(tasks);
    }

    public void setBtnAddListener() {
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textField = tfTask.getText();
                LocalDate localDate = dpDate.getValue();
                LinkedList<String> data = tasker.getTaskMap().get(localDate.toString());
                data.add(textField);
                ObservableList<String> tasks = FXCollections.observableArrayList(data);
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

