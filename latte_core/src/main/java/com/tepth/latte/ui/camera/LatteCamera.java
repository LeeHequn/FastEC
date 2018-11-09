package com.tepth.latte.ui.camera;

import android.net.Uri;

import com.tepth.latte.delegates.BasePermissionCheckerDelegate;
import com.tepth.latte.utils.file.FileUtil;

/**
 * Description:相片调用类
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse(
                FileUtil.createFile(
                        "crop_image",
                        FileUtil.getFileNameByTime(
                                "IMG", "jpg")).getPath());
    }

    public static void start(BasePermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginPayDialog();
    }
}
