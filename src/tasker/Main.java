import helper.AlertDialogHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Tasker;
import serializable.TaskSerializator;
import service.FileService;

import java.util.Optional;


public class Main extends Application {

    private static final String VIEW_PATH = "/src/res/viewTasker.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        if (!FileService.isFileExists())
            FileService.createFile();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(VIEW_PATH));
        stage.setScene(new Scene(root));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if(!Tasker.isSaved())
                    AlertDialogHelper.showCloseDialog(event);
            }
        });


    }




}
