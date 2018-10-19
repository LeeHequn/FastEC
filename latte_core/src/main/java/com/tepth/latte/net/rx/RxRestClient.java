package com.tepth.latte.net.rx;

import android.content.Context;

import com.tepth.latte.net.HttpMethod;
import com.tepth.latte.net.RestCreator;
import com.tepth.latte.ui.loader.LatteLoader;
import com.tepth.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Description:整合了RxJava2的网络请求工具
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
@SuppressWarnings("ALL")
public class RxRestClient {
    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final RequestBody BODY;
    private final File FILE;
    private final LoaderStyle LOADERSYTLE;
    private final Context CONTEXT;


    public RxRestClient(String url,
                        WeakHashMap<String, Object> params,
                        RequestBody body,
                        File file,
                        Context context,
                        LoaderStyle loaderStyle) {
        this.URL = url;
        this.PARAMS = params;
        this.BODY = body;
        this.FILE = file;
        this.CONTEXT = context;
        this.LOADERSYTLE = loaderStyle;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    /**
     * 写一个Request请求
     *
     * @param method 请求的枚举类型
     */
    private Observable<String> request(HttpMethod method) {
        final RxRestService service = RestCreator.getRxRestService();
        Observable<String> observable = null;

        //显示菊花
        if (LOADERSYTLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADERSYTLE);
        }

        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                observable = service.postRaw(URL, BODY);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                observable = service.putRaw(URL, BODY);
                break;
            case DELETE:
                observable = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                observable = service.upload(URL, body);
                break;
            default:
                break;
        }
        return observable;
    }

    public final Observable<String> get() {
        return request(HttpMethod.GET);
    }

    public final Observable<String> post() {
        //采用的是传参的POST请求
        if (BODY == null) {
            return request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.POST_RAW);
        }

    }

    public final Observable<String> put() {
        //采用的是传参的POST请求
        if (BODY == null) {
            return request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.PUT_RAW);
        }
    }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }

    public final Observable<ResponseBody> download() {
        return RestCreator.getRxRestService().download(URL, PARAMS);
    }
}
