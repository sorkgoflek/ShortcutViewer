package model;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

/**
 * Created by Drew on 2017-02-14.
 */
public class KetboardHooker extends Thread {
    private boolean run;
    GlobalKeyboardHook keyboardHook;

    public KetboardHooker() {
        run = true;
        keyboardHook = new GlobalKeyboardHook();

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown.");
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
                Thread.sleep(128);
            }
        } catch (InterruptedException e) { /* nothing to do here */ } finally {
            keyboardHook.shutdownHook();
        }
    }

    public void terminate(){
        this.run = true;
    }

    private void onKeyPressed(GlobalKeyEvent event){
        System.out.println(event);
        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE){}
    }

    private void onkeyReleased(GlobalKeyEvent event){
        System.out.println(event);
    }
}
