package com.xmqiu.uigenerate.core.ifs;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 22:00
 */
public interface IRealGenerate {
  Class<? extends IWidgetDesc> processClz();

  IWidget process(IWidgetDesc aClass);
}
