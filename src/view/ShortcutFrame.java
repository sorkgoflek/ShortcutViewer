package view;

import model.ShortcutModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Drew on 2017-02-14.
 */
public class ShortcutFrame extends JFrame {
    private JPanel parentPanel;
    private BoxLayout boxLayout;
    private ArrayList<ShortcutModel> modelList;
    private ArrayList<JPanel> panelList;

    public ShortcutFrame() {
        setTitle("Shortcut Viewer");
        setSize(300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelList = new ArrayList<>();

        parentPanel = new JPanel();
        boxLayout = new BoxLayout(parentPanel, BoxLayout.Y_AXIS);
        parentPanel.setLayout(boxLayout);

        /*//Test
        for (int i = 0; i <5; i++) {
            JPanel sample = new JPanel();
            //sample.setSize(100,100);
            sample.setPreferredSize(new Dimension(50,50));
            sample.setBackground(Color.blue);

            parentPanel.add(sample);

            JPanel sample2 = new JPanel();
            //sample.setSize(100,100);
            sample2.setPreferredSize(new Dimension(50,50));
            sample2.setBackground(Color.red);

            parentPanel.add(sample2);

            //panelList.add(new JPanel());
        }*/

        parentPanel.add(getCard());
        parentPanel.add(getCard());
       // parentPanel.add(getCard());

        parentPanel.setOpaque(true); // ??

        setContentPane(parentPanel);
        //pack();
        setVisible(true);
    }

    public void dsetShortcutModelList(ArrayList<ShortcutModel> modelList) {
        this.modelList = modelList;
        parentPanel.updateUI();
    }

    private JPanel getCard(/*ShortcutModel shortcutModel*/){
        ShortcutCard card = new ShortcutCard();


        return card;
    }
}
