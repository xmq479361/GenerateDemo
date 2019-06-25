package com.xmqiu.wanandroid.pages.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xmqiu.wanandroid.R;
import com.xmqiu.wanandroid.base.AppActivity;
import com.xmqiu.wanandroid.pages.main.home.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author xmqiu -- Administrator
 * createDate 2019/1/26 3:02
 */
public class MainActivity extends AppActivity {
  @BindView(R.id.toolbar)
  Toolbar mToolbar;
  //  @BindView(R.id.id_fg_main_container)
//  FrameLayout mFrgContainer;
  @BindView(R.id.id_fg_main_container)
  ViewPager mViewPager;
  @BindView(R.id.tabs)
  TabLayout mTabLayout;
  private ArrayList<Fragment> fragments = new ArrayList<>();
  private ArrayList<String> tabs = new ArrayList<>();
  final String TabStrs[] = {"主页", "体系", "项目", "用户"};

  public static void launch(Activity appActivity) {
    appActivity.startActivity(new Intent(appActivity, MainActivity.class));
  }

  @Override
  public int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  public void initView(Bundle savedInstanceState, View contentView) {
    super.initView(savedInstanceState, contentView);
    initTabs();
    initToolbar();
  }

  private void initToolbar() {
    if (mToolbar != null) {
      mToolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white));
      mToolbar.setTitle(TabStrs[0]);
      setSupportActionBar(mToolbar);
    }
//    ActionBar actionBar = getSupportActionBar();
//    if (actionBar != null) {
//      // 显示返回上一级(即 < icon)
//      actionBar.setDisplayHomeAsUpEnabled(true);
//    }
//
//    final Drawable upArrow = getResources().getDrawable(R.drawable.ic_fab_website);
//
//    if (upArrow != null) {
//      // 如果layout方向是从右到左，自动翻转
//      upArrow.setAutoMirrored(true);
//      // 设置 < icon颜色
//      upArrow.setColorFilter(getResources().
//          getColor(R.color.colorAccent),PorterDuff.Mode.SRC_ATOP);
//    }
//    if (actionBar != null) {
//      // 设置返回上一级的图标
//      actionBar.setHomeAsUpIndicator(upArrow);
//      actionBar.setHomeActionContentDescription("mToolbar");
//    }
  }

  /**
   * 初始化Tab
   */
  private void initTabs() {
    TabLayout.Tab component = mTabLayout.newTab();
    component.setText("主页");
    component.setIcon(R.drawable.icon_home);
    mTabLayout.addTab(component);

    TabLayout.Tab util = mTabLayout.newTab();
    util.setText("体系");
    util.setIcon(R.drawable.ic_knowledge_tree);
    mTabLayout.addTab(util);

    TabLayout.Tab expand = mTabLayout.newTab();
    expand.setText("项目");
    expand.setIcon(R.drawable.ic_project);
    mTabLayout.addTab(expand);

    TabLayout.Tab user = mTabLayout.newTab();
    user.setText("用户");
    user.setIcon(R.drawable.ic_user);
    mTabLayout.addTab(user);
    fragments.add(new HomeFragment());
    fragments.add(new TabFragment(this, TabStrs[1]));
    fragments.add(new TabFragment(this, TabStrs[2]));
    fragments.add(new TabFragment(this, TabStrs[3]));
    //设置TabLayout的模式
    mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    mViewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
    //关联ViewPager和TabLayout
    mTabLayout.setupWithViewPager(mViewPager);
    mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        mToolbar.setTitle(TabStrs[tab.getPosition()]);
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {
      }
    });
  }

  class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return fragments.get(position);
    }

    @Override
    public int getCount() {
      return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return TabStrs[position];
    }
  }
}
