package com.xmqiu.uigenerate.core.components;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/6/25 21:09
 */
public class Locate {


  public static class Linear extends Locate{
    public  enum Oritential{
      Horiontal, Vertical
    }
    Oritential mOritential;

    @Override
    public String toString() {
      return "Linear{" +
              "mOritential=" + mOritential +
              '}';
    }

    public Linear(Oritential oritential) {
      mOritential = oritential;
    }

  }
  public static class Relative extends Locate{
    public  enum Oritential{
      Horiontal, Vertical
    }
  }
}
