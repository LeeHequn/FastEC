package com.tepth.latte.utils.resources;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import com.tepth.latte.app.Latte;

/**
 * Description:获取Resources相关的工具类
 *
 * @author Hequn.Lee
 * @date 2018/10/16
 */
@SuppressWarnings("ALL")
public class ResourcesUtil {
    /**
     * 获取屏幕宽度
     *
     * @return 屏幕宽度
     */
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 获取颜色的Int值
     *
     * @param context 上下文
     * @param color   颜色值
     * @return 颜色Int值
     */
    public static int getColorFromResources(Context context, int color) {
        return ContextCompat.getColor(context, color);
    }
}
