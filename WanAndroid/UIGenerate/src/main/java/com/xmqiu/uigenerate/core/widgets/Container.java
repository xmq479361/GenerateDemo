package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.BaseWidget;
import com.xmqiu.uigenerate.core.components.Locate;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:02
 */
public class Container extends BaseGroupWidget {

  public Locate mLocate;

  public Container(Locate locate, List<IWidgetDesc> children) {
    this(null, locate, children);
  }
  public Container(Style style, Locate locate, List<IWidgetDesc> children) {
    super(style);
    mLocate = locate;
    this.children =children;
    if(this.children==null){
      this.children = Collections.emptyList();
    }
  }

  public static Container linear(List<IWidgetDesc> children) {
    return new Container(new Locate.Linear(Locate.Linear.Oritential.Horiontal),children);
  }
  public static Container linear(Locate.Linear.Oritential oritential, List<IWidgetDesc> children) {
    return new Container(new Locate.Linear(oritential), children);
  }

  //  public static Container relative(Locate.Linear.Oritential oritential) {
//    return new Container(new Locate.Linear(oritential));
//  }
}
