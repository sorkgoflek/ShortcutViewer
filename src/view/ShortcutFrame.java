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
   //
    private ArrayList<ShortcutModel> modelList;
    private ArrayList<JPanel> panelList;

    public ShortcutFrame() {
        setTitle("Shortcut Viewer");
        setSize(300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelList = new ArrayList<>();

        parentPanel = new JPanel();
        parentPanel.setLayout(new FlowLayout());

        parentPanel.add(getCard());
        parentPanel.add(getCard());
       // parentPanel.add(getCard());

        parentPanel.setOpaque(true); // ??

        setContentPane(parentPanel);
        //pack();
        setVisible(true);
    }

    public void setShortcutModelList(ArrayList<ShortcutModel> modelList) {
        this.modelList = modelList;
        parentPanel.updateUI();
    }

    private JPanel getCard(/*ShortcutModel model*/){
        ShortcutCard card = new ShortcutCard();
        card.setLabels(new ShortcutModel(new String[]{"Alt", "K"}, "HI", "this is name", "Win10"));
        //card.setLabels(model);

        return card;
    }
}
