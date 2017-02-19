package util;

import policy.Setting;

/**
 * Created by Drew on 2017-02-19.
 */
public class ShortcutCategoryAdder {
    public static void addCategory(String category) {
        Setting.CATEGORY_SET.add(category);
    }
}
