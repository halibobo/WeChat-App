package dahei.me.xiaobai.utils;

import android.util.Log;

import dahei.me.xiaobai.BuildConfig;

/**
 * created by yubosu
 * 2018年11月08日4:53 PM
 */
public class BaiLog {

    private static boolean DEBUG = BuildConfig.DEBUG;

    private BaiLog() {

    }

    public static void c(String tag, String... log) {
        if(DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : log) {
                stringBuilder.append(str).append("\n");
            }
            Log.d(tag, stringBuilder.toString());
        }
    }

    public static void d(String tag, String log) {
        if(DEBUG) {
            Log.d(tag, log);
        }
    }

    public static void i(String tag, String log) {
        if(DEBUG) {
            Log.i(tag, log);
        }
    }

    public static void e(String tag, String log) {
        if(DEBUG) {
            Log.e(tag, log);
        }
    }


    public static void v(String tag, String log) {
        if(DEBUG) {
            Log.v(tag, log);
        }
    }

    public static void w(String tag, String log) {
        if(DEBUG) {
            Log.w(tag, log);
        }
    }

}
