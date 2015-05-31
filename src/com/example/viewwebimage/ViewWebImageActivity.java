package com.example.viewwebimage;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class ViewWebImageActivity extends Activity {
	Bitmap bmImg;   
	ImageView imView;
	String TAG = "ViewWebImage";
	String imageUrl = "http://static.cnbetacdn.com/article/2015/0321/e88d6f50b2ca8ed.png";  
	Button button1;   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_web_image);
		imView = (ImageView) findViewById(R.id.imview);   
		imView.setImageBitmap(returnBitMap(imageUrl));    
		
	}
	public Bitmap returnBitMap(String url) {   
		   URL myFileUrl = null;   
		   Bitmap bitmap = null;   
		   try {   
		    myFileUrl = new URL(url);   
		   } catch (MalformedURLException e) {   
		    Log.e(TAG, "no file", e);   
		   }   
		   try {   
			    HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();   
			    conn.setDoInput(true);   
			    conn.connect();   
			    InputStream is = conn.getInputStream();   
			    bitmap = BitmapFactory.decodeStream(is);   
			    is.close();   
			   } catch (IOException e) {   
			    Log.e(TAG, "linking fail", e);   
			   }   
			   return bitmap;   
			} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_web_image, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
