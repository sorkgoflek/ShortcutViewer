package policy;

import java.awt.*;

/**
 * Created by Drew on 2017-02-15.
 */
public class Constant {
    public static final int APP_WIDTH = 300;
    public static final int APP_HEIGHT = 800;

    public static final int FONT_DEFAULT_SIZE = 13;
    public static final Color FONT_COLOR_WHITE = new Color(255, 255, 255);
    public static final Color FONT_COLOR_GRAY = new Color(125, 125, 125);
    public static final Color FONT_COLOR_BLACK = new Color(0, 0, 0);
    public static final Color FONT_COLOR = FONT_COLOR_WHITE;

    public static final String SHORTCUTLIST_FILE_PATH = "ShortcutList.txt";

    public static final String[] MODIDIER_KEYS = new String[]{"Alt", "Ctrl", "Win", "Shift"};

    public static final int AUTO_SCROLL_SPEED = 4;
    public static final int AUTO_SCROLL_BEGIN_MAX_SKIP_TIMES = 60;
    public static final int AUTO_SCROLL_END_MAX_SKIP_TIMES = AUTO_SCROLL_BEGIN_MAX_SKIP_TIMES * 2;

    public static final int HOOKER_SLEEP_TIME_MILLISEC = 64;

    public static final int TRANSPARENT_VALUE = 0;
}
