package controller;

import model.KeyboardHooker;
import model.Model;
import policy.Constant;
import util.ModelListExtractor;
import util.ShortcutListFileReader;
import util.ShortcutPanelFactory;
import view.ShortcutFrame;
import view.ShortcutPanel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Drew on 2017-02-18.
 */
public class Controller {
    private ShortcutFrame frame;
    private KeyboardHooker hooker;

    private ArrayList<Model> modelList;
    private String[] prevKeys;
    private int displayShortcutSkipTimes;

    public Controller(ShortcutFrame frame) {
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

        ArrayList<Model> hookedModelList = ModelListExtractor.getHookedModelList(modelList, keys);
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