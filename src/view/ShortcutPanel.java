package view;

import policy.Constant;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutPanel extends JPanel {
    public static int FONT_SIZE = Constant.FONT_DEFAULT_SIZE;
    public TitledBorder titledBorder;
    public JLabel nameLabel;
    public JLabel descriptionLabel;
    public JLabel keysLabel;
    private GridBagLayout layout;

    public ShortcutPanel() {
        layout = new GridBagLayout();
        setLayout(layout);
        setBackground(Constant.FONT_COLOR);
        setOpaque(false);

        initBorder();
        initLabels();
    }

    private void initBorder() {
        titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                "Category");
        titledBorder.setTitleJustification(TitledBorder.RIGHT);
        titledBorder.setTitleColor(Constant.FONT_COLOR);

        setBorder(new CompoundBorder(new EmptyBorder(0, 5, 5, 5), titledBorder));
    }

    private void initLabels() {
        nameLabel = new JLabel();
        descriptionLabel = new JLabel();
        keysLabel = new JLabel();

        int x, y;
        x = y = 1;
        addLabel(keysLabel,
                0, 0, y, x * 5,
                Color.green, FONT_SIZE * 2, true
        );

        addLabel(nameLabel,
                0, 1, y, x,
                Color.blue, FONT_SIZE * 3 / 2, false
        );

        addLabel(descriptionLabel,
                0, 2, y * 2, x * 5,
                Color.gray, FONT_SIZE, true
        );
    }

    private void addLabel(JLabel label, int x, int y, int h, int w, Color color, int fontSize, boolean isFill) {
        GridBagConstraints constraints = new GridBagConstraints();

        label.setFont(new Font("Dialog.plain", Font.PLAIN, fontSize));
        label.setForeground(Constant.FONT_COLOR);
        label.setOpaque(false);

        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = h;
        constraints.gridwidth = w;
        constraints.fill = isFill ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        constraints.insets = new Insets(y == 2 ? 3 : 0, y == 2 ? 4 : 3, y == 2 ? 3 : 0, 3);
        constraints.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        constraints.weightx = (x == 0) ? 0.1 : 1.0;

        add(label, constraints);
    }

    public void removeDescription() {
        remove(descriptionLabel);
    }
}
