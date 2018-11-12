package dahei.me.xiaobai;

import android.app.Application;
import android.content.res.Configuration;

import dahei.me.xiaobai.utils.BaiLog;

/**
 * created by yubosu
 * 2018年11月08日3:31 PM
 */
public class BaseApplication extends Application {

    private  String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        BaiLog.i(TAG, "onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        BaiLog.i(TAG, "onTerminate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BaiLog.i(TAG, "onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        BaiLog.i(TAG, "onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        BaiLog.i(TAG, "onTrimMemory" + level);
    }
}
