package com.tepth.latte.ec.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.tepth.latte.ec.R;
import com.tepth.latte.ui.recycler.BaseRgbValue;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    /**
     * 顶部距离
     */
    private int mDistanceY = 0;

    /**
     * 颜色变化的速度
     */
    private static final int SHOW_SPEED = 3;

    private final BaseRgbValue RGB_VALUE = BaseRgbValue.create(255, 124, 5);

    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当滑动的控件为RecyclerView时,重写onNestedPreScroll方法更改Toolbar的透明度
     *
     * @param parent     CoordinatorLayout父布局
     * @param child      Toolbar子布局
     * @param dependency 滑动的布局
     * @return 是否控制该布局
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull Toolbar child, @NonNull View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    /**
     * 此方法极其重要，决定是否要处理滑动事件
     *
     * @param coordinatorLayout CoordinatorLayout父布局
     * @param child             Toolbar子布局
     * @param directTargetChild 滑动的布局
     * @param target            目标布局
     * @param axes              横向纵向判断
     * @param type              是否控制处理
     * @return 返回是否处理滑动事件
     */
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, 0);
        //增加滑动距离
        mDistanceY += dy;
        //获取Toolbar的高度
        final int targetHeight = child.getBottom();
        //当滑动时，滑动距离小于Toolbar高度时，调整渐变色
        if (mDistanceY > 0 && mDistanceY <= targetHeight) {
            //比例
            final float scale = (float) mDistanceY / targetHeight;
            final float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int) alpha, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        } else if (mDistanceY > targetHeight) {
            //当滑动过快时，恢复原来的颜色
            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        }
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return true;
    }
}
