package controller;

import model.KeyboardHooker;
import model.ShortcutModel;
import sun.rmi.runtime.Log;
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
        });

        modelList = ShortcutListFileReader.getShortcutList();
        prevKeys = new String[]{};

        hooker.setDaemon(true);
        hooker.start();
    }

    private void onSetHookedKeys(String[] keys) {
        System.out.println("onSetHookedKeys: " + keys.toString());

        if (Arrays.equals(prevKeys, keys)) {
            return;
        }

        prevKeys = keys;

        ArrayList<ShortcutModel> hookedModelList = new ArrayList<>();
        for (ShortcutModel model : modelList) {
            if (model.isContainKeys(keys)) {
                hookedModelList.add(model);
            }
        }

        ArrayList<ShortcutPanel> panelList = ShortcutPanelFactory.getPanelList(hookedModelList);
        frame.setPanelList(panelList);
    }
}