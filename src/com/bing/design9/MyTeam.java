package com.bing.design9;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTeam extends Activity {

	private ViewPager teamPager;
	private List<View> teamViews=new ArrayList<View>();
	private View team0v, team1v, team2v,team3v;
	private LinearLayout mLayout;
	private Button mButton,mPreSelectedBt;
	private ImageView imageView;
	private ImageView[] imageViews;
	
	private ViewGroup group;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_team);
		initView();
		
		team0v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MyTeam.this, TeamInfo.class);
				startActivity(intent);
			}
		});
		
	}

	public void initView(){
		teamPager=(ViewPager)findViewById(R.id.teampager);
		LayoutInflater inflater = getLayoutInflater();
		team0v=inflater.inflate(R.layout.team1, null);
		team1v=inflater.inflate(R.layout.team1, null);
		team2v=inflater.inflate(R.layout.team0, null);
		team3v=inflater.inflate(R.layout.team1, null);
		
		ImageView imageView7=(ImageView)team0v.findViewById(R.id.team_pic);
		imageView7.setImageResource(R.drawable.middle_pic);
		
		ImageView p0=(ImageView)team0v.findViewById(R.id.po);
		ImageView p1=(ImageView)team0v.findViewById(R.id.pl);
		
		p1.setVisibility(View.INVISIBLE);
		
		TextView title=(TextView)team0v.findViewById(R.id.peoname);
		title.setText("脉合时代");
		TextView indr=(TextView)team0v.findViewById(R.id.eyedsg);
		indr.setText("脉合时代采用“创意交叉”模式");
		TextView indr0=(TextView)team0v.findViewById(R.id.indr0);
		TextView indr1=(TextView)team0v.findViewById(R.id.indr1);
		
		indr0.setText("通过提供品牌策划、品牌立体化、品牌数字化、品牌艺术化等服务打造客户的品牌及传播价值，我们有不同专业的合伙人...");
		indr1.setVisibility(View.INVISIBLE);
		
		teamViews.add(team0v);
		teamViews.add(team1v);
		teamViews.add(team2v);
		teamViews.add(team3v);
		
		teamPager.setAdapter(new MyViewPagerAdapter(teamViews));
		teamPager.setCurrentItem(0);
		teamPager.setOnPageChangeListener(new MyOnPageChangeListener());
		/*****新加兄1�7********/
//		mLayout=(LinearLayout)findViewById(R.id.foucsre);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.page_indicator_unfocused);  
//        for (int i = 0; i < teamViews.size(); i++) {  
//            Button bt = new Button(this);  
//            bt.setLayoutParams(new ViewGroup.LayoutParams(bitmap.getWidth(),bitmap.getHeight()));  
//            bt.setBackgroundResource(R.drawable.page_indicator_unfocused);  
//            mLayout.addView(bt);  
//        }  
		
//		pointslid();
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
	
	class MyOnPageChangeListener implements OnPageChangeListener{

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
//			page_id=arg0;
			
//			
//			if(mPreSelectedBt != null){  
//                mPreSelectedBt.setBackgroundResource(R.drawable.light1_001);  
//            }  
//              
//            Button currentBt = (Button)mLayout.getChildAt(arg0);  
//            currentBt.setBackgroundResource(R.drawable.page_indicator_focused);  
//            mPreSelectedBt = currentBt;  
			/*******小点显示*******/
//			for (int i = 0; i < imageViews.length; i++) {
//				imageViews[arg0]
//						.setBackgroundResource(R.drawable.page_indicator_focused);
//
//				if (arg0 != i) {
//					imageViews[i]
//							.setBackgroundResource(R.drawable.page_indicator_unfocused);
//				}
//			}
			
			
		}
		
	}
	
/*******小点显示*******/
//	public void pointslid(){
//		
//		group=(ViewGroup)findViewById(R.id.foucsre);
//		
//		/**
//		 * �м���ͼƬ �������ʾ����СԲ��
//		 */
//		imageViews=new ImageView[teamViews.size()];
//		for (int i = 0; i < teamViews.size(); i++) {
//			LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.WRAP_CONTENT,
//					LinearLayout.LayoutParams.WRAP_CONTENT);
//			//����ÿ��СԲ�������ߵļ��
//			margin.setMargins(10, 0, 0, 0);
//			imageView = new ImageView(MyTeam.this);
//			//����ÿ��СԲ��Ŀ��
//			imageView.setLayoutParams(new LayoutParams(15, 15));
//			imageViews[i] = imageView;
//			if (i == 0) {
//				// Ĭ��ѡ�е�һ��ͼƬ
//				imageViews[i]
//						.setBackgroundResource(R.drawable.page_indicator_focused);
//			} else {
//				//����ͼƬ������δѡ��״̬
//				imageViews[i]
//						.setBackgroundResource(R.drawable.page_indicator_unfocused);
//			}
//			group.addView(imageViews[i], margin);
//		}
//	}
	
	
}
