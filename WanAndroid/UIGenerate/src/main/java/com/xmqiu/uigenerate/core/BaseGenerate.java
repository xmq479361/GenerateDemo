package com.xmqiu.uigenerate.core;

import com.xmqiu.uigenerate.core.ifs.IGenerate;
import com.xmqiu.uigenerate.core.ifs.IRealGenerate;
import com.xmqiu.uigenerate.core.ifs.IWidget;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:55
 */
public abstract class BaseGenerate implements IGenerate {
  public HashMap<Class, IRealGenerate> mGenerates = new HashMap<>();


  public void addGenerate(IRealGenerate realGenerate){
    mGenerates.put(realGenerate.processClz(), realGenerate);
  }
}
