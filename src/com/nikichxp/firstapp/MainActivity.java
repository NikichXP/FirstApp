package com.nikichxp.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	static TextView text, timer;
	static Button pushBtn;
	static Button resetBtn;
	static CountDownTimer time;
	
	int i = 0;
	private static Button test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	public void resetEvent(View view) {
		text = (TextView) findViewById(R.id.msgText);
		text.setText("������!");
		i = 0;
		
	}

	public void pushEvent(View view) {
		text = (TextView) findViewById(R.id.msgText);
		i++;
		time = new CountDownTimer(20000, 1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				
			}
		};
		switch (i) {
		case 1:
			text.setText("U pushed da buttn!");
			break;
		case 2:
			text.setText("U pushed it again!");
			break;
		case 3:
			text.setText("Yo man, stop pushin' it!");
			break;
		case 6:
			text.setText("Yo, are u kiddin'? Stop pushin it NOW!");
			break;
		case 10:
			text.setText("I meant stop it NOW!!!");
			break;
		case 20:
			text.setText("Okay, u've got it!");
			time = new CountDownTimer(30000, 1000) {
				
				@Override
				public void onTick(long millisUntilFinished) {
					//DO NOTHING
				}
				
				@Override
				public void onFinish() {
					Button reset = (Button) findViewById(R.id.resetBtn);
					reset.setVisibility(View.INVISIBLE);
				}
			};
			time.start();
			break;
		default:
			break;
		}
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			test = (Button) rootView.findViewById(R.id.testBtn);
			text = (TextView) rootView.findViewById(R.id.msgText);
			test.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View v) {
					text.setText("TEST!");
					resetBtn = (Button) rootView.findViewById(R.id.resetBtn);
					resetBtn.setVisibility(View.INVISIBLE);
				}
			});
			return rootView;
		}
	}
}
