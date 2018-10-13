package com.tepth.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.LatteDelegate;

/**
 * Description:测试Delegate
 *
 * @author Hequn.Lee
 * @date 2018/10/14
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
