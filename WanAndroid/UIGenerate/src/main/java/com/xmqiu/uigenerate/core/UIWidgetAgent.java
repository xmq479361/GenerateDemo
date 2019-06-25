package com.xmqiu.uigenerate.core;

import com.xmqiu.uigenerate.core.ifs.IGenerate;
import com.xmqiu.uigenerate.core.ifs.IWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:59
 */
public class UIWidgetAgent {
  static List<IGenerate> mGenerates = new ArrayList<IGenerate>();

  public static IWidget process(Config config, IWidgetDesc widgetDesc){
    for (IGenerate generate : mGenerates) {
      IWidget widget = generate.generate(config, widgetDesc);
      if( null!= widget){
        return widget;
      }
    }
//    return new Container();
    return null;
  }

  public static void addGenerate(IGenerate generate) {
    mGenerates.add(generate);
  }
}
