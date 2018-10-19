package com.tepth.latte.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.tepth.latte.core.R;
import com.tepth.latte.utils.resources.ResourcesUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Description:控制Loading菊花的类
 *
 * @author Hequn.Lee
 * @date 2018/10/16
 */
@SuppressWarnings("ALL")
public class LatteLoader {
    /**
     * 屏幕缩放比
     */
    private static final int LOADER_SIZE_SCALE = 8;
    /**
     * 偏移量
     */
    private static final int LOADER_OFFSET_SCALE = 10;
    /**
     * 新建一个存放所有LOADER的集合，当关闭的时候遍历它然后一一关闭即可
     */
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    /**
     * 写一个默认的LOADER动画
     */
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceHeight = ResourcesUtil.getScreenHeight();
        int deviceWidth = ResourcesUtil.getScreenWidth();

        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            //居中
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void closeLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    //cancel()会回调相应的cancel方法
                    dialog.cancel();
//                    dialog.dismiss();//dismiss()只是单纯的关闭LOADER
                }
            }
        }
    }
}
