package com.xmqiu.uigeneratesample;

import com.xmqiu.uigenerate.core.BaseGenerate;
import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.Logger;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IRealGenerate;
import com.xmqiu.uigenerate.core.ifs.IWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:05
 */
public class AndroidGenerate extends BaseGenerate {
  @Override
  public IWidget generate(Config config, IWidgetDesc widgetDesc) {
    if (widgetDesc == null) {
      return null;
    }
    Logger.info(font(config) + "" + widgetDesc);
//    IWidget widget = generate(config, widgetDesc);
    Style style = widgetDesc.getStyle();
    List<IWidget> childrenWidgets = new ArrayList<>();
    if (widgetDesc.isContainer()) {
      List<IWidgetDesc> children = widgetDesc.getChildren();
      Config childConfig = config.child();
      for (IWidgetDesc child : children) {
        IWidget subWidget = generate(childConfig, child);
        if (subWidget == null) {
          continue;
        }
        childrenWidgets.add(subWidget);
      }
    }
    IWidget widget =  coreProcess(widgetDesc, style, childrenWidgets);
//    widget.appendChilren(childrenWidgets)
    return widget;
  }

  IWidget coreProcess(IWidgetDesc widgetDesc, Style style, List<IWidget> children) {
    Class<? extends IWidgetDesc> widgetDescClass = widgetDesc.getClass();
    IRealGenerate iRealGenerate = mGenerates.get(widgetDescClass);
    IWidget widget = iRealGenerate.process(widgetDesc);
    if (widget != null) {
      return widget;
    }
    for (IRealGenerate mGenerate : mGenerates.values()) {
      if (!widgetDescClass.isAssignableFrom(mGenerate.processClz())) {
        continue;
      }
      widget = mGenerate.process(widgetDesc);
      if (widget != null) {
        return widget;
      }
    }
    return widget;
  }

  private String font(Config config) {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < config.deep; i++) {
      buffer.append("\t");
    }
    return buffer.toString();
  }

}
