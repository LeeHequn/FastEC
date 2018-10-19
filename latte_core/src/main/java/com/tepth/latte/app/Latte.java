package com.tepth.latte.app;

import android.content.Context;
import android.os.Handler;

/**
 * Description:全局类Latte
 *
 * @author Hequn.Lee
 * @date 2018/10/13
 */
@SuppressWarnings("ALL")
public final class Latte {
    /**
     * 配置文件全局初始化
     *
     * @param context 全局上下文
     * @return 配置文件类
     */
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }
}
