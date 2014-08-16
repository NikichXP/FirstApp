package com.nikichxp.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends ActionBarActivity {

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

		private TextView textMessage;	//Сообщение, которое видит пользователь
		private Button pushButton;		//Кнопка push. Приносит боль и негодование у программы.
		private Button resetButton;		//Кнопка reset. Новая игра :D
		private CountDownTimer countdownTimer;
		private int countOfPushButtonPressed = 0;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			final View rootView = inflater.inflate(R.layout.fragment_main,
					container, false);

			initiateObjects(rootView);
			
			addButtonListeners(rootView);

			return rootView;
		}

		private void initiateObjects (final View rootView) {
			textMessage = (TextView) rootView.findViewById(R.id.msgText);
			resetButton = (Button) rootView.findViewById(R.id.resetBtn);
			pushButton = (Button) rootView.findViewById(R.id.pushBtn);
		}

		private void addButtonListeners(final View rootView) {
			
			resetButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					textMessage.setText(R.string.hello_world);
					countOfPushButtonPressed = 0;
				}
				
			});

			pushButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
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
						Toast.makeText(rootView.getContext(),
								R.string.resetButtonHideMsg1, Toast.LENGTH_LONG)
								.show();
						countdownTimer = new CountDownTimer(30000,
								1000) {
							@Override
							public void onTick(long millisUntilFinished) {

							}

							@Override
							public void onFinish() {
								resetButton.setVisibility(View.INVISIBLE);
								Toast.makeText(rootView.getContext(),
										R.string.resetButtonHideMsg2, Toast.LENGTH_LONG)
										.show();
							}
						};
						countdownTimer.start();
						break;
					default:
						break;
					}
					
					pushButton.setVisibility(View.INVISIBLE);
					Toast.makeText(rootView.getContext(),
							R.string.buttonIsInactive, Toast.LENGTH_SHORT)
							.show();
					
					countdownTimer = new CountDownTimer(5000, 1000) {
						
						@Override
						public void onTick(long millisUntilFinished) {
						}

						@Override
						public void onFinish() {
							pushButton.setVisibility(View.VISIBLE);
						}
					};
					countdownTimer.start();
				}
			});
		}
	}
}
