package com.bing.design9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.design9.adapter.MyAdapter;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.PLA_AdapterView.OnItemClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyDesign extends Activity implements OnItemClickListener {

private List<Map<String, Object>> listItems;   
	
	private String[] goodsNames = {"蛋糕", "礼物",    
            "邮票", "爱心", "鼠标", "音乐CD"};   
    private String[] goodsDetails = {   
            "蛋糕：好好吃。",    
            "礼物：礼轻情重。",    
            "邮票：环游世界。",    
            "爱心：世界都有爱。",   
            "鼠标：反应敏捷。",   
            "音乐CD：酷我音乐。"}; 
    
    private Integer[] imgeIDs = {R.drawable.designer2,    
            R.drawable.designer3, R.drawable.designer1,   
            R.drawable.designer4, R.drawable.designer5,   
            R.drawable.designer6};
	
    private MultiColumnListView multiColumnListView;
    
    private MyAdapter myAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_design);
		
		multiColumnListView=(MultiColumnListView)findViewById(R.id.fl_media_falls_list);
		multiColumnListView.setOnItemClickListener(this);
		
		multiColumnListView.setSelector(R.drawable.bing_trlu);
		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		inintmyAdapter();
	}

	public void inintmyAdapter(){
		myAdapter=new MyAdapter(MyDesign.this, getListItems());
		
		multiColumnListView.setAdapter(myAdapter);
	}
	
	private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < goodsNames.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("imag", imgeIDs[i]);               //图片资源   
            map.put("title", goodsNames[i]);     //物品名称   
            listItems.add(map);   
        }      
        return listItems;   
    }

	@Override
	public void onItemClick(PLA_AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		intent.setClass(MyDesign.this, DesignInfo.class);
		startActivity(intent);
	}

}
