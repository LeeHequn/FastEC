package com.tepth.latte.net.interceptors;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.tepth.latte.utils.storage.LattePreference;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:Cookie拦截器
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
@SuppressWarnings("ALL")
public final class CookieInterceptors implements Interceptor {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //拦截原始请求
        final Request.Builder builder = chain.request().newBuilder();
        Observable
                .just(LattePreference.getCustomAppProfile("cookie"))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull String cookie) throws Exception {
                        //给原生API请求附带上WebView拦截下来的Cookie
                        builder.addHeader("Cookie", cookie);
                    }
                });
        return chain.proceed(builder.build());
    }
}
