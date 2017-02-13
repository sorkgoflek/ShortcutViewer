package main;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import view.ShortcutFrame;

import javax.swing.*;

/**
 * Created by Drew on 2017-01-31.
 */
public class Main {
    private static boolean run = true;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShortcutFrame();
            }
        });
    }
}
