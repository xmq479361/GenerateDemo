package com.xmqiu.wanandroid.model.net;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/27 10:38
 */
public class PageBean<T> {

  /**
   * curPage : 1
   * datas : [{"apkLink":"","author":"rubitree","chapterId":332,"chapterName":"嵌套滑动","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7907,"link":"http://blog.rubitree.com/15467469615604.html","niceDate":"1天前","origin":"","projectLink":"","publishTime":1548518136000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"【透镜系列】看穿 &gt; NestedScrolling 机制 &gt;","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"浪淘沙xud","chapterId":268,"chapterName":"优秀的设计","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7906,"link":"https://juejin.im/post/5c482f0ae51d4567680e429a","niceDate":"2天前","origin":"","projectLink":"","publishTime":1548488848000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"如何将你的服务优雅的暴露出去","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AICareless","chapterId":402,"chapterName":"跨平台应用","collect":false,"courseId":13,"desc":"极客日报的flutter版本","envelopePic":"http://www.wanandroid.com/blogimgs/0be29fb4-558a-4294-96d7-17398937569a.png","fresh":false,"id":7905,"link":"http://www.wanandroid.com/blog/show/2494","niceDate":"2天前","origin":"","projectLink":"https://github.com/AICareless/GitClub-Flutter","publishTime":1548488478000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=402"}],"title":"极客日报的flutter版本","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"星星y","chapterId":429,"chapterName":"ffmpeg","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7904,"link":"https://www.jianshu.com/p/9cda76b7f63b","niceDate":"2天前","origin":"","projectLink":"","publishTime":1548488151000,"superChapterId":95,"superChapterName":"多媒体技术","tags":[],"title":"FFmpeg音频播放器合集","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"请叫我大苏","chapterId":173,"chapterName":"Choreographer","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7839,"link":"https://www.cnblogs.com/dasusu/p/8311324.html","niceDate":"2天前","origin":"","projectLink":"","publishTime":1548480523000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"Android 屏幕刷新机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 升级之路","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7903,"link":"https://juejin.im/post/5c206b4ff265da61327f52f4","niceDate":"2019-01-25","origin":"","projectLink":"","publishTime":1548405592000,"superChapterId":375,"superChapterName":"跨平台","tags":[],"title":"Flutter 插件使用必知必会","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"DateBro","chapterId":375,"chapterName":"Flutter","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7902,"link":"https://juejin.im/post/5b5d782ae51d45191c7e7fb3","niceDate":"2019-01-25","origin":"","projectLink":"","publishTime":1548392667000,"superChapterId":375,"superChapterName":"跨平台","tags":[],"title":"[译]在 Flutter 中解析复杂的 JSON","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7900,"link":"https://mp.weixin.qq.com/s/adZC0N5Fd4X9FjxUrdlS1w","niceDate":"2019-01-24","origin":"","projectLink":"","publishTime":1548259200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"全面了解HTTP和HTTPS（开发人员必备）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7901,"link":"https://mp.weixin.qq.com/s/GQA0T4goTBWu83tyJuWdEw","niceDate":"2019-01-24","origin":"","projectLink":"","publishTime":1548259200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"玩转通讯录备份(JNI实战)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"YoKey","chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7898,"link":"https://www.jianshu.com/p/c12a98a36b2b","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548258546000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"9行代码让你App内的Fragment对重叠说再见","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lijiankun24","chapterId":173,"chapterName":"Choreographer","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7897,"link":"https://www.jianshu.com/p/9e244d13b866","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548258451000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"深入理解 WindowManagerService","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"milter","chapterId":78,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7896,"link":"https://www.jianshu.com/p/a769a6028e51","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548258148000,"superChapterId":197,"superChapterName":"热门专题","tags":[],"title":"破译Android性能优化中的16ms问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"请叫我大苏","chapterId":171,"chapterName":"binder","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7895,"link":"https://www.cnblogs.com/dasusu/category/1330070.html","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548257640000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"大苏的Android 源码分析合集","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"kingwang666","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"APP信息是一个免费的工具应用. 它有以下功能特点:\r\n\r\n查看已安装的app信息.\r\n查看未安装的apk信息.\r\n导出已安装的app应用的apk文件.\r\n复制apk的签名信息到剪切板.","envelopePic":"http://wanandroid.com/blogimgs/f16b7060-38e2-4ebd-87d9-d61b59a000e2.png","fresh":false,"id":7892,"link":"http://www.wanandroid.com/blog/show/2493","niceDate":"2019-01-23","origin":"","projectLink":"https://github.com/kingwang666/GetApk","publishTime":1548247914000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"一个可以显示app或者apk信息。并且可导出已安装的app的apk文件工具应用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"susion随心","chapterId":427,"chapterName":"susion随心","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7843,"link":"http://mp.weixin.qq.com/s?__biz=Mzg3NzA3MjE2Ng==&mid=2247483690&idx=1&sn=d5cf705ef75a944a9b76c87ab7588d13&chksm=cf29db63f85e5275db97f8772cd47d736dc6683833ed1415f50781777426858aa2cc93c34292&scene=38#wechat_redirect","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548172800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/427/1"}],"title":"Android的UI显示原理之Surface的渲染","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"程序亦非猿","chapterId":428,"chapterName":"程序亦非猿","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7846,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNDE1NjQ2Mw==&mid=2649872388&idx=1&sn=ff1d95f8c68aae248851336eee4a8161&chksm=8faeadc4b8d924d2f2bd8a9b422b5548068f61026604be4c6acbe30ddd5554845b38e4c3a1c2&scene=38#wechat_redirect","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548172800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/428/1"}],"title":"小谈 Kotlin 的空处理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7893,"link":"https://mp.weixin.qq.com/s/yzR2LAor7dUmZDctG2g7MQ","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548172800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"Android 官方架构组件（二）&mdash;&mdash;LiveData","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7894,"link":"https://mp.weixin.qq.com/s/CWE79gtHiufQnN_0XvaWAg","niceDate":"2019-01-23","origin":"","projectLink":"","publishTime":1548172800000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"使用Fragment优雅地申请运行时权限","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"DeltaTech","chapterId":173,"chapterName":"Choreographer","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7840,"link":"https://www.jianshu.com/p/996bca12eb1d","niceDate":"2019-01-22","origin":"","projectLink":"","publishTime":1548172585000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"Android Choreographer 源码分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" 来自怀旧的你","chapterId":171,"chapterName":"binder","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7838,"link":"https://juejin.im/post/5c444a67f265da612c5e29e1","niceDate":"2019-01-22","origin":"","projectLink":"","publishTime":1548172447000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"3分钟带你看懂android的Binder机制","type":0,"userId":-1,"visible":1,"zan":0}]
   * offset : 0
   * over : false
   * pageCount : 302
   * size : 20
   * total : 6027
   */

  private int curPage;
  private int offset;
  private boolean over;
  private int pageCount;
  private int size;
  private int total;
  private List<T> datas;

  public static PageBean objectFromData(String str) {

    return new Gson().fromJson(str, PageBean.class);
  }

  public static List<PageBean> arrayPageBeanFromData(String str) {

    Type listType = new TypeToken<ArrayList<PageBean>>() {
    }.getType();

    return new Gson().fromJson(str, listType);
  }

  public int getCurPage() {
    return curPage;
  }

  public void setCurPage(int curPage) {
    this.curPage = curPage;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public boolean isOver() {
    return over;
  }

  public void setOver(boolean over) {
    this.over = over;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<T> getDatas() {
    return datas;
  }

  public void setDatas(List<T> datas) {
    this.datas = datas;
  }

}
