package view.menuitem;

import policy.Setting;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Drew on 2017-02-19.
 */
public class CategoryMenuItem extends JMenuItem {
    public CategoryMenuItem() {
        super("category");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Choose Category");
                frame.setSize(400, 80);
                frame.setLayout(null);

                JPanel panel = new JPanel();
                ButtonGroup group = new ButtonGroup();

                JRadioButton all = new JRadioButton("All");
                all.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Setting.SELECTED_CATEGORY = Setting.CATEGORY_ALL;
                    }
                });

                group.add(all);
                panel.add(all);

                for (String category : Setting.CATEGORY_SET) {
                    JRadioButton radioButton = new JRadioButton(category);
                    radioButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Setting.SELECTED_CATEGORY = category;
                        }
                    });

                    group.add(radioButton);
                    panel.add(radioButton);
                }

                frame.setContentPane(panel);
                frame.setVisible(true);
            }
        });
    }
}
