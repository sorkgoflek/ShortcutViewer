package view.menuitem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Drew on 2017-02-19.
 */
public class TransparentMenuItem extends JMenuItem {
    public TransparentMenuItem() {
        super("transparent");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
