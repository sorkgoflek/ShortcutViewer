package view;

import com.sun.applet2.AppletParameters;
import model.ShortcutModel;
import policy.Constant;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutCard extends JPanel {
    public static int FONT_SIZE = Constant.FONT_DEFAULT_SIZE;

    private GridBagLayout layout;
    private TitledBorder titledBorder;

    public JLabel nameLabel;
    public JLabel descriptionLabel;
    public JLabel keysLabel;

    public ShortcutCard() {
        layout = new GridBagLayout();
        setLayout(layout);

        titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                "Category");
        titledBorder.setTitleJustification(TitledBorder.RIGHT);

        setBorder(new CompoundBorder(new EmptyBorder(0, 5, 5, 5), titledBorder));


        nameLabel = new JLabel("nameLabel");
        descriptionLabel = new JLabel("descrip4564565456456645tionLabel");
        keysLabel = new JLabel("keysLabel");

        int x, y;
        x = y = 1;


        addPanel(nameLabel,
                0, 0, 1, 1,
                Color.blue, FONT_SIZE * 2, false
        );

        addPanel(keysLabel,
                0, 1, y, x * 5,
                Color.green, FONT_SIZE * 2, true
        );

        addPanel(descriptionLabel,
                0, 2, y * 2, x * 5,
                Color.gray, FONT_SIZE, true
        );

        setOpaque(true);
    }

    private void addPanel(JLabel label, int x, int y, int h, int w, Color color, int fontSize, boolean isFill) {
        GridBagConstraints constraints = new GridBagConstraints();

        label.setFont(new Font("Dialog.plain", Font.PLAIN, fontSize));

        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridheight = h;
        constraints.gridwidth = w;
        constraints.fill = isFill ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        constraints.insets = new Insets(y == 2 ? 3 : 0, 3, y == 2 ? 3 : 0, 3);
        constraints.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        constraints.weightx = (x == 0) ? 0.1 : 1.0;

        add(label, constraints);
    }

    public void setLabels(ShortcutModel model) {
        nameLabel.setText(model.getName());
        descriptionLabel.setText(model.getDescription());

        String[] keys = model.getKey();
        String str = "";
        for (String key : keys) {
            str += key + " + ";
        }
        keysLabel.setText(str.substring(0, str.length() - 3));

        titledBorder.setTitle(model.getLabel());
    }
}