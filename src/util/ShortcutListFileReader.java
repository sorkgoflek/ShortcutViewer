package util;

import model.ShortcutModel;
import policy.Constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-18.
 */
public class ShortcutListFileReader {

    public static ArrayList<ShortcutModel> getShortcutList() {
        ArrayList<ShortcutModel> shortcutList = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(new File(Constant.SHORTCUTLIST_FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }

        bufferedReader = new BufferedReader(fileReader);

        while (true) {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            }

            shortcutList.add(getShortcutModel(line));
        }

        return shortcutList;
    }

    private static ShortcutModel getShortcutModel(String line) {
        // name@@key + key + key@@description@@category

        String[] attr = line.split("@@");
        String[] keys = attr[1].split(" + ");

        return new ShortcutModel(attr[0], keys, attr[2], attr[3]);
    }
}
