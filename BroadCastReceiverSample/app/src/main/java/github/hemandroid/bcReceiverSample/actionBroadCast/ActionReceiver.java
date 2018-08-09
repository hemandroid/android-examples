package github.hemandroid.bcReceiverSample.actionBroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Action Performed....!", Toast.LENGTH_SHORT).show();
    }
}
