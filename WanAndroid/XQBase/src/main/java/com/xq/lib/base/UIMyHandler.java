package com.xq.lib.base;

import android.os.Message;

public class UIMyHandler extends UIHandler<BaseActivity> {

  public UIMyHandler(BaseActivity cls) {
    super(cls);
  }

  @Override
  public void handleMessage(Message msg) {
    super.handleMessage(msg);
    BaseActivity activity = ref.get();
    if (activity == null || activity.isFinish()) {
      return;
    }
  }
}