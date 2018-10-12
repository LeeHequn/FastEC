package com.tepth.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tepth.latte.app.Latte;
import com.tepth.latte.ec.icon.FontEcModule;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/13
 */
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("127.0.0.1")
                .withIcon(new FontEcModule())
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}
