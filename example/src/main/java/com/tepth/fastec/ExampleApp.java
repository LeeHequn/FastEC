package com.tepth.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tepth.latte.app.Latte;
import com.tepth.latte.ec.database.DatabaseManager;
import com.tepth.latte.ec.icon.FontEcModule;
import com.tepth.latte.net.interceptors.CookieInterceptors;

/**
 * Description:测试Application
 *
 * @author Hequn.Lee
 * @date 2018/10/13
 */
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://192.168.1.23:80/RestServer/api/")
                .withLoaderDelayed(1000)
                .withInterceptor(new CookieInterceptors())
                .withIcon(new FontEcModule())
                .withIcon(new FontAwesomeModule())
                .configure();
        DatabaseManager.getInstance().init(this);
    }
}
