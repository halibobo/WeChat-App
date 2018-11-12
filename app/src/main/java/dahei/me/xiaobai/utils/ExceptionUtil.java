package dahei.me.xiaobai.utils;

/**
 * created by yubosu
 * 2018年11月08日4:57 PM
 */
public class ExceptionUtil {

    public static void notNullException(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }

}
