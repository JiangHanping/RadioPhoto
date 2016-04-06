package com.example.photo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv_main2;
	private ImageView iv_main1;
	private Button button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_main1=(ImageView)findViewById(R.id.iv_main1);
		iv_main2=(ImageView)findViewById(R.id.iv_main2);
		int[] a={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
		Animation_help animation_help=new Animation_help(this, iv_main2, iv_main1, a);
		animation_help.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
