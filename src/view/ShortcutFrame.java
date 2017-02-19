package view;

import controller.ShortcutController;
import policy.Constant;
import policy.Setting;
import view.listener.FrameDragListener;
import view.menuitem.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutFrame extends JFrame {
    private ShortcutController controller;

    private JPanel listPanel;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private int autoScrollSkipTimes;

    public ShortcutFrame() {
        initSystem();
        initListPanel();
        initScrollPane();
        initMenuBar();

        setUndecorated(true);
        setTitle("Shortcut Viewer");
        setSize(Constant.APP_WIDTH, Constant.APP_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(0, 0, 0, Setting.TRANSPARENT_VALUE));
        setAlwaysOnTop(true);
        setJMenuBar(menuBar);
        setContentPane(scrollPane);

        setVisible(true);
    }

    private void initSystem() {
        controller = new ShortcutController(this);
    }

    private void initListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(0, 0, 0, Setting.TRANSPARENT_VALUE));
        listPanel.setOpaque(false);
    }

    private void initScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, Constant.APP_WIDTH, Constant.APP_HEIGHT);

        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
    }

    private void initMenuBar() {
        menuBar = new JMenuBar();
        JMenu programMenu = new JMenu("Program");
        JMenu settingMenu = new JMenu("Setting");
        JMenu categoryMenu = new JMenu("Category");

        ExitMenuItem exitMenuItem = new ExitMenuItem();
        FontMenuItem fontMenuItem = new FontMenuItem();
        BackgroundMenuItem backgroundMenuItem = new BackgroundMenuItem();
        TransparentMenuItem transparentMenuItem = new TransparentMenuItem();
        CategoryMenuItem categoryMenuItem = new CategoryMenuItem();

        programMenu.add(exitMenuItem);
        settingMenu.add(fontMenuItem);
        settingMenu.add(backgroundMenuItem);
        settingMenu.add(transparentMenuItem);
        categoryMenu.add(categoryMenuItem);

        menuBar.add(programMenu);
        menuBar.add(settingMenu);
        menuBar.add(categoryMenu);

        FrameDragListener frameDragListener = new FrameDragListener(this);
        menuBar.addMouseListener(frameDragListener);
        menuBar.addMouseMotionListener(frameDragListener);
    }

    public void setPanelList(ArrayList<ShortcutPanel> panelList) {
        System.out.println("setPanelList");

        listPanel.removeAll();
        autoScrollSkipTimes = 0;

        for (ShortcutPanel panel : panelList) {
            listPanel.add(panel);
        }

        scrollPane.setViewportView(listPanel);

        pack();
        setSize(getWidth() < Constant.APP_WIDTH ? Constant.APP_WIDTH : getWidth(), Constant.APP_HEIGHT);

        /*dispose();
        setJMenuBar(new JMenuBar());//
        setBackground(new Color(0, 150, 0, 125));
        setVisible(true);*/
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
