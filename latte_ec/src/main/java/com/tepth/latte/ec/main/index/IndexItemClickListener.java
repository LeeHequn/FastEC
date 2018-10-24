package com.tepth.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.detail.GoodsDetailDelegate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
public class IndexItemClickListener extends SimpleClickListener {

    /**
     * 容器Delegate
     */
    private final BaseLatteDelegate DELEGATE;

    private IndexItemClickListener(BaseLatteDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static SimpleClickListener create(BaseLatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create();
        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
