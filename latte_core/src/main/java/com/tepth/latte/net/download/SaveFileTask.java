package com.tepth.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.tepth.latte.app.Latte;
import com.tepth.latte.net.callback.IRequest;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.utils.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Description:文件下载，APK自动安装
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody body = (ResponseBody) params[2];
        final String name = (String) params[3];
        final InputStream is = body.byteStream();
        if (downloadDir == null || "".equals(downloadDir)) {
            downloadDir = "down_loads";
        }
        if (extension == null || "".equals(extension)) {
            extension = "";
        }
        if (name == null) {
            return FileUtil.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(is, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        autoInstallApk(file);
    }

    /**
     * 自动安装APK
     *
     * @param file APK文件
     */
    private void autoInstallApk(File file) {
        if (FileUtil.APK.equals(FileUtil.getExtension(file.getPath()))) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
