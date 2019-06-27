package com.xmqiu.uigeneratesample.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xmqiu.uigenerate.core.Logger;
import com.xmqiu.uigeneratesample.Utils;
import com.xmqiu.uigeneratesample.parse.XQViewParse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public class XQViewCoreAdapter {
    List<XQViewParse> mViewParse = new ArrayList<>();

    public XQViewCoreAdapter addViewParse(XQViewParse viewParse) {
        this.mViewParse.add(viewParse);
        return this;
    }

    public void processJsonData(String jsonStr) {
        JsonParser parser = new JsonParser();
        JsonElement jsonEl = parser.parse(jsonStr);
        File outputFile = new File(Utils.PATH_PROJECT+"/outputs", "Data.xml");
        OutputStream outputStream= null;
        Writer out = null;
        try {
            outputStream = new FileOutputStream(outputFile , true);
            _processAndGetWidgetWithChildren(new ParseHolder(outputStream), jsonEl.getAsJsonObject());
            out = new OutputStreamWriter(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    private ParseHolder _processAndGetWidgetWithChildren(ParseHolder holder, JsonObject jsonObject) {
        String type = jsonObject.get("type").getAsString();
        Logger.info("\tprocess: " + type + " ,search adapter..."+ jsonObject);
        for (XQViewParse xqViewParse : mViewParse) {
//            Logger.info("process: " + type + " ,adapter: "+ xqViewParse.getClass().getSimpleName());
            if (xqViewParse.isProcess(type, jsonObject)) {
//                Logger.info("process: " + type + " , adapter found ..." + xqViewParse.getClass().getSimpleName());
                ParseHolder parseHolder = xqViewParse.process(holder, type, jsonObject);
                if (parseHolder == null) {
                    return null;
                }
                for (JsonObject object : parseHolder.childrenObj) {
                    _processAndGetWidgetWithChildren(holder, object);
                }
                return null;
            }
        }
        Logger.e("==============" , "process: "+type + " , adapter not found ..." );
        return null;
    }
}
