package com.xmqiu.uigeneratesample.and;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmqiu.uigenerate.core.Config;
import com.xmqiu.uigenerate.core.Logger;
import com.xmqiu.uigenerate.core.components.Style;
import com.xmqiu.uigenerate.core.ifs.IRealGenerate;
import com.xmqiu.uigenerate.core.ifs.IWidget;
import com.xmqiu.uigenerate.core.widgets.Container;
import com.xmqiu.uigenerate.core.widgets.Text;
import com.xmqiu.uigeneratesample.JsonUtil;
import com.xmqiu.uigeneratesample.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ContainerGenerate implements IRealGenerate<Container> {

     @Override
     public Class<Container> processClz() {
       return Container.class;
     }

     @Override
     public IWidget process(Container widget, Config config, Style style, List<IWidget> childrens) {
       Logger.info("process Container::: ");
       Logger.info(JsonUtil.toJson(widget));
       HashMap<String, Object> dataMap = new Gson().fromJson(JsonUtil.toJson(widget),
               new TypeToken<HashMap<String, Object>>() {
               }.getType()
       );
       Map data = new HashMap<>();
       data.put("view", dataMap);
       Utils.generate(config.outputStream(), processClz().getSimpleName(), data);
       return null;
     }
   }