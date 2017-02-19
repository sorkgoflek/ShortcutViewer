package util;

import model.ShortcutModel;
import policy.Setting;

import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-19.
 */
public class ShortcutModelListSubtracter {
    public static ArrayList<ShortcutModel> getHookedModelList(ArrayList<ShortcutModel> modelList, String[] keys) {
        ArrayList<ShortcutModel> hookedModelList = new ArrayList<>();

        for (ShortcutModel model : modelList) {
            if (Setting.SELECTED_CATEGORY.equals(Setting.CATEGORY_ALL) || Setting.SELECTED_CATEGORY.equals(model.getCategory())) {
                if (model.isContainKeys(keys)) {
                    hookedModelList.add(model);
                }
            }
        }

        return hookedModelList;
    }
}
