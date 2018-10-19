package com.tepth.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.tepth.latte.activities.BaseProxyActivity;
import com.tepth.latte.delegates.BaseLatteDelegate;
import com.tepth.latte.ec.launcher.LauncherDelegate;
import com.tepth.latte.ec.main.EcBottomDelegate;
import com.tepth.latte.ec.sign.ISignListener;
import com.tepth.latte.ec.sign.SignUpDelegate;
import com.tepth.latte.ui.launcher.ILauncherListener;
import com.tepth.latte.ui.launcher.OnLauncherFinishTag;

/**
 * Description:测试Activity
 *
 * @author Hequn.Lee
 * @date 2018/10/14
 */
public class ExampleActivity extends BaseProxyActivity implements ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public BaseLatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        getSupportDelegate().startWithPop(new EcBottomDelegate());
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        getSupportDelegate().startWithPop(new EcBottomDelegate());

    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束了，用户登陆了", Toast.LENGTH_SHORT).show();
                getSupportDelegate().startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束了，用户没登陆", Toast.LENGTH_SHORT).show();
                getSupportDelegate().startWithPop(new SignUpDelegate());
                break;
            default:
                break;
        }
    }
}
