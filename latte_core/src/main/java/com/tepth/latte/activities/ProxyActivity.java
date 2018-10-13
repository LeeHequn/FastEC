package com.tepth.latte.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.tepth.latte.core.R;
import com.tepth.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Description:全局容器的Activity
 *
 * @author Hequn.Lee
 * @date 2018/10/13
 */
public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final FrameLayout container = new FrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
