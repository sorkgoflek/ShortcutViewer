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

    private JPanel listPanel;
    private JScrollPane scrollPane;
    private int autoScrollSkipTimes;

    public ShortcutFrame() {
        initSystem();

        setTitle("Shortcut Viewer");
        setSize(Constant.APP_WIDTH, Constant.APP_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        setContentPane(listPanel);
        setVisible(true);
    }

    private void initSystem() {
        controller = new ShortcutController(this);
    }

    public void setPanelList(ArrayList<ShortcutPanel> panelList) {
        System.out.println("setPanelList");

        listPanel.removeAll();
        autoScrollSkipTimes = 0;

        for (ShortcutPanel panel : panelList) {
            listPanel.add(panel);
        }

        scrollPane = new JScrollPane(listPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, Constant.APP_WIDTH, Constant.APP_HEIGHT);

        setContentPane(scrollPane);
        pack();
        setSize(getWidth() < Constant.APP_WIDTH ? Constant.APP_WIDTH : getWidth(), Constant.APP_HEIGHT);
    }

    public void scrollDown() {
        //일정 시간 후에 스크롤이 내려가도록
        if (autoScrollSkipTimes < Constant.AUTO_SCROLL_BEGIN_MAX_SKIP_TIMES) {
            autoScrollSkipTimes++;
            return;
        }

        if (scrollPane != null) {
            System.out.println("scrollDown");

            JScrollBar scrollbar = scrollPane.getVerticalScrollBar();
            int prevPosition = scrollbar.getValue();

            if (prevPosition == scrollbar.getMaximum() - scrollbar.getVisibleAmount()) {
                //일정 시간 후에 스크롤이 맨 위로 올라가도록
                if (autoScrollSkipTimes < Constant.AUTO_SCROLL_END_MAX_SKIP_TIMES) {
                    autoScrollSkipTimes++;
                    return;
                }

                scrollbar.setValue(0);
                autoScrollSkipTimes = 0;
            } else {
                scrollbar.setValue(prevPosition + Constant.AUTO_SCROLL_SPEED);
            }
        }
    }
}
