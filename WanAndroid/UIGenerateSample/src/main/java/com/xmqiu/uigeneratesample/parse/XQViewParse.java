package com.xmqiu.uigeneratesample.parse;


import com.xmqiu.uigeneratesample.core.ParseHolder;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public interface XQViewParse<R extends ParseHolder, T> {

    R process(R holder, String type, T data);

    boolean isProcess(String type, T data);
}
