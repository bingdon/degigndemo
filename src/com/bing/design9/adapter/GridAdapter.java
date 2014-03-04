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

/**
 * 
 * @author 刘兵
 *
 */
public class GridAdapter extends BaseAdapter{

	private LayoutInflater listContainer; 
	private List<Map<String, Object>> listItems; 
	
	public final class Temainfo{
		public ImageView teampro;
	}
	
	public GridAdapter(Context context,List<Map<String, Object>> list){
		this.listContainer=LayoutInflater.from(context);
		this.listItems=list;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		Temainfo temainfo;
		if (convertView==null) {
			temainfo=new Temainfo();
			convertView=listContainer.inflate(R.layout.team_grid, null);
			temainfo.teampro=(ImageView)convertView.findViewById(R.id.teamimagrid);
			convertView.setTag(temainfo);
		} else {
			temainfo=(Temainfo)convertView.getTag();
		}
		
		temainfo.teampro.setImageResource((Integer)listItems.get(position)
				.get("ima"));
		
		return convertView;
	}
	
}
