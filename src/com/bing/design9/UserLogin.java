package com.bing.design9;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class UserLogin extends Activity implements OnClickListener {

	
	private TextView aboutText;
	private ImageView wifistate;
	private boolean wifi=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_login);
		
		aboutText=(TextView)findViewById(R.id.abouttxt);
		wifistate=(ImageView)findViewById(R.id.wifistateimag);
		aboutText.setOnClickListener(this);		
		wifistate.setOnClickListener(this);	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int bingid=v.getId();
		switch (bingid) {
		case R.id.abouttxt:
			enterAbout();
			break;
		case R.id.wifistateimag:
			if (!wifi) {
				wifistate.setImageResource(R.drawable.wifi_no);
				wifi=true;
			} else {
				wifistate.setImageResource(R.drawable.wifi_yes1);
				wifi=false;
			}
			
			
			break;
			

		default:
			break;
		}
	}

	public void enterAbout(){
		Intent intent=new Intent();
		intent.setClass(UserLogin.this, AboutActivity.class);
		startActivity(intent);
		
		
	}
	
}
