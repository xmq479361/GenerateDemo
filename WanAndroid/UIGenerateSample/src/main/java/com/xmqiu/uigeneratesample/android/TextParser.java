package com.xmqiu.uigeneratesample.android;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.xmqiu.uigenerate.core.Logger;
import com.xmqiu.uigeneratesample.JsonUtil;
import com.xmqiu.uigeneratesample.Utils;
import com.xmqiu.uigeneratesample.core.ParseHolder;
import com.xmqiu.uigenerate.entity.widgets.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {
 * "type":"Text",
 * "value": "Hello World!",
 * "width": "100",
 * "height":"100",
 * "gravity":"right",
 * "textSize":"12",
 * "textColor":"grey",
 * "align": {
 * left:[
 * "toRightOf": "parent",
 * "toLeftOf": "parent",
 * "toLeftOf": "parent",
 * ]
 * right:
 * top:
 * bottom:
 * }
 * }
 *
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class TextParser extends XQViewAndroidParse {

    @Override
    String parseType() {
        return "Text";
    }


    @Override
    public ParseHolder process(ParseHolder parseHolder, String type, JsonObject jsonObj) {
        Text text = JsonUtil.fromJson(jsonObj, Text.class);
        Logger.info("process Text::: ");
        Logger.info(JsonUtil.toJson(text));
        Logger.info(text.toString());

        HashMap<String, Object> dataMap = new Gson().fromJson(JsonUtil.toJson(text),
                new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        Map data = new HashMap<>();
//        data.put("children", Arrays.asList(dataMap));
//        data.put("children", Arrays.asList(dataMap));
        List children  = new ArrayList<>();
        children.add(dataMap);
        data.put("children", children);
        Logger.info("text: id: %s, text: %s",text.id, text.text);
        Utils.generate(parseHolder.outputStream, parseType(), data);
        return ParseHolder.from(parseHolder, null);
    }


}
