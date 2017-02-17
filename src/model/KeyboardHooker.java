package model;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.awt.event.KeyEvent;
import java.util.HashSet;

/**
 * Created by Drew on 2017-02-14.
 */
public class KeyboardHooker extends Thread {
    private GlobalKeyboardHook keyboardHook;

    private boolean run;
    private CallBack callBack;
    private HashSet<String> pressingKeys;

    public KeyboardHooker(CallBack callBack) {
        keyboardHook = new GlobalKeyboardHook();
        run = true;
        this.callBack = callBack;
        pressingKeys = new HashSet<>();

        System.out.println("Global keyboard hook successfully started.");
        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                onKeyPressed(event);
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                onkeyReleased(event);
            }
        });
    }

    @Override
    public void run() {
        try {
            while (run) {
                Thread.sleep(64);
            }
        } catch (InterruptedException e) { /* nothing to do here */ } finally {
            keyboardHook.shutdownHook();
            System.out.println("KeyboardHooker is gone!");
        }
    }

    public void terminate() {
        this.run = true;
    }

    private void onKeyPressed(GlobalKeyEvent event) {
        System.out.println(event);

        pressingKeys.add(KeyEvent.getKeyText(event.getVirtualKeyCode())); //Mapper 필요

        System.out.println("! " + event.toString());
        String[] aa = pressingKeys.toArray(new String[]{});

        for (String a : aa) {
            System.out.println("~: " + a);
        }

        //callBack.setHookedKeys(pressingKeys.toArray(new String[]{}));

        /*if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
        }*/
    }

    private void onkeyReleased(GlobalKeyEvent event) {
        System.out.println(event);
        pressingKeys.remove(KeyEvent.getKeyText(event.getVirtualKeyCode()));
    }

    public interface CallBack {
        void setHookedKeys(String[] keys);
    }
}