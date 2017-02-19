package controller;

import model.KeyboardHooker;
import model.ShortcutModel;
import policy.Constant;
import util.ShortcutListFileReader;
import util.ShortcutModelListSubtracter;
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
    private int displayShortcutSkipTimes;

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
        displayShortcutSkipTimes = 0;

        hooker.setDaemon(true);
        hooker.start();
    }

    private void onSetHookedKeys(String[] keys) {
        if (displayShortcutSkipTimes < Constant.DISPLAY_SHORTCUT_SKIP_TIMES) {
            displayShortcutSkipTimes++;
            return;
        }

        if (Arrays.equals(prevKeys, keys) || !isContainModifierKey(keys)) {
            frame.scrollDown();
            return;
        }

        prevKeys = keys;
        displayShortcutSkipTimes = 0;

        ArrayList<ShortcutModel> hookedModelList = ShortcutModelListSubtracter.getHookedModelList(modelList, keys);
        frame.setPanelList(ShortcutPanelFactory.getPanelList(hookedModelList));
    }

    private void onSetEmptyKeys() {
        prevKeys = new String[]{};
        displayShortcutSkipTimes = 0;

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