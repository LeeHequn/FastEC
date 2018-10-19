package com.tepth.latte.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tepth.latte.activities.BaseProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Description:全局基础Fragment
 *
 * @author Hequn.Lee
 * @date 2018/10/13
 */
public abstract class BaseDelegate extends SwipeBackFragment {

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    /**
     * 设置布局文件
     *
     * @return 返回布局文件的对象
     */
    public abstract Object setLayout();

    /**
     * 绑定View
     *
     * @param savedInstanceState 保存的Bundle
     * @param rootView           绑定的View
     */
    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        }
        if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
        if (rootView != null) {
            mUnbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }
        return rootView;
    }

    public final BaseProxyActivity getProxyActivity() {
        return (BaseProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
