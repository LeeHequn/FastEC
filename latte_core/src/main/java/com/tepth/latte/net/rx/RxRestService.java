package com.tepth.latte.net.rx;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Description:RxJava2网络请求框架工具方法
 *
 * @author Hequn.Lee
 * @date 2018/10/18
 */
public interface RxRestService {
    /**
     * get请求方法
     *
     * @param url    请求的URL
     * @param params 请求的参数
     * @return 返回的观察者
     */
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, Object> params);

    /**
     * post请求
     *
     * @param url    请求的URL
     * @param params 请求的参数
     * @return 返回的观察者
     */
    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, Object> params);

    /**
     * post_raw请求
     *
     * @param url  请求的URL
     * @param body 请求的BODY
     * @return 返回的观察者
     */
    @POST
    Observable<String> postRaw(@Url String url, @Body RequestBody body);

    /**
     * put请求
     *
     * @param url    请求的URL
     * @param params 请求的参数
     * @return 返回的观察者
     */
    @FormUrlEncoded
    @PUT
    Observable<String> put(@Url String url, @FieldMap Map<String, Object> params);

    /**
     * put_raw请求
     *
     * @param url  请求的URL
     * @param body 请求的BODY
     * @return 返回的观察者
     */
    @PUT
    Observable<String> putRaw(@Url String url, @Body RequestBody body);

    /**
     * delete请求
     *
     * @param url    请求的URL
     * @param params 请求的参数
     * @return 返回的观察者
     */
    @DELETE
    Observable<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    /**
     * download请求
     * Streaming 加上这个就不会出现写入过长的数据造成的内存溢出
     *
     * @param url    请求的URL
     * @param params 请求的参数
     * @return 返回的观察者
     */
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    /**
     * upload请求
     *
     * @param url  请求的URL
     * @param file 上传的文件
     * @return 返回的观察者
     */
    @Multipart
    @POST
    Observable<String> upload(@Url String url, @Part MultipartBody.Part file);
}
