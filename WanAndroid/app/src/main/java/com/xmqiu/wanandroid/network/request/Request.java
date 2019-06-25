package com.xmqiu.wanandroid.network.request;

import com.xmqiu.wanandroid.model.net.ArticleBean;
import com.xmqiu.wanandroid.model.net.BannerBean;
import com.xmqiu.wanandroid.model.net.PageBean;
import com.xmqiu.wanandroid.model.net.Response;
import com.xmqiu.wanandroid.model.net.UserBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:06
 */
public interface Request {
  public final static String BASE_URL = "http://www.wanandroid.com";

  @POST("/user/login")
  Observable<Response<UserBean>> login(@Query("username") String username, @Query("password") String password);


  @POST("/user/register")
  Observable<Response<UserBean>> register(@Query("username") String username, @Query("password") String password, @Query("repassword") String repassword);

  @GET("/user/logout/json")
  Observable<Response<UserBean>> loginOut(@Query("username") String username);

  @GET("/banner/json")
  Observable<Response<List<BannerBean>>> getBanner();

  @GET("/article/list/{page}/json")
  Observable<Response<PageBean<ArticleBean>>> getArticles(@Path("page") String pageNo);

}
