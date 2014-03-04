package com.bing.design9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.design9.adapter.GridAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TeamInfo extends Activity {

	private GridView teamGridView;
	private GridAdapter mGridAdapter;
	private Integer[] imgeIDs = {R.drawable.team_info_middle_pic1,    
			 R.drawable.team_info_middle_pic2, R.drawable.team_info_middle_pic3,   
			 R.drawable.team_info_middle_pic1, R.drawable.team_info_middle_pic2,   
			 R.drawable.team_info_middle_pic3};
	
	private TextView teamzpText,teamneText,teamemailText,teaminfoText;
	private String[] chc={"我们一直在寻找热情、技艺精湛、雄心勃勃的新人才。请将简历发至以下邮箱，并说明您为何适合为Candy工作。"
			,"公司网站：WWW.Candy-Studio.com","公司邮箱：Candy-Studio@163.com"};
	
	private String teaminfo="Candy Studio是独特的设计团队，在24个国家拥有丰富卓越的设计经验。工作室为 Candy 的国际项目服务，已完成多项私人住宅和酒店项目，并将创意总监Philippe Starck、Marcel Wanders、Jade Jagger   和Kelly Hoppen的理念付诸实施。这使Candy Studio拥有独特的设计基因，这只有与世界顶级大师合作方可具备。";
	
	private RelativeLayout mLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_info);
		
//		teamGridView=(GridView)findViewById(R.id.teamprogrid);
//		mGridAdapter=new GridAdapter(this, getListItems());
//		teamGridView.setAdapter(mGridAdapter);
		teamzpText=(TextView)findViewById(R.id.teamzp);
		teamneText=(TextView)findViewById(R.id.teamnet);
		teamemailText=(TextView)findViewById(R.id.teamemail);
		teaminfoText=(TextView)findViewById(R.id.teaminfotxt);
		teamzpText.setText(chc[0]);
		teamneText.setText(chc[1]);
		teamemailText.setText(chc[2]);
		teaminfoText.setText(teaminfo);
		
		mLayout=(RelativeLayout)findViewById(R.id.gridlayout);
		mLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(TeamInfo.this, TeamProPic.class);
				startActivity(intent);
			}
		});
		
		
	}

	private List<Map<String, Object>> getListItems() {   
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();   
        for(int i = 0; i < imgeIDs.length; i++) {   
            Map<String, Object> map = new HashMap<String, Object>();    
            map.put("ima", imgeIDs[i]);               //图片资源   
            listItems.add(map);   
        }      
        return listItems;   
    }
}
