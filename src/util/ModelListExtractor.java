package util;

import model.Model;
import policy.Setting;

import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-19.
 */
public class ModelListExtractor {
    public static ArrayList<Model> getHookedModelList(ArrayList<Model> modelList, String[] keys) {
        ArrayList<Model> hookedModelList = new ArrayList<>();

        for (Model model : modelList) {
            if (Setting.SELECTED_CATEGORY.equals(Setting.CATEGORY_ALL) || Setting.SELECTED_CATEGORY.equals(model.getCategory())) {
                if (model.isContainKeys(keys)) {
                    hookedModelList.add(model);
                }
            }
        }

        return hookedModelList;
    }
}
