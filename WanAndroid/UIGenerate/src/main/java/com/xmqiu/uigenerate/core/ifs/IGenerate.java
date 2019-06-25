package com.xmqiu.uigenerate.core.ifs;

import com.xmqiu.uigenerate.core.Config;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:54
 */
public interface IGenerate {

  IWidget generate(Config config,  IWidgetDesc widgetDesc);
}
