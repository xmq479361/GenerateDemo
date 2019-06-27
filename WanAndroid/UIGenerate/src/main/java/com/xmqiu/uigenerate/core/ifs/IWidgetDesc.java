package com.xmqiu.uigenerate.core.ifs;

import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.mapper.WidgetConfig;

import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:56
 */
public interface IWidgetDesc {
  boolean isContainer();

  List<IWidgetDesc> getChildren();

  Style getStyle();

    void attachStyle(Style style);
}
