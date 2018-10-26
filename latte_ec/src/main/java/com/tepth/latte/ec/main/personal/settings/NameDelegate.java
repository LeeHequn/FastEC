package com.tepth.latte.ec.main.personal.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.R;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public class NameDelegate extends BaseLatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_name;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
