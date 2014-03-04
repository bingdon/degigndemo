package com.bing.design9;

import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.slidingmenu.lib.SlidingMenu.OnOpenListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnClickListener {

	private LinearLayout actLayout;
	public static RelativeLayout tabLayout;
	private ImageView groupView,newsView,chatView;
	private int showflag=0;
	
	public static SlidingMenu leftMenu;
	
	private ImageView eyeImageView,roomImageView,
			zlImageView,fasionImageView;
	
	private TextView eyeTextView,roomTextView,
			zlTextView,fasionTextView,allTextView,login;
	
	private int seccolor=0,norcolor=0;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initview();
		showciew(showflag);
		groupView.setOnClickListener(this);
		newsView.setOnClickListener(this);
		chatView.setOnClickListener(this);
		
		initleftmenu();
		allTextView=(TextView)findViewById(R.id.allleftmain);
		
		eyeTextView=(TextView)findViewById(R.id.eyedsgleftmaintxt);
		roomTextView=(TextView)findViewById(R.id.roomdsgleftmaintxt);
		zlTextView=(TextView)findViewById(R.id.zldsgleftmaintxt);
		fasionTextView=(TextView)findViewById(R.id.fasiondsgleftmaintxt);
		login=(TextView)findViewById(R.id.loginleftmain);
		
		eyeImageView=(ImageView)findViewById(R.id.eyedsgleftmainimg);
		roomImageView=(ImageView)findViewById(R.id.roomdsgleftmainimg);
		zlImageView=(ImageView)findViewById(R.id.zldsgleftmainimg);
		fasionImageView=(ImageView)findViewById(R.id.fasiondsgleftmainimg);
		
		
		allTextView.setOnClickListener(this);
		eyeImageView.setOnClickListener(this);
		roomImageView.setOnClickListener(this);
		zlImageView.setOnClickListener(this);
		fasionImageView.setOnClickListener(this);
		login.setOnClickListener(this);
		
		norcolor=getResources().getColor(R.color.noselect);
		seccolor=getResources().getColor(R.color.select);
	}

	public void initview(){
		actLayout=(LinearLayout)findViewById(R.id.line0);
		groupView=(ImageView)findViewById(R.id.myteam);
		newsView=(ImageView)findViewById(R.id.newsview);
		chatView=(ImageView)findViewById(R.id.chatview);
		
		tabLayout=(RelativeLayout)findViewById(R.id.re0);
	}

	
	public void showciew(int flag){
		switch (flag) {
		case 0:
			actLayout.removeAllViews();
			View v0 = getLocalActivityManager().startActivity("one",  
                    new Intent(MainActivity.this, GroupView.class)).getDecorView(); 
			actLayout.addView(v0);
			break;
			
		case 1:
			actLayout.removeAllViews();
			View v1 = getLocalActivityManager().startActivity("tow",  
                    new Intent(MainActivity.this, NewsView.class)).getDecorView(); 
			actLayout.addView(v1);
			break;
			
		case 2:
			actLayout.removeAllViews();
			View v2 = getLocalActivityManager().startActivity("therre",  
                    new Intent(MainActivity.this, ChatActivity.class)).getDecorView(); 
			actLayout.addView(v2);
			break;

		default:
			break;
		}
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int what=v.getId();
		switch (what) {
		case R.id.myteam:
			showflag=0;
			
			groupView.setImageResource(R.drawable.tab_bar_tuandui_select);
			newsView.setImageResource(R.drawable.tab_bar_new);
			chatView.setImageResource(R.drawable.tab_bar_talk);
			
			showciew(showflag);
			
			break;
			
		case R.id.newsview:
			showflag=1;
			
			groupView.setImageResource(R.drawable.tab_bar_tuandui);
			newsView.setImageResource(R.drawable.tab_bar_new_select);
			chatView.setImageResource(R.drawable.tab_bar_talk);
			
			showciew(showflag);
			
			break;
		
			
		case R.id.chatview:
			showflag=2;
			
			showciew(showflag);
			
			groupView.setImageResource(R.drawable.tab_bar_tuandui);
			newsView.setImageResource(R.drawable.tab_bar_new);
			chatView.setImageResource(R.drawable.tab_bar_talk_select);
			
			tabLayout.setVisibility(View.GONE);
			
//			enterLogin();
			
			break;
			
		case R.id.allleftmain:
			eyeTextView.setTextColor(norcolor);
			roomTextView.setTextColor(norcolor);
			zlTextView.setTextColor(norcolor);
			fasionTextView.setTextColor(norcolor);
			allTextView.setTextColor(seccolor);
			
			leftMenu.showContent();
			
		
		
			break;
			
			
		case R.id.eyedsgleftmainimg:
			eyeTextView.setTextColor(seccolor);
			roomTextView.setTextColor(norcolor);
			zlTextView.setTextColor(norcolor);
			fasionTextView.setTextColor(norcolor);
			allTextView.setTextColor(norcolor);
			
			leftMenu.showContent();
			
			break;
			
		case R.id.roomdsgleftmainimg:
			eyeTextView.setTextColor(norcolor);
			roomTextView.setTextColor(seccolor);
			zlTextView.setTextColor(norcolor);
			fasionTextView.setTextColor(norcolor);
			allTextView.setTextColor(norcolor);
			
			leftMenu.showContent();
			
			break;
			
		case R.id.zldsgleftmainimg:
			eyeTextView.setTextColor(norcolor);
			roomTextView.setTextColor(norcolor);
			zlTextView.setTextColor(seccolor);
			fasionTextView.setTextColor(norcolor);
			allTextView.setTextColor(norcolor);
			
			leftMenu.showContent();
			
			break;
	
		case R.id.fasiondsgleftmainimg:
			eyeTextView.setTextColor(norcolor);
			roomTextView.setTextColor(norcolor);
			zlTextView.setTextColor(norcolor);
			fasionTextView.setTextColor(seccolor);
			allTextView.setTextColor(norcolor);
			
			leftMenu.showContent();
			
			break;
			
	
		case R.id.loginleftmain:
		//	login.setTextColor(seccolor);
//			login.setTextColor(Color.RED);
//			login.setTextColor(norcolor);
			enterLogin();
			
			
			break;
			
		default:
			break;
		}
		
		
		
	}
	
	public void initleftmenu(){
		leftMenu=new SlidingMenu(this);
		leftMenu.setMode(SlidingMenu.LEFT);
		leftMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		leftMenu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/2);
		leftMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		leftMenu.setFadeDegree(0.5f);	
		leftMenu.setMenu(R.layout.leftmainmenu);
		leftMenu.setFadeEnabled(true);
//		leftMenu.setBehindScrollScale(0.0f);
//		leftMenu.setBehindCanvasTransformer(mTransformer);
		leftMenu.addIgnoredView(leftMenu);
		
		leftMenu.setOnCloseListener(new OnCloseListener() {
			
			@Override
			public void onClose() {
				// TODO Auto-generated method stub
//				GroupView.groupmenu.setImageResource(R.drawable.top_left_button);
			}
		});
		
		leftMenu.setOnOpenListener(new OnOpenListener() {
			
			@Override
			public void onOpen() {
				// TODO Auto-generated method stub
//				GroupView.groupmenu.setImageResource(R.drawable.top_left_button_select);
			}
		});
		
	}
	private long exitTime = 0;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
				
		  if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
		        if((System.currentTimeMillis()-exitTime) > 2000){  
		            Toast.makeText(getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();                                
		            exitTime = System.currentTimeMillis();   
		            tabLayout.setVisibility(View.VISIBLE);
		        } else {
		            finish();
		            System.exit(0);
		        }
		        return true;   
		    }
		
		return super.onKeyDown(keyCode, event);
	}
	
	 /**
     * 进入登陆绑定界面
     */
    public void enterLogin(){
    	
    	Intent intent=new Intent();
    	intent.setClass(MainActivity.this, UserLogin.class);
    	startActivity(intent);
    	
    }
	
}
