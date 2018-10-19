package com.tepth.latte.net.download;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.tepth.latte.net.RestCreator;
import com.tepth.latte.net.callback.IError;
import com.tepth.latte.net.callback.IFailure;
import com.tepth.latte.net.callback.IRequest;
import com.tepth.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description:下载文件的Handler
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
public class DownloadHandler {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,
                           WeakHashMap<String, Object> params,
                           IRequest request,
                           String dir,
                           String extension,
                           String name,
                           ISuccess success,
                           IFailure failure,
                           IError error) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    public final void handlerDownload() {
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download(URL, PARAMS).
                enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            final ResponseBody responseBody = response.body();
                            final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
                            //用线程池来执行
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                                    DOWNLOAD_DIR,
                                    EXTENSION,
                                    responseBody,
                                    NAME);
                            //这里一定要判断下载是否完成，不然会出现下载一半就开始安装的情况
                            if (task.isCancelled()) {
                                if (REQUEST != null) {
                                    REQUEST.onRequestEnd();
                                }
                            }
                        } else {
                            if (ERROR != null) {
                                ERROR.onError(response.code(), response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        if (FAILURE != null) {
                            FAILURE.onFailure();
                        }
                    }
                });
    }
}
