package com.xq.lib.base;

import android.os.Bundle;
import android.view.View;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/30 12:39
 */
public interface IBaseView extends View.OnClickListener{

  void initData(Bundle bundle);
  int getLayoutId();
  void setRootLayout(int layoutResId);
  void initView(Bundle saveInstanceState, View contentView);
  void doBusiness();
  void onWidgetClick(View view);
//  fun bindLayout(): Int
//  fun setRootLayout(layoutId: Int)
//  fun initView(savedInstanceState: Bundle?, contentView: View)
//  fun doBusiness()
//  fun onWidgetClick(view: View)
}
