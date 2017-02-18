package model;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import policy.Constant;
import util.VirtualKeyConverter;

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
                Thread.sleep(Constant.HOOKER_SLEEP_TIME_MILLISEC);
            }
        } catch (InterruptedException e) { /* nothing to do here */ } finally {
            keyboardHook.shutdownHook();
            pressingKeys.clear();
            System.out.println("KeyboardHooker is gone!");
        }
    }

    public void terminate() {
        this.run = true;
    }

    private void onKeyPressed(GlobalKeyEvent event) {
        pressingKeys.add(VirtualKeyConverter.toString(event.getVirtualKeyCode()));

        printKey(event);

        callBack.setHookedKeys(pressingKeys.toArray(new String[]{}));
    }

    private void onkeyReleased(GlobalKeyEvent event) {
        pressingKeys.remove(VirtualKeyConverter.toString(event.getVirtualKeyCode()));

        //printPressingKeys();

        if (pressingKeys.isEmpty()) {
            System.out.println("pressingKeys is Empty");
            callBack.setEmptyKeys();
        } else {
            callBack.setHookedKeys(pressingKeys.toArray(new String[]{}));
        }
    }

    private void printKey(GlobalKeyEvent event) {
        String str = KeyEvent.getKeyText(event.getVirtualKeyCode());
        str += "(" + event.getVirtualKeyCode() + ") is ";
        str += VirtualKeyConverter.toString(event.getVirtualKeyCode());

        System.out.println("--------------printKey-------------");
        System.out.println(str);
    }

    private void printPressingKeys() {
        System.out.println("--------------printPressingKeys-------------");
        for (String str : pressingKeys) {
            System.out.println(str);
        }
    }

    public interface CallBack {
        void setHookedKeys(String[] keys);

        void setEmptyKeys();
    }
}
