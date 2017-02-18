package view;

import controller.ShortcutController;
import policy.Constant;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutFrame extends JFrame {
    private ShortcutController controller;

    private JPanel ListPanel;
    private JScrollPane scrollPane;

    public ShortcutFrame() {
        initSystem();

        setTitle("Shortcut Viewer");
        setSize(Constant.APP_WIDTH, Constant.APP_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ListPanel = new JPanel();
        ListPanel.setLayout(new BoxLayout(ListPanel, BoxLayout.Y_AXIS));

        setContentPane(ListPanel);
        setVisible(true);
    }

    private void initSystem() {
        controller = new ShortcutController(this);
    }

    public void setPanelList(ArrayList<ShortcutPanel> panelList) {
        System.out.println("setPanelList");

        ListPanel.removeAll();

        for (ShortcutPanel panel : panelList) {
            ListPanel.add(panel);
        }

        scrollPane = new JScrollPane(ListPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, Constant.APP_WIDTH + 15, Constant.APP_HEIGHT - 37);

        setContentPane(scrollPane);

        pack();
    }

    public void scrollDown() {
        if (scrollPane != null) {
            System.out.println("scrollDown");
            JScrollBar scrollbar = scrollPane.getVerticalScrollBar();
            int prevPosition = scrollbar.getValue();

            if (prevPosition == scrollbar.getMaximum() - scrollbar.getVisibleAmount()) {
                scrollbar.setValue(0);
            } else {
                scrollbar.setValue(prevPosition + Constant.AUTO_SCROLL_SPEED);
            }
        }
    }
}
