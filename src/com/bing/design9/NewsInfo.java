package com.bing.design9;

import java.util.ArrayList;
import java.util.List;

import com.bing.design9.adapter.MyAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsInfo extends Activity implements OnPageChangeListener, OnClickListener {

	private ViewPager infoimaPager;
	private List<View> infoList=new ArrayList<View>();
	private View infov0,infov1,infov2;
	private ImageView left,right;
	
	private int sizev=0;
	
	private TextView newsinfomani;
	
	private String mString="你可还记得小时候，在虫鸣鸟叫的傍晚，你和小伙伴卷起裤腿，踏进那树林深处，一起寻觅那飞舞的萤火虫。孩子们都喜欢把萤火虫收集到一个袋子里，看着袋子透出温暖的淡淡的光辉，心中便充满了无限的喜悦。" +
			"\n"+"\n"+
			"当然，我们还是要爱护小动物们才对，所以今天给大家带来一款美丽的台灯，让你不用去捉萤火虫，也能拥有一袋子的温暖光芒。" +
			"\n"+"\n"+
			"这款充满创意的束袋灯是来自法国的设计师Simon Naouri的作品，带着一贯的法式浪漫气息。不点亮的时候看起来就是一个白色的袋子，而一旦点亮台灯，温暖的黄色光芒就从袋子中透出来，非常温馨。而束在袋口的绳子，就充当了电源线的角色，非常巧妙。" +
			"\n"+"\n"+
			"法国人的作品总是带有浪漫的气息。看到这款灯你联想到神马？虫鸣鸟叫的傍晚，听溪水潺潺，你和小伙伴卷起裤腿，踏进那树林深处...";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_news_info);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_info, menu);
		return true;
	}

	private void initView(){
		
		left=(ImageView)findViewById(R.id.newsinfo_left);
		right=(ImageView)findViewById(R.id.newsinfo_right);
		left.setOnClickListener(this);
		right.setOnClickListener(this);
		
		
		infoimaPager=(ViewPager)findViewById(R.id.newspager);
		LayoutInflater inflater=getLayoutInflater();
		infov0=inflater.inflate(R.layout.news_info_pager_xl, null);
		infov1=inflater.inflate(R.layout.news_info_pager_xl, null);
		infov2=inflater.inflate(R.layout.news_info_pager_xl, null);
		
		infoList.add(infov0);
		infoList.add(infov1);
		infoList.add(infov2);
		
		infoimaPager.setAdapter(new MyViewPagerAdapter(infoList));
		
		infoimaPager.setCurrentItem(0);
		
		infoimaPager.setOnPageChangeListener(this);
		
		
		sizev=infoList.size()-1;
		
		
		newsinfomani=(TextView)findViewById(R.id.newsinfo_main_txt);
		newsinfomani.setText(mString);
		
	}
	
	class MyViewPagerAdapter extends PagerAdapter{
		private List<View> listViews;
		MyViewPagerAdapter(List<View> listViews){
			this.listViews = listViews ;
		}
		
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(listViews.get(position));
		}


		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(listViews.get(position),0);
			return listViews.get(position);
		}


		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
		if (arg0==0) {
			left.setVisibility(View.INVISIBLE);
		}else {
			left.setVisibility(View.VISIBLE);
		}
		
		if (arg0==sizev) {
			right.setVisibility(View.INVISIBLE);
		}else {
			right.setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int posion=infoimaPager.getCurrentItem();
		
		switch (arg0.getId()) {
		case R.id.newsinfo_left:
			Log.i("点击", "向左:"+posion);
				infoimaPager.setCurrentItem(posion-1);
			
			break;
			
		case R.id.newsinfo_right:
			
			if (!(posion==infoList.size()-1)) {
				infoimaPager.setCurrentItem(posion+1);
			}
			
			break;

		default:
			break;
		}
	}
}
