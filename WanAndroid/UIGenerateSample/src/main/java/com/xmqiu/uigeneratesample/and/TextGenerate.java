package com.xmqiu.uigeneratesample.and;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.Logger;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IRealGenerate;
import com.xmqiu.uigenerate.core.ifs.IWidget;
import com.xmqiu.uigenerate.core.widgets.Text;
import com.xmqiu.uigeneratesample.JsonUtil;
import com.xmqiu.uigeneratesample.Utils;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TextGenerate implements IRealGenerate<Text> {

     @Override
     public Class<Text> processClz() {
       return Text.class;
     }

     @Override
     public IWidget process(Text text, Config config, Style style, List<IWidget> childrens) {
       HashMap<String, Object> dataMap = new Gson().fromJson(JsonUtil.toJson(text),
               new TypeToken<HashMap<String, Object>>() {
               }.getType()
       );
       Map data = new HashMap<>();
       data.put("view", dataMap);
       Utils.generate(config.outputStream(), processClz().getSimpleName(), data);
       return null;
     }
   }