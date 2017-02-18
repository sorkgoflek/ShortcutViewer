package view;

import controller.ShortcutController;

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

        setContentPane(parentPanel);
        //pack();
        setVisible(true);
    }

    private void initSystem() {
        controller = new ShortcutController(this);
    }

    public void setPanelList(ArrayList<ShortcutPanel> panelList) {
        parentPanel.removeAll();

        for (ShortcutPanel panel : panelList) {
            parentPanel.add(panel);
        }

        parentPanel.updateUI();
        parentPanel.setOpaque(true);
    }
}
