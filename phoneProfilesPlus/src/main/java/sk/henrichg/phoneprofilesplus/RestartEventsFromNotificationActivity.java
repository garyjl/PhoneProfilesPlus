package sk.henrichg.phoneprofilesplus;

import android.app.Activity;
import android.os.Bundle;

public class RestartEventsFromNotificationActivity extends Activity
{
	
	private DataWrapper dataWrapper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

		GlobalData.loadPreferences(getApplicationContext());
		
		dataWrapper = new DataWrapper(getApplicationContext(), false, false, 0);
	 
	}

	@Override
	protected void onStart()
	{
		super.onStart();

		// set theme and language for dialog alert ;-)
		// not working on Android 2.3.x
		GUIData.setTheme(this, true, false);
		GUIData.setLanguage(getBaseContext());
		
		dataWrapper.restartEventsWithAlert(this);
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();

		dataWrapper.invalidateDataWrapper();
		dataWrapper = null;
	}

}
