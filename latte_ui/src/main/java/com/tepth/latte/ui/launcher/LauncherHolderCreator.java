package com.tepth.latte.ui.launcher;

import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.tepth.latte.ui.R;

/**
 * Description:启动图片Holder创建者
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public class LauncherHolderCreator implements CBViewHolderCreator {
    @Override
    public Holder createHolder(View itemView) {
        return new LauncherHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_launcher_holder;
    }
}
