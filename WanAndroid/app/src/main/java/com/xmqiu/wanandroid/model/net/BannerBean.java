package com.xmqiu.wanandroid.model.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 13:03
 */
public class BannerBean {

  /**
   * desc : 一起来做个App吧
   * id : 10
   * imagePath : http://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png
   * isVisible : 1
   * order : 3
   * title : 一起来做个App吧
   * type : 0
   * url : http://www.wanandroid.com/blog/show/2
   */

  private String desc;
  private int id;
  private String imagePath;
  private int isVisible;
  private int order;
  private String title;
  private int type;
  private String url;

  public static BannerBean objectFromData(String str) {

    return new Gson().fromJson(str, BannerBean.class);
  }

  public static List<BannerBean> arrayBannerBeanFromData(String str) {

    Type listType = new TypeToken<ArrayList<BannerBean>>() {
    }.getType();

    return new Gson().fromJson(str, listType);
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public int getIsVisible() {
    return isVisible;
  }

  public void setIsVisible(int isVisible) {
    this.isVisible = isVisible;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
