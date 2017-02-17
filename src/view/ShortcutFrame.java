package view;

import controller.ShortcutController;
import model.KeyboardHooker;
import model.ShortcutModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutFrame extends JFrame {
    private ShortcutController controller;

    private JPanel parentPanel;

    public ShortcutFrame() {
        initSystem();

        setTitle("Shortcut Viewer");
        setSize(300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        parentPanel = new JPanel();
        parentPanel.setLayout(new FlowLayout());


/*
        parentPanel.add(getCard());
        parentPanel.add(getCard());
        // parentPanel.add(getCard());

        parentPanel.setOpaque(true); // ??
*/

        setContentPane(parentPanel);
        //pack();
        setVisible(true);
    }

    private void initSystem() {
        controller = new ShortcutController(this);
    }

    public void setPanelList(ArrayList<ShortcutPanel> panelList) {
        for(ShortcutPanel panel: panelList){
         parentPanel.add(panel);
        }
        parentPanel.updateUI();
    }

   /* private JPanel getCard(ShortcutModel model) {
        ShortcutPanel card = new ShortcutPanel();
        card.setLabels(new ShortcutModel(new String[]{"Alt", "K"}, "HI", "this is name", "Win10"));
        //card.setLabels(model);

        return card;
    }*/
}
