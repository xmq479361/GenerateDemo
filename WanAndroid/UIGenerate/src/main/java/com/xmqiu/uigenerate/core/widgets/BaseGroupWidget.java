package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:36
 */
public class BaseGroupWidget extends BaseWidget {
  public List<IWidgetDesc> children;
  public BaseGroupWidget(Style style) {
    super(style);
    children = new ArrayList<>();
  }

  @Override
  public BaseWidget addChildren(IWidgetDesc child) {
    children.add(child);
    return this;
  }

  public BaseWidget addChildren(IWidgetDesc... childs){
    children.addAll(Arrays.asList(childs));
    return this;
  }
  public BaseWidget addChildren(List<IWidgetDesc> childs){
    children.addAll(childs);
    return this;
  }
  @Override
  public boolean isContainer() {
    return true;
  }

  @Override
  public List<IWidgetDesc> getChildren() {
    return children;
  }
}
