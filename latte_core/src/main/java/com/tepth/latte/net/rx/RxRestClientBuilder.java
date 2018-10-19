package com.tepth.latte.net.rx;

import android.content.Context;

import com.tepth.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Description:整合了RxJava2的构建网络请求参数工具
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
@SuppressWarnings("ALL")
public class RxRestClientBuilder {
    private String mUrl = null;
    private final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private RequestBody mBody = null;
    private LoaderStyle mLoaderStyle = null;
    private Context mContext = null;
    private File mFile = null;

    RxRestClientBuilder() {
    }

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RxRestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RxRestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    public final RxRestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RxRestClient builder() {
        return new RxRestClient(mUrl,
                PARAMS,
                mBody,
                mFile,
                mContext,
                mLoaderStyle);
    }
}
