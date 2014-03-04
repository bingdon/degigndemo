package com.bing.design9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bing.design9.adapter.BingPagerAdapter;
import com.bing.design9.utils.BingTools;
import com.bing.design9.view.ZoomImageView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class TeamProPic extends Activity implements OnPageChangeListener {

	private ViewPager mPager;
	private List<View> picList=new ArrayList<View>();
	private View view0,view1,view2,view3;
	
	private ImageView closeView;
	//指引
	private TextView guidTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_team_pro_pic);
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_pro_pic, menu);
		return true;
	}

	private void initView(){
		mPager=(ViewPager)findViewById(R.id.picpagerpic);
		Bitmap bitmap=BingTools.readBitMap(this, R.drawable.image_3);
		LayoutInflater layoutInflater=getLayoutInflater();
		
		view0=layoutInflater.inflate(R.layout.bingpic, null, false);
		view1=layoutInflater.inflate(R.layout.bingpic, null, false);
		view2=layoutInflater.inflate(R.layout.bingpic, null, false);
		view3=layoutInflater.inflate(R.layout.bingpic, null, false);
		
		ZoomImageView zoomImageView0=(ZoomImageView)view0.findViewById(R.id.zoomImageView1);
		zoomImageView0.setImageBitmap(bitmap);
		
		
		ZoomImageView zoomImageView1=(ZoomImageView)view1.findViewById(R.id.zoomImageView1);
		zoomImageView1.setImageBitmap(bitmap);
		
		
		ZoomImageView zoomImageView2=(ZoomImageView)view2.findViewById(R.id.zoomImageView1);
		zoomImageView2.setImageBitmap(bitmap);
		
		
		ZoomImageView zoomImageView3=(ZoomImageView)view3.findViewById(R.id.zoomImageView1);
		zoomImageView3.setImageBitmap(bitmap);
		
		
		picList.add(view0);
		picList.add(view1);
		picList.add(view2);
		picList.add(view3);
		
		
		mPager.setAdapter(new BingPagerAdapter(picList));
		mPager.setCurrentItem(0);
		
		mPager.setOnPageChangeListener(this);
		
		closeView=(ImageView)findViewById(R.id.close);
		closeView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Runtime runtime = Runtime.getRuntime();  
				try {
					runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
		});
		
		guidTextView=(TextView)findViewById(R.id.guidtxt);
		
		guidTextView.setText("1/4");
		
		
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
		guidTextView.setText((arg0+1)+"/4");
	}
	
}
