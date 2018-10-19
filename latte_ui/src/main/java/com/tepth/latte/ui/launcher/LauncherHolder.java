package com.tepth.latte.ui.launcher;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Description:启动图片Holder
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
@SuppressWarnings("ALL")
public class LauncherHolder extends Holder<Integer> {

    private AppCompatImageView mImageView = null;

    LauncherHolder(View itemView) {
        super(itemView);
        mImageView = (AppCompatImageView) itemView;
    }

    @Override
    protected void initView(View itemView) {
    }

    @Override
    public void updateUI(Integer data) {
        mImageView.setImageResource(data);
    }
}
