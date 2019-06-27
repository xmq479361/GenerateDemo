package com.xmqiu.uigenerate.core.ifs;

import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.mapper.WidgetConfig;

import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 22:00
 */
public interface IRealGenerate<T extends IWidgetDesc> {
  Class<T> processClz();

  IWidget process(T widgetDesc, Config config, Style style, List<IWidget> children);
}
