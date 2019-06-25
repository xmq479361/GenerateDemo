package com.xmqiu.wanandroid.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xmqiu.wanandroid.R;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 2:35
 */
public class HomeMenuItemView extends LinearLayout {
  public HomeMenuItemView(Context context) {
    super(context);
    init();
  }

  public HomeMenuItemView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public HomeMenuItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  ImageView iconView;
  TextView textView;

  void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_layout_menu_item, this, true);
    textView = findViewById(R.id.id_view_hmiv_text);
    iconView = findViewById(R.id.id_view_hmiv_img);
  }

  boolean isFocus;

  public void setItemFocus(boolean isFocus) {
    if (this.isFocus != isFocus) {
      this.isFocus = isFocus;
      postInvalidate();
    }
//    iconView.setImageTintMode();
  }


}
