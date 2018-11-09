package com.tepth.latte.ui.camera;

import android.net.Uri;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public final class CameraImageBean {

    private Uri mPath = null;

    private static final CameraImageBean INSTANCE = new CameraImageBean();

    public static CameraImageBean getInstance() {
        return INSTANCE;
    }

    public Uri getPath() {
        return mPath;
    }

    void setPath(Uri mPath) {
        this.mPath = mPath;
    }
}