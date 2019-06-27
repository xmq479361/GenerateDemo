package com.xmqiu.uigenerate.core.widgets;

import com.xmqiu.uigenerate.core.components.Locate;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.entity.Align;

import java.util.List;


/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:02
 */
public class Container extends BaseGroupWidget {

  public Locate mLocate;
  public Align align;

  public Container(Locate locate, List<IWidgetDesc> children) {
    this(null, locate, children);
  }
  public Container(Style style, Locate locate, List<IWidgetDesc> children) {
    super(style);
    mLocate = locate;
    if(children!=null){
      this.children.addAll(children);
    }
  }

  public static Container linear(List<IWidgetDesc> children) {
    return new Container(new Locate.Linear(Locate.Linear.Oritential.Horiontal),children);
  }
  public static Container linear(Locate.Linear.Oritential oritential, List<IWidgetDesc> children) {
    return new Container(new Locate.Linear(oritential), children);
  }

    public static Container relative(Locate.Relative.Oritential oritential) {
    return new Container(new Locate.Linear(oritential));
  }

  @Override
  public String toString() {
    return "Container{" +
            "mLocate=" + mLocate +
            '}';
  }
}
