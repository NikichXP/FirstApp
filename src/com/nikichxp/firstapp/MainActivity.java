package com.nikichxp.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends ActionBarActivity {

	private static TextView textMessage;
	private static Button pushButton;
	private static Button resetButton;
	private static CountDownTimer countdownToHideResetButton, pushButtonBlockCountdown;
	
	private static int countOfPushButtonPressed = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			
			final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			textMessage = (TextView) rootView.findViewById(R.id.msgText);
			pushButton = (Button) rootView.findViewById(R.id.pushBtn);
			pushButton.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View v) {
					textMessage = (TextView) rootView.findViewById(R.id.msgText);
					countOfPushButtonPressed++;
					switch (countOfPushButtonPressed) {
					case 1:
						textMessage.setText(R.string.textAfter1Press);
						break;
					case 2:
						textMessage.setText(R.string.textAfter2Press);
						break;
					case 3:
						textMessage.setText(R.string.textAfter3Press);
						break;
					case 6:
						textMessage.setText(R.string.textAfter6Press);
						break;
					case 10:
						textMessage.setText(R.string.textAfter10Press);
						break;
					case 20:
						textMessage.setText(R.string.textAfter20Press);
						countdownToHideResetButton = new CountDownTimer(30000, 1000) {
							@Override
							public void onTick(long millisUntilFinished) {
								
							}
							@Override
							public void onFinish() {
								Button reset = (Button) rootView.findViewById(R.id.resetBtn);
								reset.setVisibility(View.INVISIBLE);
							}
						};
						countdownToHideResetButton.start();
						break;
					default:
						break;
					}
					pushButton.setVisibility(View.INVISIBLE);
					Toast.makeText(rootView.getContext(), R.string.buttonIsInactive, Toast.LENGTH_SHORT).show();
					pushButtonBlockCountdown = new CountDownTimer(5000, 1000) {
						@Override
						public void onTick(long millisUntilFinished) {
						}
						@Override
						public void onFinish() {
							pushButton.setVisibility(View.VISIBLE);
						}
					};
					pushButtonBlockCountdown.start();
				}
			});
			resetButton = (Button) rootView.findViewById(R.id.resetBtn);
			resetButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					textMessage = (TextView) rootView.findViewById(R.id.msgText);
					textMessage.setText(R.string.hello_world);
					countOfPushButtonPressed = 0;
				}
			});
			return rootView;
		}
	}
}
