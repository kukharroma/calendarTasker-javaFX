package serializable;

import model.Tasker;
import service.FileService;

import java.io.*;

/**
 * Created by V&R on 24.12.15.
 */
public class TaskSerializator {

    public static void serialize(Tasker tasker, String path) {
        try (ObjectOutputStream obOutpStr = new ObjectOutputStream(new FileOutputStream(path))) {
            obOutpStr.writeObject(tasker);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tasker deserialize(File file) {
        Tasker tasker = null;
        if (new File(file.getPath()).length() != 0)
            try (ObjectInputStream obInpStr = new ObjectInputStream(new FileInputStream(file.getPath()))) {
                tasker = (Tasker) obInpStr.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        return tasker;
    }

}
