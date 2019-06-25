package com.xmqiu.uigenerate.core.components;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.core.widgets.BaseGroupWidget;
import com.xmqiu.uigenerate.core.widgets.Container;

import java.util.Arrays;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:10
 */
public class AppBar extends BaseGroupWidget {

  public AppBar(Style style) {
    super(style);
  }


  public static final class AppBarBuilder {
    Container mLeftWidget;
    Container mCenterWidget;
    Container mRightWidget;

    private AppBarBuilder() {
    }

    public static AppBarBuilder anAppBar() {
      return new AppBarBuilder();
    }

    public AppBarBuilder withMLeftWidget(Container mLeftWidget) {
      this.mLeftWidget = mLeftWidget;
      return this;
    }

    public AppBarBuilder withMCenterWidget(Container mCenterWidget) {
      this.mCenterWidget = mCenterWidget;
      return this;
    }

    public AppBarBuilder withMRightWidget(Container mRightWidget) {
      this.mRightWidget = mRightWidget;
      return this;
    }

    public AppBar build() {
      AppBar appBar = new AppBar(null);
      appBar.addChildren(this.mLeftWidget,this.mCenterWidget, this.mRightWidget);
      return appBar;
    }
  }
}
