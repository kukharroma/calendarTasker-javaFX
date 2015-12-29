package serializable;

import model.Tasker;
import service.FileService;

import java.io.*;

/**
 * Created by V&R on 24.12.15.
 */
public class TaskSerializator {

    public static void serialize(Tasker tasker) {
        try (ObjectOutputStream obOutpStr = new ObjectOutputStream(new FileOutputStream(FileService.PATH))) {
            obOutpStr.writeObject(tasker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tasker deserialize() {
        Tasker tasker = null;
        if (new File(FileService.PATH).length() != 0)
            try (ObjectInputStream obInpStr = new ObjectInputStream(new FileInputStream(FileService.PATH))) {
                tasker = (Tasker) obInpStr.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        return tasker;
    }

}
