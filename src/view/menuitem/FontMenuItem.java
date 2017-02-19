package view.menuitem;

import policy.Constant;
import policy.Setting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Drew on 2017-02-19.
 */
public class FontMenuItem extends JMenuItem {
    public FontMenuItem() {
        super("font");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Choose Font Color");
                frame.setSize(300, 80);
                frame.setLayout(null);

                JPanel panel = new JPanel();
                ButtonGroup group = new ButtonGroup();

                JRadioButton black = new JRadioButton("Black");
                black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Setting.FONT_COLOR = Constant.FONT_COLOR_BLACK;
                    }
                });

                JRadioButton gray = new JRadioButton("Gray");
                gray.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Setting.FONT_COLOR = Constant.FONT_COLOR_GRAY;
                    }
                });

                JRadioButton white = new JRadioButton("White");
                white.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Setting.FONT_COLOR = Constant.FONT_COLOR_WHITE;
                    }
                });

                group.add(black);
                group.add(gray);
                group.add(white);

                panel.add(black);
                panel.add(gray);
                panel.add(white);

                frame.setContentPane(panel);
                frame.setVisible(true);
            }
        });
    }
}
