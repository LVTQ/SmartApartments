package cn.tklvyou.smartapartments.common;

/**
 * 常量
 */

public class Contacts {
    public static final String PACKAGE_NAME  = "cn.tklvyou.smartapartments";
    public static String DEV_BASE_URL = "https://api.douban.com/v2/";


    public static final String KEY_CACHE = "KEY_CACHE";//开启缓存
    public static final String KEY_PRELOAD = "KEY_PRELOAD";//开启预加载

    public static final String KEY_VOICE = "KEY_VOICE";//开启通知声
    public static final String KEY_VIBRATE = "KEY_VIBRATE";//开启震动
    public static final String KEY_NO_DISTURB = "KEY_NO_DISTURB";//夜间防打扰

    public static final String KEY_IS_ON_TEST_MODE = "KEY_IS_ON_TEST_MODE";//测试模式
    public static final String KEY_IS_FIRST_START = "KEY_IS_FIRST_START";//第一次打开应用


    public static boolean cache = true;//开启缓存
    public static boolean preload = true;//开启预加载

    public static boolean voice = true;//开启通知声
    public static boolean vibrate = true;//开启震动
    public static boolean noDisturb = false;//夜间防打扰

    public static boolean isOnTestMode = false;//测试模式
    public static boolean isFirstStart = true;//第一次打开应用


}
