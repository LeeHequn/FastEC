package com.tepth.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/23
 */
@AutoValue
public abstract class BaseRgbValue {

    /**
     * RedColor
     *
     * @return Red Color Int
     */
    public abstract int red();

    /**
     * GreenColor
     *
     * @return Green Color Int
     */
    public abstract int green();

    /**
     * BlueColor
     *
     * @return Blue Color Int
     */
    public abstract int blue();

    public static BaseRgbValue create(int red, int green, int blue) {
        return new AutoValue_BaseRgbValue(red, green, blue);
    }
}
