package com.xmqiu.wanandroid;


import com.xmqiu.wanandroid.base.AppApplication;
import com.xmqiu.wanandroid.network.NetWorkManager;
import com.xq.lib.base.utils.LogUtil;

/**
 * @author xmqiu
 * createDate: 2019/1/25 14:38
 */
public class MainApp extends AppApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    NetWorkManager.getInstance().init();
    LogUtil.init(BuildConfig.DEBUG);

  }
}
