package com.bing.design9.adapter;

import java.util.List;
import java.util.Map;

import com.bing.design9.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 聊天界面适配器
 * @author lyl
 *
 */
public class Mbindadpter extends BaseAdapter{

	Context context;
	
	LayoutInflater layoutInflater;
	
	List<Map<String, Object>> list;
	
	
	public Mbindadpter(Context context,List<Map<String, Object>> listbing){
		this.context=context;
		this.list=listbing;
		layoutInflater=LayoutInflater.from(context);
	}
	
	public class Sendline{
		public TextView getword;
		public TextView timeTextView;
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

	
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		Sendline sendline=null;
		if (convertView==null) {
			 sendline=new Sendline();
			if (list.get(position).equals("IN")) {
				
				convertView=layoutInflater.inflate(R.layout.chat_in, null);
				sendline.getword=(TextView)convertView.findViewById(R.id.in_word);
				sendline.timeTextView=(TextView)convertView.findViewById(R.id.timeintxt);
				
				
			} else {
				
				convertView=layoutInflater.inflate(R.layout.chat_out, null);
				
				sendline.getword=(TextView)convertView.findViewById(R.id.out_word);
				sendline.timeTextView=(TextView)convertView.findViewById(R.id.timeouttxt);
				
			}
			
			
			
			convertView.setTag(sendline);
		}else {
			sendline=(Sendline)convertView.getTag();
		}
		
		
		sendline.getword.setText((String)list.get(position).get("getwords"));
		sendline.timeTextView.setText((String)list.get(position).get("gettime"));
		
		return convertView;
	}

}
