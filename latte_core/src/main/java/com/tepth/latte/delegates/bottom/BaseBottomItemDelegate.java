package com.tepth.latte.delegates.bottom;

import android.widget.Toast;

import com.tepth.latte.app.Latte;
import com.tepth.latte.core.R;
import com.tepth.latte.delegates.BaseLatteDelegate;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public abstract class BaseBottomItemDelegate extends BaseLatteDelegate {
    /**
     * 再点一次退出程序时间设置
     */
    private static final long WAIT_TIME = 2000L;
    private long touchTime = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - touchTime < WAIT_TIME) {
            _mActivity.finish();
        } else {
            touchTime = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
