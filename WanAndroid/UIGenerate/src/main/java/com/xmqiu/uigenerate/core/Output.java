package com.xmqiu.uigenerate.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class Output{
    public static Output output;
    static{

        output = new Output();
    }
    HashMap<String, OutputStream> outputStreamHashMap = new HashMap<>();
    final static String basePath ="D:\\workspace\\generate\\GenerateDemo\\WanAndroid\\UIGenerateSample\\outputs";
    public OutputStream get(String key) {
        OutputStream outputStream =null;
        if(outputStreamHashMap.containsKey(key)){
            outputStream   = outputStreamHashMap.get(key);
        }
        if(outputStream==null){
            try {
                outputStream = new FileOutputStream(new File(basePath, key+".txt"));
                outputStreamHashMap.put(key, outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return outputStream;
    }
}