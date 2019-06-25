package com.xmqiu.uigenerate.core;

import com.xmqiu.uigenerate.core.components.AppBar;
import com.xmqiu.uigenerate.core.components.Page;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:57
 */
public abstract class BaseWidget implements IWidgetDesc {
  Style style;

  public BaseWidget(Style style) {
    this.style = style;
  }

  @Override
  public Style getStyle() {
    return style;
  }

  public abstract BaseWidget addChildren(IWidgetDesc child);
}
