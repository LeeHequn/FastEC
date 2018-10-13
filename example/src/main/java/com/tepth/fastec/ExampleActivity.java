package com.tepth.fastec;

import com.tepth.latte.activities.ProxyActivity;
import com.tepth.latte.delegates.LatteDelegate;

/**
 * Description:测试Activity
 *
 * @author Hequn.Lee
 * @date 2018/10/14
 */
public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}
