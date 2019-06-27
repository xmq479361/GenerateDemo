package com.xmqiu.uigeneratesample.parse;

/**
 * @author xu.mengqiu
 * @date 2019/6/27
 * @Description:
 */
public interface ViewParser<S ,T> {
    T parse(S source);
}
