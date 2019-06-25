package com.xmqiu.wanandroid.network;

import com.xq.lib.base.utils.LogUtil;
import com.xmqiu.wanandroid.network.request.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:00
 */
public class NetWorkManager {
  final static String TAG = "NetWork";
  private static NetWorkManager INSTANCE;
  private static Retrofit mRetrofit;
  private static volatile Request mRequest;

  public static NetWorkManager getInstance() {
    if (null == INSTANCE) {
      synchronized (NetWorkManager.class) {
        if (null == INSTANCE) {
//          synchronized (NetWorkManager.class) {
          INSTANCE = new NetWorkManager();
//          }
        }
      }
    }
    return INSTANCE;
  }


  public void init() {
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new CookieInterceptor())
        .addNetworkInterceptor(new HttpLoggingInterceptor(message -> android.util.Log.d(TAG, message))
            .setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(8, TimeUnit.SECONDS)
        //设置Cookie管理器
        .cookieJar(cookieJar)
        .build();
    mRetrofit = new Retrofit.Builder()
        .client(client)
        .baseUrl(Request.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static Request getRequest() {
    if (mRequest == null) {
      synchronized (Request.class) {
        mRequest = mRetrofit.create(Request.class);
      }
    }
    return mRequest;
  }


  CookieJar cookieJar = new CookieJar() {
    //存储数据
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
      // TODO Auto-generated method stub
      LogUtil.d("cookieJar saveFromResponse: %s", url.host());
      for (Cookie cookie : cookies) {
        LogUtil.d("cookie: %s, value: %s, domain: %s, path: %s, secret: %s", cookie.name(),cookie.value(), cookie.domain(), cookie.path(), cookie.secure());
      }
//      LogUtil.jsonI(cookies);
    }//读取数据

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
      // TODO Auto-generated method stub
      LogUtil.d("cookieJar loadForRequest: %s", url.host());
      return new ArrayList<>();
    }
  };
}
