package com.xq.lib.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.AntiShakeUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.xq.lib.base.utils.LogUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xmqiu
 * createDate $date()$ $time()$
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
  protected String TAG = getClass().getSimpleName();
  protected View mContentView;
  protected Activity mActivity;
  Unbinder unbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    mActivity = this;
    isFinish = false;
    super.onCreate(savedInstanceState);
    initData(getIntent().getExtras());
    ttsHandler = new UIMyHandler(this);
    setRootLayout(getLayoutId());
    unbinder = ButterKnife.bind(this);
    initView(savedInstanceState, mContentView);

    doBusiness();
    AppUtils.registerAppStatusChangedListener(this, new Utils.OnAppStatusChangedListener() {
      @Override
      public void onForeground() {
        ToastUtils.showShort("foreground");
      }

      @Override
      public void onBackground() {
        ToastUtils.showShort("background");

      }
    });
  }

  @Override
  protected void onDestroy() {
    isFinish = true;
    unbinder.unbind();
    AppUtils.unregisterAppStatusChangedListener(this);
    KeyboardUtils.fixSoftInputLeaks(this);
    super.onDestroy();
  }

  @Override
  public final void onClick(View view) {
    if (AntiShakeUtils.isValid(view)) {
      onWidgetClick(view);
    }
  }

  @Override
  public void setRootLayout(int layoutId) {
    if (layoutId <= 0) {
      return;
    }
    mContentView = LayoutInflater.from(this).inflate(layoutId, null);
    setContentView(mContentView);
  }

  @Override
  public void initData(Bundle bundle) {

  }

  @Override
  public void initView(Bundle savedInstanceState, View contentView) {

  }

  @Override
  public void doBusiness() {

  }

  @Override
  public void onWidgetClick(View view) {

  }


  public boolean isFinish() {
    return isFinish;
  }

  protected boolean isFinish = false;
  UIMyHandler ttsHandler;

  public Handler getHandler() {
    return ttsHandler;
  }

  public void post(Runnable runnable) {
    getHandler().post(runnable);
  }

  public void postAsync(Runnable runnable) {
    BaseApplication.getIns().execute(runnable);
  }

  public void postDelayed(Runnable runnable, long delayedTimeMills) {
    getHandler().postDelayed(runnable, delayedTimeMills);
  }


  public void showToast(int resId) {
    LogUtil.d("%s showToast Res: %s ", TAG, getString(resId));
    post((Runnable) () -> Toast.makeText(getBaseContext(), resId, Toast.LENGTH_SHORT).show());
  }

  public void showToast(String resStr) {
    LogUtil.d("%s showToast: %s ", TAG, resStr);
    Toast.makeText(getBaseContext(), resStr, Toast.LENGTH_SHORT).show();
  }

  protected String getTextStr(TextView textView) {
    if (null != textView && null != textView.getText()) {
      return textView.getText().toString();
    }
    return "";
  }

}
