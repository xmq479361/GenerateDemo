package com.xmqiu.wanandroid.pages;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.base.AppActivity;
import com.xmqiu.wanandroid.common.cache.UserInfoManager;
import com.xmqiu.wanandroid.model.net.UserBean;
import com.xmqiu.wanandroid.pages.login.LoginActivity;
import com.xq.lib.base.utils.LogUtil;

public class SplashActivity extends AppActivity {
  final long TIME_DELAY = 300;

  @Override
  public int getLayoutId() {
    return R.layout.activity_splash;
  }

  @Override
  protected void onResume() {
    super.onResume();
    getHandler().postDelayed(delayedLoginRunnable, TIME_DELAY);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //满屏显示
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    super.onCreate(savedInstanceState);
  }

  Runnable delayedLoginRunnable = () -> {
    UserBean userBean = UserInfoManager.getCacheUserBean();
    LogUtil.jsonI(userBean);
    LoginActivity.launch(SplashActivity.this);
    finish();
  };

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      return false;
    }
    return false;
  }
}
