package com.tepth.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.main.sort.content.ContentDelegate;
import com.tepth.latte.ec.main.sort.list.VerticalListDelegate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/24
 */
public class SortDelegate extends BaseBottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container, listDelegate);
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1), false, false);
    }
}
