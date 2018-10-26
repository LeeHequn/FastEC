package com.tepth.latte.ui.camera;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.FileUtils;
import com.tepth.latte.delegates.BasePermissionCheckerDelegate;
import com.tepth.latte.ui.R;
import com.tepth.latte.utils.file.FileUtil;

import java.io.File;

/**
 * Description:相片处理类
 *
 * @author Hequn.Lee
 * @date 2018/10/26
 */
public class CameraHandler implements View.OnClickListener {

    private final AlertDialog DIALOG;
    private final BasePermissionCheckerDelegate DELEGATE;

    public CameraHandler(AlertDialog dialog, BasePermissionCheckerDelegate delegate) {
        DIALOG = dialog;
        DELEGATE = delegate;
    }

    public void beginPayDialog() {
        DIALOG.show();
        final Window window = DIALOG.getWindow();
        if (window != null) {
            window.setContentView(R.layout.dialog_camera_panel);
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.anim_panel_up_from_bottom);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置属性
            final WindowManager.LayoutParams params = window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.alpha = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            params.dimAmount = 0.5f;
            window.setAttributes(params);
            window.findViewById(R.id.btn_dialog_camera).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_native).setOnClickListener(this);
            window.findViewById(R.id.btn_dialog_cancel).setOnClickListener(this);
        }
    }

    private String getPhotoName() {
        return FileUtil.getFileNameByTime("IMG", "jpg");
    }

    private void takePhoto() {
        final String currentPhotoName = getPhotoName();
        final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        final File tempFile = new File(FileUtil.CAMERA_PHOTO_DIR, currentPhotoName);
        //兼容7.0及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            final ContentValues contentValues = new ContentValues(1);
            contentValues.put(MediaStore.Images.Media.DATA, tempFile.getPath());
            final Uri uri = DELEGATE.getContext().
                    getContentResolver().
                    insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            //需要将uri路径转为实际路径
            final File realFile = FileUtils.getFileByPath(FileUtil.getRealFilePath(DELEGATE.getContext(), uri));
            final Uri realUri = Uri.fromFile(realFile);

        }
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.btn_dialog_camera) {

            DIALOG.cancel();
        } else if (id == R.id.btn_dialog_native) {

            DIALOG.cancel();
        } else if (id == R.id.btn_dialog_cancel) {
            DIALOG.cancel();
        }
    }
}
