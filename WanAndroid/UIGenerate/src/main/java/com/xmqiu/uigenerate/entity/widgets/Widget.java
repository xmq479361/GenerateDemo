package com.xmqiu.uigenerate.entity.widgets;

import com.xmqiu.uigenerate.entity.Align;
import com.xmqiu.uigenerate.entity.Color;
import com.xmqiu.uigenerate.entity.Margin;
import com.xmqiu.uigenerate.entity.Padding;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class Widget {
    public String id;
    public Margin margin;
    public Padding padding;
    public Align align;
    public int width, height;
    public Color background;

    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                ", margin=" + margin +
                ", padding=" + padding +
                ", align=" + align +
                ", width=" + width +
                ", height=" + height +
                ", background=" + background +
                '}';
    }
}
