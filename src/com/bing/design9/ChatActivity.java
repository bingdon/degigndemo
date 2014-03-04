package com.bing.design9;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.design9.adapter.FreInfoAdapter;
import com.bing.design9.adapter.Mbindadpter;


import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ChatActivity extends Activity implements OnTouchListener {

	
	private Button sendButton;
	private EditText sendEditText;
	private ListView listView,listView2;
	private ImageView persononline;
	List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> personList=new ArrayList<Map<String,Object>>();
	Mbindadpter mbindadpter;
	RelativeLayout personLayout;
	FreInfoAdapter freInfoAdapter;
	private static final String TAG="聊天";
	
	private int[] img={R.drawable.online_pic1,R.drawable.online_pic2,
			R.drawable.online_pic3,R.drawable.online_pic4,R.drawable.ic_launcher,
			R.drawable.image_1};
	
	private String[] personname={"aing","bing","cing","ding","eing","fing"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		sendButton=(Button)findViewById(R.id.sendbutton);
		sendEditText=(EditText)findViewById(R.id.sendeditText1);
		listView=(ListView)findViewById(R.id.listView1);
		personLayout=(RelativeLayout)findViewById(R.id.personlayout);
		
		mbindadpter=new Mbindadpter(this, list);
		
		sendButton.setEnabled(false);
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Map<String,Object>  map=new HashMap<String,Object>();
				
				 Calendar calendar=Calendar.getInstance();
				String word=sendEditText.getText().toString();
				
				String time=""+calendar.get(Calendar.HOUR)+":"
						+calendar.get(Calendar.MINUTE);
				map.put("getwords", word);
				map.put("gettime", time);
				list.add(map);
				mbindadpter.notifyDataSetChanged();
				sendEditText.setText("");
				sendButton.setEnabled(false);
				
			}
		});
		
		
		listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listView.setAdapter(mbindadpter);
		
		sendEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
				if (s.length()>0) {
					sendButton.setEnabled(true);
				} else {
					sendButton.setEnabled(false);
				}
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});
		
		initPerson();
//		listView.setOnClickListener(this);
		listView.setOnTouchListener(this);
		
		personLayout.setVisibility(View.GONE);
		
		persononline=(ImageView)findViewById(R.id.freheadimg);
		persononline.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (personLayout.isShown()) {
					personLayout.setVisibility(View.GONE);
				}else {
					personLayout.setVisibility(View.VISIBLE);
				}
				
				Log.i(TAG, "菜单");
			}
		});
		
	}

	private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < img.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("personimg", img[i]);              
            map.put("persontxt", personname[i]);    
            listItems.add(map);   
        }      
        return listItems;   
    }
	
	
	public void initPerson(){
		listView2=(ListView)findViewById(R.id.listView2);
		freInfoAdapter=new FreInfoAdapter(this, getListItems());
		listView2.setAdapter(freInfoAdapter);
	}
	

	private long exitTime = 0;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
				
		  if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
		        if((System.currentTimeMillis()-exitTime) > 2000){  
		            Toast.makeText(getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();                                
		            exitTime = System.currentTimeMillis();   
		            MainActivity.tabLayout.setVisibility(View.VISIBLE);
		        } else {
		            finish();
		            System.exit(0);
		        }
		        return true;   
		    }
		
		return super.onKeyDown(keyCode, event);
	}


	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		Log.i(TAG, "触摸:"+event.getAction());
		if (MainActivity.tabLayout.isShown()) {
			MainActivity.tabLayout.setVisibility(View.GONE);
		}
		
		return false;
	}

	
}
