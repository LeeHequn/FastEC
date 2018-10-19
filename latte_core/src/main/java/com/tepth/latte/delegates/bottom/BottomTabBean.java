package com.tepth.latte.delegates.bottom;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/19
 */
public final class BottomTabBean {
    /**
     * 图标
     */
    private final CharSequence ICON;
    /**
     * 文字
     */
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }

    @Override
    public int hashCode() {
        return ICON.hashCode() + TITLE.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BottomTabBean) {
            BottomTabBean bean = (BottomTabBean) obj;
            return ICON.equals(bean.getIcon()) && TITLE.equals(bean.getTitle());
        }
        return false;
    }
}
