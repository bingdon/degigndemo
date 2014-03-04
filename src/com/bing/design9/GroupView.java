package com.bing.design9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.design9.adapter.BingListAdapter;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.CanvasTransformer;

import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class GroupView extends ActivityGroup implements OnClickListener {

	private ImageView myTeam,myDesigner;
	
	public static ImageView groupmenu;
	private LinearLayout bodyLayout;
	private int flag=0;
	
	private SlidingMenu leftMenu;
	private CanvasTransformer mTransformer;  
	
	private TextView eyedsg,roomdsg,showdsg,fasiondeg;
	
	public static int left_menu_list_select_item=-1;
	
	private ListView selectList=null;//侧边栏listview
	
	private BingListAdapter bingListAdapter;//自定义适配器
	
	private TextView loginchoice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_view);
		
		initView();
		
		initAnimation();
		
		showciew(flag);
//		initleftmenu();
		
		myTeam.setOnClickListener(this);
		myDesigner.setOnClickListener(this);
		groupmenu.setOnClickListener(this);
		
//		eyedsg=(TextView)findViewById(R.id.eyedsg);
//		roomdsg=(TextView)findViewById(R.id.roomdsg);
//		showdsg=(TextView)findViewById(R.id.showdsg);
//		fasiondeg=(TextView)findViewById(R.id.fasiondeg);
//		
//		eyedsg.setTextColor(Color.argb(150, 0, 0, 0));
//		roomdsg.setTextColor(Color.argb(150, 0, 0, 0));
//		showdsg.setTextColor(Color.argb(150, 0, 0, 0));
//		fasiondeg.setTextColor(Color.argb(150, 0, 0, 0));
//		
//		eyedsg.setOnClickListener(this);
//		roomdsg.setOnClickListener(this);
//		showdsg.setOnClickListener(this);
//		fasiondeg.setOnClickListener(this);
		
		
//		selectList=(ListView)findViewById(R.id.leftlistview);
//		bingListAdapter=new BingListAdapter(this, GetDate());
//		selectList.setAdapter(bingListAdapter);
//		
//		selectList.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				// TODO Auto-generated method stub
//				left_menu_list_select_item=arg2;
//				bingListAdapter.notifyDataSetChanged();
//			}
//		});
//		
//		loginchoice=(TextView)findViewById(R.id.loginchoice);
//		loginchoice.setOnClickListener(this);
		
		
	}

	public void initView(){
		myTeam=(ImageView)findViewById(R.id.myteam);
		myDesigner=(ImageView)findViewById(R.id.newsview);
		bodyLayout=(LinearLayout)findViewById(R.id.linetad);
		groupmenu=(ImageView)findViewById(R.id.groupmenu);
	}

	

	@SuppressWarnings("deprecation")
	public void showciew(int flag){
		switch (flag) {
		case 0:
			bodyLayout.removeAllViews();
			View v0 = getLocalActivityManager().startActivity("for",  
                    new Intent(GroupView.this, MyTeam.class)).getDecorView(); 
			bodyLayout.addView(v0);
			break;
			
		case 1:
			bodyLayout.removeAllViews();
			View v1 = getLocalActivityManager().startActivity("five",  
                    new Intent(GroupView.this, MyDesign.class)).getDecorView(); 
			bodyLayout.addView(v1);
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
			flag=0;
//			leftMenu.addIgnoredView(leftMenu);
			
			myTeam.setImageResource(R.drawable.top_tuandui_select);
			myDesigner.setImageResource(R.drawable.top_designer);
			
			break;
			
		case R.id.newsview:
			flag=1;
//			leftMenu.clearIgnoredViews();
			
			myTeam.setImageResource(R.drawable.top_tuandui);
			myDesigner.setImageResource(R.drawable.top_designer_select);
			
			break;

		case R.id.groupmenu:
//			leftMenu.showMenu();	
			
			MainActivity.leftMenu.showMenu();
			
			break;
			
		case R.id.eyedsg:
			
			leftMenu.showContent();	
			eyedsg.setTextColor(Color.argb(255, 0, 0, 0));
			roomdsg.setTextColor(Color.argb(150, 0, 0, 0));
			showdsg.setTextColor(Color.argb(150, 0, 0, 0));
			fasiondeg.setTextColor(Color.argb(150, 0, 0, 0));
			
			break;
			
		case R.id.loginchoice:
			enterLogin();
			
			break;
			
//		case R.id.roomdsg:
//			eyedsg.setTextColor(Color.argb(150, 0, 0, 0));
//			roomdsg.setTextColor(Color.argb(255, 0, 0, 0));
//			showdsg.setTextColor(Color.argb(150, 0, 0, 0));
//			fasiondeg.setTextColor(Color.argb(150, 0, 0, 0));
//			
//			leftMenu.showContent();		
//			break;
//			
//		case R.id.showdsg:
//			eyedsg.setTextColor(Color.argb(150, 0, 0, 0));
//			roomdsg.setTextColor(Color.argb(150, 0, 0, 0));
//			showdsg.setTextColor(Color.argb(255, 0, 0, 0));
//			fasiondeg.setTextColor(Color.argb(150, 0, 0, 0));
//			
//			leftMenu.showContent();		
//			break;
//			
//		case R.id.fasiondeg:
//			eyedsg.setTextColor(Color.argb(150, 0, 0, 0));
//			roomdsg.setTextColor(Color.argb(150, 0, 0, 0));
//			showdsg.setTextColor(Color.argb(150, 0, 0, 0));
//			fasiondeg.setTextColor(Color.argb(255, 0, 0, 0));
//			
//			leftMenu.showContent();	
//			break;
			
			
		default:
			break;
		}
		
		showciew(flag);
	}
	
	
	@SuppressWarnings("deprecation")
	public void initleftmenu(){
		leftMenu=new SlidingMenu(this);
		leftMenu.setMode(SlidingMenu.LEFT);
		leftMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		leftMenu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/2);
		leftMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		leftMenu.setFadeDegree(0.5f);	
		leftMenu.setMenu(R.layout.leftme);
		leftMenu.setFadeEnabled(true);
//		leftMenu.setBehindScrollScale(0.0f);
//		leftMenu.setBehindCanvasTransformer(mTransformer);
		leftMenu.addIgnoredView(leftMenu);
	}
	
	 /** 
     * 初始化动画效果 
     */  
    private void initAnimation(){  
        mTransformer = new CanvasTransformer(){  
            @Override  
            public void transformCanvas(Canvas canvas, float percentOpen) {  
                float scale = (float) (percentOpen*0.25 + 0.75);  
                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);                
            }  
              
        };  
    }  
	
    /**
     * 获取数据
     * @return
     */
    public  List<Map<String,Object>>  GetDate(){  
        
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>(); //存在一个大仓库，摆放着很多抽屉 ，list相当把抽屉放进仓库。     
                                                                          // 这是upcast 或者ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();也行  
         
        Map<String,Object>  map=new HashMap<String,Object>();//抽屉，里面有东西。  
        map.put("title", "视觉设计");//把东西放到抽屉里面  
        list.add(map);//把抽屉放到仓库里  
          
        HashMap<String,Object> map1=new HashMap<String,Object>();  
        map1.put("title", "室内设计");  
        list.add(map1);  
          
        HashMap<String,Object> map2=new HashMap<String,Object>();   
        map2.put("title", "展览设计");  
        list.add(map2);
        
        
        HashMap<String,Object> map3=new HashMap<String,Object>();   
        map3.put("title", "潮流设计");  
        list.add(map3);
          
   return list;  
    }
    
    /**
     * 进入登陆绑定界面
     */
    public void enterLogin(){
    	
    	Intent intent=new Intent();
    	intent.setClass(GroupView.this, UserLogin.class);
    	startActivity(intent);
    	
    }
    
}
