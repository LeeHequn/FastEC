package com.tepth.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class ImageHolder extends Holder<String> {

    private AppCompatImageView mImageView = null;
    private Context mContext = null;
    /**
     * 图片缓存策略
     */
    private static final RequestOptions BANNER_OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()
            .centerCrop();

    public ImageHolder(View itemView, Context context) {
        super(itemView);
        mImageView = (AppCompatImageView) itemView;
        mContext = context;
    }


    @Override
    protected void initView(View itemView) {

    }

    @Override
    public void updateUI(String data) {
        Glide.with(mContext)
                .load(data)
                .apply(BANNER_OPTIONS)
                .into(mImageView);
    }
}
