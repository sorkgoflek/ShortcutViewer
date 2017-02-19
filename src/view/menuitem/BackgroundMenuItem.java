package view.menuitem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Drew on 2017-02-19.
 */
public class BackgroundMenuItem extends JMenuItem {
    public BackgroundMenuItem() {
        super("background");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
