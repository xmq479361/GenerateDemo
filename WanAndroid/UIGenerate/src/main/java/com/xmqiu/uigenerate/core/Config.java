package com.xmqiu.uigenerate.core;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:39
 */
public class Config {
  public int deep;

  public Config() {
    deep = 0;
  }

  public Config(int deep) {
    this.deep = deep;
  }

  public Config child() {
    return new Config(deep + 1);
  }
}
