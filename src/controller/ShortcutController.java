package controller;

import model.KeyboardHooker;
import model.ShortcutModel;
import policy.Constant;
import util.ShortcutListFileReader;
import util.ShortcutPanelFactory;
import view.ShortcutFrame;
import view.ShortcutPanel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Drew on 2017-02-18.
 */
public class ShortcutController {
    private ShortcutFrame frame;
    private KeyboardHooker hooker;

    private ArrayList<ShortcutModel> modelList;
    private String[] prevKeys;

    public ShortcutController(ShortcutFrame frame) {
        this.frame = frame;
        hooker = new KeyboardHooker(new KeyboardHooker.CallBack() {
            @Override
            public void setHookedKeys(String[] keys) {
                onSetHookedKeys(keys);
            }

            @Override
            public void setEmptyKeys() {
                onSetEmptyKeys();
            }
        });

        modelList = ShortcutListFileReader.getShortcutList();
        prevKeys = new String[]{};

        hooker.setDaemon(true);
        hooker.start();
    }

    private void onSetHookedKeys(String[] keys) {
        if (Arrays.equals(prevKeys, keys) || !isContainModifierKey(keys)) {
            return;
        }

        prevKeys = keys;

        // 눌린 Key들을 모두 포함한 Model만 추출 후, Panel화
        ArrayList<ShortcutModel> hookedModelList = new ArrayList<>();
        for (ShortcutModel model : modelList) {
            if (model.isContainKeys(keys)) {
                hookedModelList.add(model);
            }
        }

        frame.setPanelList(ShortcutPanelFactory.getPanelList(hookedModelList));
    }

    private void onSetEmptyKeys() {
        prevKeys = new String[]{};
        frame.setPanelList(new ArrayList<ShortcutPanel>());
    }

    private boolean isContainModifierKey(String[] keys) {
        for (String modifierKey : Constant.MODIDIER_KEYS) {
            for (String key : keys) {
                if (modifierKey.equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }
}