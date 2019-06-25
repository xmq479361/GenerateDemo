package com.xmqiu.wanandroid.common.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.xmqiu.wanandroid.MainApp;
import com.xmqiu.wanandroid.model.net.UserBean;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:34
 */
public class UserInfoManager {
  final static String SP_KEY_USER = "sp_user";
  final static String SP_KEY_UNAME = "sp_un";
  final static String SP_KEY_UINFO = "sp_uinfo";
  final static String SP_KEY_COOKIE = "sp_cookie";
  private static final String SP_KEY_UPWD  ="sp_upwd";

  static Context getContext() {
    return MainApp.getIns();
  }

  public static  String getString(String name,String defaultValue){
    return SPUtils.getInstance().getString(name, defaultValue);
  }
  public static String getCacheUserName() {
    return getString(SP_KEY_UNAME, "");
  }
  public static String getCacheUserPwd() {
    return getString(SP_KEY_UPWD, "");
  }

  public static void saveCacheUserName(String uName) {
    SPUtils.getInstance().put(SP_KEY_UNAME, uName);
  }

  public static UserBean getCacheUserBean() {
    String uinfoStr = getString(SP_KEY_UINFO, "");
    if (null != uinfoStr) {
      UserBean loginBean = new Gson().fromJson(uinfoStr, UserBean.class);
      if (null != loginBean) {

      }
    }
    return null;
  }

  public static void saveCacheUser(UserBean data) {
    SPUtils.getInstance().put(SP_KEY_UINFO, new Gson().toJson(data));
  }

  public static void saveUserCookieId(String cookieStr) {
    SPUtils.getInstance().put(SP_KEY_COOKIE, cookieStr);
  }

  public static String getCookieId() {
    return getString(SP_KEY_COOKIE, "");
  }

  public static void cacheCacheUserPwd(String pwd) {
     SPUtils.getInstance().put(SP_KEY_UPWD, pwd);
  }
//  public static UserBean login(){
//
//  }
}
