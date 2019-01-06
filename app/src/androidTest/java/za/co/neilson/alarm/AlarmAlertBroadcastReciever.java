package za.co.neilson.alarm;

import za.co.neilson.alarm.Alarm;
import za.co.neilson.alarm.service.AlarmServiceBroadcastReciever;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AlarmAlertBroadcastReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent mathAlarmServiceIntent = new Intent(
				context,
				AlarmServiceBroadcastReciever.class);
		context.sendBroadcast(mathAlarmServiceIntent, null);

		za.co.neilson.alarm.alert.StaticWakeLock.lockOn(context);
		Bundle bundle = intent.getExtras();
		final Alarm alarm = (Alarm) bundle.getSerializable("alarm");

		Intent mathAlarmAlertActivityIntent;

		mathAlarmAlertActivityIntent = new Intent(context, za.co.neilson.alarm.alert.AlarmAlertActivity.class);

		mathAlarmAlertActivityIntent.putExtra("alarm", alarm);

		mathAlarmAlertActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		context.startActivity(mathAlarmAlertActivityIntent);
	}

}
