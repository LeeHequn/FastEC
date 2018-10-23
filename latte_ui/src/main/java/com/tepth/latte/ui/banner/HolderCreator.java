package com.tepth.latte.ui.banner;

import android.content.Context;
import android.view.View;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.tepth.latte.ui.R;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class HolderCreator implements CBViewHolderCreator {

    private Context mContext = null;

    public HolderCreator(Context context) {
        mContext = context;
    }

    @Override
    public Holder createHolder(View itemView) {
        return new ImageHolder(itemView, mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_image_holder;
    }
}
