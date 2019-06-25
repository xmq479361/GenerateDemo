package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.Collections;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:36
 */
public class BaseSingleWidget extends BaseWidget {
  public BaseSingleWidget(Style style) {
    super(style);
  }

  @Override
  public BaseWidget addChildren(IWidgetDesc child) {
    return this;
  }

  @Override
  public boolean isContainer() {
    return false;
  }

  @Override
  public List<IWidgetDesc> getChildren() {
    return Collections.emptyList();
  }
}
