package util;

import java.awt.event.KeyEvent;

/**
 * Created by Drew on 2017-02-18.
 */
public class VirtualKeyConverter {
    public static String toString(int vk) {
        switch (vk) {
            // number
            case KeyEvent.VK_0:
            case KeyEvent.VK_NUMPAD0:
                return "0";
            case KeyEvent.VK_1:
            case KeyEvent.VK_NUMPAD1:
                return "1";
            case KeyEvent.VK_2:
            case KeyEvent.VK_NUMPAD2:
                return "2";
            case KeyEvent.VK_3:
            case KeyEvent.VK_NUMPAD3:
                return "3";
            case KeyEvent.VK_4:
            case KeyEvent.VK_NUMPAD4:
                return "4";
            case KeyEvent.VK_5:
            case KeyEvent.VK_NUMPAD5:
                return "5";
            case KeyEvent.VK_6:
            case KeyEvent.VK_NUMPAD6:
                return "6";
            case KeyEvent.VK_7:
            case KeyEvent.VK_NUMPAD7:
                return "7";
            case KeyEvent.VK_8:
            case KeyEvent.VK_NUMPAD8:
                return "8";
            case KeyEvent.VK_9:
            case KeyEvent.VK_NUMPAD9:
                return "9";

            // character
            case KeyEvent.VK_A:
                return "A";
            case KeyEvent.VK_B:
                return "B";
            case KeyEvent.VK_C:
                return "C";
            case KeyEvent.VK_D:
                return "D";
            case KeyEvent.VK_E:
                return "E";
            case KeyEvent.VK_F:
                return "F";
            case KeyEvent.VK_G:
                return "G";
            case KeyEvent.VK_H:
                return "H";
            case KeyEvent.VK_I:
                return "I";
            case KeyEvent.VK_J:
                return "J";
            case KeyEvent.VK_K:
                return "K";
            case KeyEvent.VK_L:
                return "L";
            case KeyEvent.VK_M:
                return "M";
            case KeyEvent.VK_N:
                return "N";
            case KeyEvent.VK_O:
                return "O";
            case KeyEvent.VK_P:
                return "P";
            case KeyEvent.VK_Q:
                return "Q";
            case KeyEvent.VK_R:
                return "R";
            case KeyEvent.VK_S:
                return "S";
            case KeyEvent.VK_T:
                return "T";
            case KeyEvent.VK_U:
                return "U";
            case KeyEvent.VK_V:
                return "V";
            case KeyEvent.VK_W:
                return "W";
            case KeyEvent.VK_X:
                return "X";
            case KeyEvent.VK_Y:
                return "Y";
            case KeyEvent.VK_Z:
                return "Z";

            // function
            case KeyEvent.VK_F1:
                return "F1";
            case KeyEvent.VK_F2:
                return "F2";
            case KeyEvent.VK_F3:
                return "F3";
            case KeyEvent.VK_F4:
                return "F4";
            case KeyEvent.VK_F5:
                return "F5";
            case KeyEvent.VK_F6:
                return "F6";
            case KeyEvent.VK_F7:
                return "F7";
            case KeyEvent.VK_F8:
                return "F8";
            case KeyEvent.VK_F9:
                return "F9";
            case KeyEvent.VK_F10:
                return "F10";
            case KeyEvent.VK_F11:
                return "F11";
            case KeyEvent.VK_F12:
                return "F12";

            //operator
            case KeyEvent.VK_SUBTRACT:
                return "-";
            case KeyEvent.VK_DIVIDE:
                return "/";
            case KeyEvent.VK_MULTIPLY:
                return "*";
            case KeyEvent.VK_ADD:
                return "+";

            // modifier
            case KeyEvent.VK_BRACELEFT:
            case KeyEvent.VK_GREATER:
                return "Shift";
            case 0xa4:
            case 0xa5:
                return "Alt";
            case KeyEvent.VK_BRACERIGHT:
            case 0xa3:
                return "Ctrl";
            case KeyEvent.VK_OPEN_BRACKET:
            case KeyEvent.VK_BACK_SLASH:
                return "Win";
            case KeyEvent.VK_TAB:
                return "Tab";

            // arrow
            case KeyEvent.VK_UP:
                return "↑";
            case KeyEvent.VK_DOWN:
                return "↓";
            case KeyEvent.VK_LEFT:
                return "←";
            case KeyEvent.VK_RIGHT:
                return "→";

            // etc
            case KeyEvent.VK_ESCAPE:
                return "Esc";
            case KeyEvent.VK_SPACE:
                return "Space";
            case KeyEvent.VK_PAGE_UP:
                return "PageUp";
            case KeyEvent.VK_PAGE_DOWN:
                return "PageDown";
            case KeyEvent.VK_END:
                return "End";
            case KeyEvent.VK_HOME:
                return "Home";
            case KeyEvent.VK_PERIOD:
                return "Delete";
            case KeyEvent.VK_MINUS:
                return "Insert";
            case 0xd:
                return "Enter";
            case KeyEvent.VK_BACK_SPACE:
                return "BackSpace";
            case KeyEvent.VK_BACK_QUOTE:
                return "`";

            default:
                return "";
        }
    }
}
