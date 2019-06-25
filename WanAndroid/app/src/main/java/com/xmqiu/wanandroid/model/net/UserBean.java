package com.xmqiu.wanandroid.model.net;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/25 8:16
 */
public class UserBean implements Parcelable {

  /**
   * chapterTops : []
   * collectIds : []
   * email :
   * icon :
   * id : 16701
   * password :
   * token :
   * type : 0
   * username : xmqyeah
   */

  private String email;
  private String icon;
  private int id;
  private String password;
  private String token;
  private int type;
  private String username;
  private List<String> chapterTops;
  private List<String> collectIds;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<?> getChapterTops() {
    return chapterTops;
  }

  public void setChapterTops(List<String> chapterTops) {
    this.chapterTops = chapterTops;
  }

  public List<?> getCollectIds() {
    return collectIds;
  }

  public void setCollectIds(List<String> collectIds) {
    this.collectIds = collectIds;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.email);
    dest.writeString(this.icon);
    dest.writeInt(this.id);
    dest.writeString(this.password);
    dest.writeString(this.token);
    dest.writeInt(this.type);
    dest.writeString(this.username);
    dest.writeStringList(this.chapterTops);
    dest.writeStringList(this.collectIds);
  }

  public UserBean() {
  }

  protected UserBean(Parcel in) {
    this.email = in.readString();
    this.icon = in.readString();
    this.id = in.readInt();
    this.password = in.readString();
    this.token = in.readString();
    this.type = in.readInt();
    this.username = in.readString();
    this.chapterTops = in.createStringArrayList();
    this.collectIds = in.createStringArrayList();
  }

  public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
    @Override
    public UserBean createFromParcel(Parcel source) {
      return new UserBean(source);
    }

    @Override
    public UserBean[] newArray(int size) {
      return new UserBean[size];
    }
  };
}
