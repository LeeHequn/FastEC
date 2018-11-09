package com.tepth.latte.ui.camera;

import com.yalantis.ucrop.UCrop;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public class RequestCodes {

    /**
     * 拍照
     */
    public static final int TAKE_PHOTO = 4;
    /**
     * 选择相片
     */
    public static final int PICK_PHOTO = 5;
    /**
     * 拍照成功返回码
     */
    public static final int CROP_PHOTO = UCrop.REQUEST_CROP;
    /**
     * 拍照错误返回码
     */
    public static final int CROP_ERROR = UCrop.RESULT_ERROR;
    /**
     * 扫描
     */
    public static final int SCAN = 7;

}
