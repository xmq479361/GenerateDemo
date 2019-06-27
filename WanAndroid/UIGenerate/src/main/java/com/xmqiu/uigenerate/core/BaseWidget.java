package com.xmqiu.uigenerate.core;

import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.entity.Align;
import com.xmqiu.uigenerate.entity.Margin;
import com.xmqiu.uigenerate.entity.Padding;
import com.xmqiu.uigenerate.entity.Color;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 20:57
 */
public abstract class BaseWidget implements IWidgetDesc {
    Style style;
    public String id;
    public Margin margin;
    public Padding padding;
    public Align align;
    public int width, height;
    public Color background;


    public BaseWidget(Style style) {
        this.style = style;
    }

    @Override
    public Style getStyle() {
        return style;
    }

    public abstract BaseWidget addChildren(IWidgetDesc child);

    @Override
    public void attachStyle(Style style) {
        if(style==null){
            return;
        }
        width = style.width;
        height = style.height;
    }
}
