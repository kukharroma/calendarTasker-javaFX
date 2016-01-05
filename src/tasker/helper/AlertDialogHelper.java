package helper;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import model.Tasker;
import serializable.TaskSerializator;

import java.util.Optional;

/**
 * Created by roma on 29.12.15.
 */
public class AlertDialogHelper {

    public static void showCloseDialog( WindowEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Збереження");
        alert.setHeaderText("Бажаєте зберегти дані?");
        ButtonType buttonTypeYes = new ButtonType("Так");
        ButtonType buttonTypeNo = new ButtonType("Ні");
        ButtonType buttonTypeCancel = new ButtonType("Відміна", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes) {
            TaskSerializator.serialize(Tasker.getInstance(Tasker.getTaskerFile()),Tasker.getTaskerFile().getPath());
            Platform.exit();
        } else if (result.get() == buttonTypeNo) {
            Platform.exit();
        } else {
            event.consume();
        }
    }
}
