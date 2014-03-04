package com.bing.design9.adapter;

import java.util.List;
import java.util.Map;

import com.bing.design9.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter{

//	private Context context;
	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class NewsList{
		public ImageView image;     
        public TextView newstitle;
        public TextView time;
        public TextView info;
	}
	
	public NewsAdapter(Context context,List<Map<String, Object>> list) {
		// TODO Auto-generated constructor stub
		
//		this.context=context;
		this.listItems=list;
		this.listContainer=LayoutInflater.from(context);
		
		
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
		NewsList newsList=null;
		
		Log.i("视图", "getView:"+convertView+"position:"+position);
		
		if (convertView == null) {   
			newsList = new NewsList();    
            //获取list_item布局文件的视图   
            convertView = listContainer.inflate(R.layout.newslist, null);   
            //获取控件对象   
            newsList.image = (ImageView)convertView.findViewById(R.id.newsimg);   
            newsList.newstitle = (TextView)convertView.findViewById(R.id.newstitle);   
            newsList.time=(TextView)convertView.findViewById(R.id.newsdate);
            newsList.info= (TextView)convertView.findViewById(R.id.newsmain);   
            //设置控件集到convertView   
            convertView.setTag(newsList);   
        }else {   
        	newsList = (NewsList)convertView.getTag();   
        }   
		
		newsList.image.setImageResource((Integer)listItems.get(position)
				.get("imag"));
		newsList.newstitle.setText((String) listItems.get(position)   
                .get("title"));
		newsList.time.setText((String) listItems.get(position)   
                .get("time"));		
		newsList.info.setText((String) listItems.get(position)   
                .get("newsinfo"));
		
		return convertView;
	}

}
