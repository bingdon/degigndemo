package com.bing.design9.adapter;

import java.util.List;
import java.util.Map;

import com.bing.design9.GroupView;
import com.bing.design9.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BingListAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	private int select_item;
	private int selectcolor=0;
	private int noselectcolor=0;
	
	
	private class BingTitle{
		public TextView bingText;
	}
	
	
	
	public BingListAdapter(Context context,List<Map<String, Object>> list){
		this.context=context;
		this.listItems=list;
		listContainer=LayoutInflater.from(context);
		selectcolor=context.getResources().getColor(R.color.select);
		noselectcolor=context.getResources().getColor(R.color.noselect);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		BingTitle bingTitle=null;
		if (convertView == null) {   
			bingTitle=new BingTitle();
            //获取list_item布局文件的视图   
            convertView = listContainer.inflate(com.bing.design9.R.layout.leftlist, null);
            //获取控件对象   
            bingTitle.bingText = (TextView)convertView.findViewById(R.id.leftlisttext);   
            //设置控件集到convertView   
            convertView.setTag(bingTitle);   
        }else {   
        	bingTitle = (BingTitle)convertView.getTag();   
        }   
		
		bingTitle.bingText.setText((String) listItems.get(position)   
                .get("title"));
		
		this.select_item=GroupView.left_menu_list_select_item;
		
		
		try{  
            if(this.select_item == position){  
                bingTitle.bingText.setTextSize(15);   //选中的Item字体：30px  
                bingTitle.bingText.setTextColor(selectcolor); 
            }  
            else  
            	bingTitle.bingText.setTextSize(12);   //未选中的Item字体：24px  
            	bingTitle.bingText.setTextColor(noselectcolor); 
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
		
		
		return convertView;
	}

}
