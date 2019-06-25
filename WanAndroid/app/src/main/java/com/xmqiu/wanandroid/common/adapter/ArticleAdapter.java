package com.xmqiu.wanandroid.common.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.model.net.ArticleBean;

import java.util.Collections;
import java.util.List;

public class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {
  public ArticleAdapter( List data) {
    super(R.layout.item_article, data);
  }

  public ArticleAdapter() {
    this(Collections.emptyList());
  }

  @Override
  protected void convert(BaseViewHolder helper, ArticleBean item) {
    helper
        .setText(R.id.id_article_tv_user, item.getAuthor())
        .setText(R.id.id_article_tv_title, item.getTitle())
        .setText(R.id.id_article_tv_date, item.getNiceDate());
  }
}