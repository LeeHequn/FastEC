package com.tepth.latte.net.callback;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.tepth.latte.ui.loader.LatteLoader;
import com.tepth.latte.ui.loader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Description:网络请求回调
 *
 * @author Hequn.Lee
 * @date 2018/10/15
 */
public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    /**
     * Handler尽量声明成static类型，防止内存泄漏
     */
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
        //判断response执行成功了
        if (response.isSuccessful()) {
            //call是否被执行过了
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        closeLoading();
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        closeLoading();
    }

    private void closeLoading() {
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.closeLoading();
                }
            }, 1000);
        }
    }
}
