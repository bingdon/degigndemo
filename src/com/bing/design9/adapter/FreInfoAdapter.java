package com.bing.design9.adapter;

import java.util.List;
import java.util.Map;

import com.bing.design9.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FreInfoAdapter extends BaseAdapter{

	private List<Map<String, Object>> list;
//	private Context context;
	private LayoutInflater layoutInflater;
	
	
	public FreInfoAdapter(Context context,List<Map<String, Object>> list){
		this.list=list;
//		this.context=context;
		layoutInflater=LayoutInflater.from(context);
	}
	
	public class Person{
		public ImageView personimg;
		public TextView persontxt;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Person person=null;
		if (convertView==null) {
			person=new Person();
			convertView=layoutInflater.inflate(R.layout.personinfo, null);
			person.personimg=(ImageView)convertView.findViewById(R.id.freheadimg);
			person.persontxt=(TextView)convertView.findViewById(R.id.frenametxt);
			
			convertView.setTag(person);
			
		} else {
			person=(Person)convertView.getTag();
		}
		
		person.personimg.setImageResource((Integer)list.get(position).get("personimg"));
		person.persontxt.setText((String)list.get(position).get("persontxt"));
		
		return convertView;
	}

}
