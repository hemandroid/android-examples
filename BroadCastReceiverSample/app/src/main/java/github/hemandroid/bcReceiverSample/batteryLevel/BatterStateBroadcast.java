package github.hemandroid.bcReceiverSample.batteryLevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hemasaicharan on 05/08/18.
 */

public class BatterStateBroadcast extends BroadcastReceiver {

    private String str_action;

    @Override
    public void onReceive(Context context, Intent intent) {

        str_action = intent.getAction();

        if (str_action.equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Device connected for Charging....!", Toast.LENGTH_SHORT).show();
        } else if (str_action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Device Dis-connected from Charging....!", Toast.LENGTH_SHORT).show();
        }
    }
}
