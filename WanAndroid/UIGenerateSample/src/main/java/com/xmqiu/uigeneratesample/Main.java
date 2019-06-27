package com.xmqiu.uigeneratesample;

import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.UIWidgetAgent;
import com.xmqiu.uigenerate.core.components.AppBar;
import com.xmqiu.uigenerate.core.components.Locate;
import com.xmqiu.uigenerate.core.components.Page;
import com.xmqiu.uigenerate.core.ifs.IWidgetDesc;
import com.xmqiu.uigenerate.core.widgets.Container;
import com.xmqiu.uigenerate.core.widgets.EditText;
import com.xmqiu.uigenerate.core.widgets.EmptyWidget;
import com.xmqiu.uigenerate.core.widgets.Text;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigeneratesample.and.AndroidGenerate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IWidgetDesc widgetDesc = loadWidgetDesc();
        UIWidgetAgent.addGenerate(new AndroidGenerate());
        UIWidgetAgent.process(new Config("event_create"), widgetDesc);


//        String jsonContent = FileUtil.readFile("D:\\workspace\\generate\\GenerateDemo\\WanAndroid\\UIGenerateSample\\src\\layout.txt");
//        Logger.info(jsonContent);
//
//        String formatJsonStr = Utils.formatJsonStr(jsonContent);
//        Logger.info(formatJsonStr);

//        ViewEnty viewEnty = new Gson().fromJson(jsonContent, ViewEnty.class);
//
//        Map<String, Object> li = viewEnty.data;
//
//        for (String key : li.keySet()) {
//            Logger.e("item", key+" = "+li.get(key).toString());
//        }

//        XQViewGenerator.processJson(formatJsonStr);
    }


    private static IWidgetDesc loadWidgetDesc() {
        Page widgetDesc = Page.PageBuilder.aPage()
                .withAppBar(loadAppBar())
                .withBody(loadBody())
                .build();

        return widgetDesc;
    }

    private static Container loadBody() {
        return Container.linear(
                Locate.Linear.Oritential.Vertical,
                Arrays.asList(
                    commonEditText("请输入会议主题"),
                    commonEditText("请输入会议内容"),
                    commonSpaceView(12, 0),
                    commonEditText("请输入标签，空格结束"),
                        commonSpaceView(12, 0),
                    commonEditText("请输入地址")
                )
        );
    }

    private static IWidgetDesc commonSpaceView(int vertical, int horizontal) {
        return new EmptyWidget(Style.newBuilder()
                .setWidth(horizontal)
                .setHeight(vertical)
                .build());
    }

    private static IWidgetDesc commonEditText(String hint) {
        return new EditText("", null).hint(hint);
    }

    private static AppBar loadAppBar() {
        return AppBar.AppBarBuilder.anAppBar()
                .withMLeftWidget(
                        Container.linear(
                                Locate.Linear.Oritential.Horiontal,
                                Arrays.<IWidgetDesc>asList(new Text("<", null))
                        )
                )
                .withMCenterWidget(
                        new Text("发起会议", null)
                )
                .withMRightWidget(
                       new Text("确定", null)
                )
                .build();
    }
}
