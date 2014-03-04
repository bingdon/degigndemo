package com.bing.design9.utils;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BingTools {


	/**
	 * 
	 * @param context 指针
	 * @param resId 地址
	 * @return 图片
	 */
	public static Bitmap readBitMap(Context context, int resId){  
          BitmapFactory.Options opt = new BitmapFactory.Options();  
          opt.inPreferredConfig = Bitmap.Config.RGB_565;   
          opt.inPurgeable = true;  
          opt.inInputShareable = true;  
          //鑾峰彇璧勬簮鍥剧墖  
          InputStream is = context.getResources().openRawResource(resId);  
          return BitmapFactory.decodeStream(is,null,opt);  
    }
	
}
