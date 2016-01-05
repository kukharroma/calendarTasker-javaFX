package service;

import java.io.File;
import java.io.IOException;

/**
 * Created by V&R on 24.12.15.
 */
public class FileService {


    public static void createFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

}
