package com.bing.design9;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;

public class DesignInfo extends Activity {

	private TextView designinfom0,designinfom1,designname0,
						designname1,designname2;
	private String m0="我是一名视觉设计师，来自巴黎。经过几年的自由UI设计的工作，现在我专注于我自己的项目，比如Sidebar和Discover Meteor，现在我住在日本大阪。" +
			"\n"+"\n"+
			"嗯，我记得我一直在摆弄电脑和网络数据。我不是一个计算机科学天才,但是我喜欢创造和设计。说实话我从来没有想过我会有一天把视觉设计做为一个职业生涯。但是当我所有的其他计";
	private String m1="划开始分崩离析无法聚拢和实施时,我发现视觉设计是我拥有的一个良好技能,人们乐于支付我。" +
			"\n"+
			"这是设计师简介那一页";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_design_info);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.design_info, menu);
		return true;
	}

	
	private void initView(){
		designinfom0=(TextView)findViewById(R.id.designinfo_main0);
		designinfom1=(TextView)findViewById(R.id.designinfo_main1);
		designname0=(TextView)findViewById(R.id.design_name_0);
		designname1=(TextView)findViewById(R.id.design_name_1);
		designname2=(TextView)findViewById(R.id.design_name_3);
		
		designinfom0.setText(m0);
		designinfom1.setText(m1);
		
		designname1.setText("@Simon Naouri");
		
	}
	
}
