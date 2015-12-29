package service;

import java.io.File;
import java.io.IOException;

/**
 * Created by V&R on 24.12.15.
 */
public class FileService {
    public static final String PATH ="src/res/tasker.txt";

    public static void createFile() {
        File file = new File(PATH);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFileExists() {
        File file = new File(PATH);
        return file.exists();
    }

}
