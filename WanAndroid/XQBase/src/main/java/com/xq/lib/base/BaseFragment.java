package com.xq.lib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.AntiShakeUtils;
import com.xq.lib.base.utils.LogUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xmqiu
 * createDate $date()$ $time()$
 */
public abstract class BaseFragment extends Fragment implements IBaseView {
  protected String TAG = getClass().getSimpleName();
  private final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
  private Unbinder unbinder;
  protected Activity mActivity;
  protected LayoutInflater mInflater;
  protected View mContentView;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    mActivity = (Activity) context;
  }

  UIMyHandler ttsHandler;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
      boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
      if (null == getFragmentManager()) {
        return;
      }
      FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
      if (fragmentTransaction == null) {
        return;
      }
      if (isSupportHidden) {
        fragmentTransaction.hide(this).commitAllowingStateLoss();
      } else {
        fragmentTransaction.show(this).commitAllowingStateLoss();
      }
    }
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // TODO: inflate a fragment view
    mInflater = inflater;
    setRootLayout(getLayoutId());
    unbinder = ButterKnife.bind(this, mContentView);
    return mContentView;
  }

  @Override
  public void setRootLayout(int layoutResId) {
    if (layoutResId < 0) {
      return;
    }
    mContentView = mInflater.inflate(layoutResId, null);
  }

  @Override
  public void initData(Bundle bundle) {

  }

  @Override
  public void initView(Bundle saveInstanceState, View contentView) {

  }

  @Override
  public void onWidgetClick(View view) {

  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    isFinish = false;
    super.onViewCreated(view, savedInstanceState);
    initData(savedInstanceState);
    ttsHandler = new UIMyHandler(this);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    LogUtil.d(TAG, "onActivityCreated: ");
    super.onActivityCreated(savedInstanceState);
    initView(savedInstanceState, mContentView);
    doBusiness();
  }



  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    LogUtil.d(TAG, "onSaveInstanceState: ");
    super.onSaveInstanceState(outState);
    outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
  }

  @Override
  public void onDestroyView() {
    isFinish = true;
    unbinder.unbind();
    if (null != mContentView) {
      ViewParent parent = mContentView.getParent();
      if (parent != null && parent instanceof ViewGroup)
        ((ViewGroup) parent).removeView(mContentView);
    }
    super.onDestroyView();
  }

  @Override
  public final void onClick(View view) {
    if (AntiShakeUtils.isValid(view)) {
      onWidgetClick(view);
    }
  }
  public <T extends View> T findViewById(int id){
    return mContentView.findViewById(id);
  }

  public boolean isFinish() {
    return isFinish;
  }

  protected String getTextStr(TextView textView) {
    if (null != textView && null != textView.getText()) {
      return textView.getText().toString();
    }
    return "";
  }

  public Handler getHandler() {
    return ttsHandler;
  }

  public void post(Runnable runnable) {
    getHandler().post(runnable);
  }


  public void showToast(int resId) {
    LogUtil.d("%s showToast Res: %s ", TAG, getString(resId));
    post((Runnable) () -> Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT).show());
  }

  public void showToast(String resStr) {
    LogUtil.d("%s showToast: %s ", TAG, resStr);
    Toast.makeText(getActivity(), resStr, Toast.LENGTH_SHORT).show();
  }

  protected boolean isFinish = false;
  public class UIMyHandler extends UIHandler<BaseFragment> {

    public UIMyHandler(BaseFragment cls) {
      super(cls);
    }

    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
      BaseFragment activity = ref.get();
      if (activity == null || activity.isFinish()) {
        return;
      }
    }
  }
}
