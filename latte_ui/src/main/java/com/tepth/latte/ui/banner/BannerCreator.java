package com.tepth.latte.ui.banner;

import android.content.Context;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.tepth.latte.ui.R;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class BannerCreator {

    public static void setDefault(ConvenientBanner<String> convenientBanner,
                                  ArrayList<String> banners,
                                  Context context,
                                  OnItemClickListener clickListener) {
        //设置holder
        convenientBanner.setPages(new HolderCreator(context), banners)
                //设置底下的圆圈
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                //设置圆圈水平居中
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置点击图片事件
                .setOnItemClickListener(clickListener)
//                .setPageTransformer(new DefaultTransformer())
                //设置延迟时间3秒
                .startTurning(3000)
                //设置是否循环
                .setCanLoop(true);
    }
}
