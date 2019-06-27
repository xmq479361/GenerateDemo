package com.xmqiu.uigeneratesample.android;

import com.xmqiu.uigeneratesample.core.ParseHolder;
import com.xmqiu.uigenerate.entity.Align;
import com.xmqiu.uigenerate.entity.widgets.Widget;

import java.util.List;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class WidgetLayout {
    public class Depend{
        Align align;
        Widget widget;
    }
    public ParseHolder layout(ParseHolder holder, Widget widget, Widget parent, List<Depend> depends){
        if(depends!=null && !depends.isEmpty()){

        }
        if(widget.align!=null){
//            Align.AlignTo left = widget.align.left;
//            left.key
        }
        return null;
    }
}
