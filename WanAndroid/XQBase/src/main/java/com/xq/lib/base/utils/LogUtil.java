package com.xq.lib.base.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.LogcatLogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.xq.lib.base.BaseApplication;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 23:04
 */
public class LogUtil {
  public static String TAG = "LogUtil";

  /**
   * 初始化log工具，在app入口处调用
   *
   * @param isLogEnable 是否打印log
   */
  public static void init(boolean isLogEnable) {
    Logger.addLogAdapter(new AndroidLogAdapter(
        PrettyFormatStrategy.newBuilder()
            .methodOffset(2)
            .methodCount(1)
            .showThreadInfo(isLogEnable)
            .logStrategy(new LogcatLogStrategy())
            .build()
    ));
//    Logger.addLogAdapter(new DiskLogAdapter());
//    Logger.init("LogHttpInfo")
//        .hideThreadInfo()
//        .logLevel(isLogEnable ? LogLevel.FULL : LogLevel.NONE)
//        .methodOffset(2);
  }

  public static void d(String message) {
    Logger.d(message);
  }

  public static void d(Object obj) {
    jsonD(obj);
  }

  public static void d(String message, Object... args) {
    executeSync(() -> Logger.d(message, args));
  }

  private static void executeSync(Runnable runnable) {
    BaseApplication.getIns().execute(runnable);
  }

  public static void i(String message) {
    Logger.i(message);
  }

  public static void i(String message, Object... args) {
    executeSync(() -> Logger.i(message, args));
  }

  public static void w(String message, Throwable e) {
    String info = e != null ? e.toString() : "null";
    Logger.w(message + "：" + info);
  }

  public static void w(String message, Object... args) {
    executeSync(() -> Logger.w(message, args));
  }

  public static void e(String message, Throwable e) {
    Logger.e(e, message);
  }

  public static void json(int priority, Object obj) {
    executeSync(() -> Logger.log(priority, TAG, new Gson().toJson(obj), null));
  }

  public static void jsonD(Object obj) {
    json(Log.DEBUG, obj);
  }

  public static void jsonI(Object obj) {
    json(Log.INFO, obj);
  }

  public static void jsonW(Object obj) {
    json(Log.WARN, obj);
  }

  public static void jsonE(Object obj) {
    json(Log.ERROR, obj);
  }
}