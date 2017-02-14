package view;

import com.sun.applet2.AppletParameters;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutCard extends JPanel {
    private GridBagLayout layout;

    public JLabel nameLabel;
    public JLabel descriptionLabel;
    public JLabel keysLabel;
    public JLabel labelLabel;

    public ShortcutCard() {
        layout = new GridBagLayout();
        setLayout(layout);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                "Category");
        titledBorder.setTitleJustification(TitledBorder.RIGHT);

        setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), titledBorder));


        nameLabel = new JLabel("nameLabel");
        descriptionLabel = new JLabel("descrip4564565456456645tionLabel");
        keysLabel = new JLabel("keysLabel");
        labelLabel = new JLabel("labelLabel");

        int x, y, fontSize = 13;
        x = y = 1;


        addPanel(nameLabel,
                0, 0, 1, 1,
                Color.blue, fontSize * 2, false
        );

        addPanel(labelLabel,
                1, 0, 1, 1,
                Color.red, fontSize, false
        );

        addPanel(keysLabel,
                0, 1, y, x * 5,
                Color.green, fontSize * 2, true
        );

        addPanel(descriptionLabel,
                0, 2, y * 2, x * 5,
                Color.gray, fontSize, true
        );

        setOpaque(true);
    }

    private void addPanel(JLabel label, int x, int y, int h, int w, Color color, int fontSize, boolean isFill) {
        JPanel panel = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();

        label.setFont(new Font("Dialog.plain", Font.PLAIN, fontSize));

        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = h;
        constraints.gridwidth = w;
        constraints.fill = isFill ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        constraints.insets = new Insets(y == 0 ? 3 : 0, 3, y == 2 ? 3 : 0, 3);
        constraints.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        constraints.weightx = (x == 0) ? 0.1 : 1.0;

        panel.setBackground(color);
        panel.add(label);

        add(panel, constraints);
    }
}
