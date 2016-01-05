import helper.AlertDialogHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Tasker;
import serializable.TaskSerializator;

import java.io.File;
import java.util.Optional;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("V&R Tasker 3000");
        alert.setHeaderText(" Вас вітає мєгачьотка програма 'V&R Tasker 3000'.\n Якщо це Ваш перший " +
                "запуск натисніть кнопку 'Створити',\n якщо ж у Вас є збережений файл нашої програми" +
                " виберіть \n його та натисніть'Відкрити'.");
        alert.setContentText("Будь ласка, зробіть Ваш вибір.");

        ButtonType buttonCreate = new ButtonType("Створити");
        ButtonType buttonOpen = new ButtonType("Відкрити");

        alert.getButtonTypes().setAll(buttonOpen, buttonCreate);


        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonOpen) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Вкажіть Ваш файл");
            File taskerFile = fileChooser.showOpenDialog(stage);
            Tasker.setTaskerFile(taskerFile);
            if(taskerFile!=null){
                TaskSerializator.deserialize(taskerFile);
                Parent root = FXMLLoader.load(getClass().getResource(Tasker.getTaskerFile().getPath()));
                stage.setScene(new Scene(root));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        if (!Tasker.isSaved())
                            AlertDialogHelper.showCloseDialog(event);
                    }
                });
            }




        } else if (result.get() == buttonCreate) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Вкажіть місце куди зберегти Ваш файл");
            fileChooser.showSaveDialog(stage);
        } else {
            alert.close();
        }


//        Parent root = FXMLLoader.load(getClass().getResource(VIEW_PATH));
//        stage.setScene(new Scene(root));
//        stage.show();
//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                if(!Tasker.isSaved())
//                    AlertDialogHelper.showCloseDialog(event);
//            }
//        });

    }


}
