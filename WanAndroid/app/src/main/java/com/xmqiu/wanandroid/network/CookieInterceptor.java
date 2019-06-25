package com.xmqiu.wanandroid.network;

import android.text.TextUtils;

import com.xmqiu.wanandroid.common.cache.UserInfoManager;
import com.xq.lib.base.utils.LogUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 23:21
 */
public class CookieInterceptor implements Interceptor {
  @Override
  public Response intercept(Chain chain) throws IOException {
    Response resp = chain.proceed(chain.request());
    List<String> cookies = resp.headers("Set-Cookie");
    String cookieStr = "";
    if (cookies != null && cookies.size() > 0) {
      for (int i = 0; i < cookies.size(); i++) {
        cookieStr += cookies.get(i);

      }
      LogUtil.i("cookie: %s", cookieStr);
      UserInfoManager.saveUserCookieId(cookieStr);
    }
    if (TextUtils.isEmpty(cookieStr)) {
      cookieStr = UserInfoManager.getCookieId();
      if (!TextUtils.isEmpty(cookieStr)) {
        return chain.proceed(chain.request().newBuilder()
            .header("Cookie",cookieStr)
            .build());
      }
    }
    return resp;
  }
}
