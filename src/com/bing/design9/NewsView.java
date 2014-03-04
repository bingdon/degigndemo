package com.bing.design9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.design9.adapter.NewsAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class NewsView extends Activity {

	private ListView newsListView;
	private NewsAdapter newsAdapter;
	private String[] newstitle = {"书带灯", "云计算",    
            "邮票", "爱心", "鼠标", "音乐CD"};  
	private String newString0="Android's application " +
			" framework lets you create rich and innovative " +
			" apps using a set of reusable components.";
	
    private String[] newsinfo = {   
            newString0,    
            newString0,    
            newString0,    
            newString0,   
            newString0,   
            newString0}; 
    
    private String[] newsdate ={
    		"2014-01-16",
    		"2014-01-16",
    		"2014-01-16",
    		"2014-01-16",
    		"2014-01-16",
    		"2014-01-16",
              };
    
    private Integer[] imgeIDs = {R.drawable.news_pic1,    
            R.drawable.news_pic2, R.drawable.news_pic3,   
            R.drawable.news_pic4, R.drawable.image_6,   
            R.drawable.image_3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_view);
		
		newsListView=(ListView)findViewById(R.id.newslistView1);
		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		inintnewsAdapter();
	}

	
	public void inintnewsAdapter(){
		newsAdapter=new NewsAdapter(this, getListItems());
		newsListView.setAdapter(newsAdapter);
		newsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				enterInfo();
			}
		});
		
	}
	
	
	private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < newstitle.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("imag", imgeIDs[i]);               //图片资源   
            map.put("title", newstitle[i]);     //物品名称   
            map.put("time", newsdate[i]);
            map.put("newsinfo", newsinfo[i]);
//            map.put("detail", goodsDetails[i]); //物品详情   
            listItems.add(map);   
        }      
        return listItems;   
    }
	
	/**
	 * 查看详情
	 */
	public void enterInfo(){
		Intent intent=new Intent();
		intent.setClass(NewsView.this, NewsInfo.class);
		startActivity(intent);
	}
	
}
