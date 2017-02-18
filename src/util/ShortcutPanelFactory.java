package util;

import model.ShortcutModel;
import view.ShortcutPanel;

import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-18.
 */
public class ShortcutPanelFactory {

    public static ArrayList<ShortcutPanel> getPanelList(ArrayList<ShortcutModel> modelList){
        ArrayList<ShortcutPanel> panelList = new ArrayList<>();

        for(ShortcutModel model : modelList){
            panelList.add(getPanel(model));
        }

        return panelList;
    }

    private static ShortcutPanel getPanel(ShortcutModel model) {
        ShortcutPanel panel = new ShortcutPanel();

        panel.nameLabel.setText(model.getName());

        if (model.getDescription().equals(" ")) {
            panel.removeDescription();
        } else {
            panel.descriptionLabel.setText(model.getDescription());
        }

        String[] keys = model.getKeys();
        String str = "";
        for (String key : keys) {
            str += key + " + ";
        }
        panel.keysLabel.setText(str.substring(0, str.length() - 3));

        panel.titledBorder.setTitle(model.getCategory());

        return panel;
    }

}
