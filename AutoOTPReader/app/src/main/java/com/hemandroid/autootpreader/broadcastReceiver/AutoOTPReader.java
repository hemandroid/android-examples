package com.hemandroid.autootpreader.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.hemandroid.autootpreader.MainActivity;

public class AutoOTPReader extends BroadcastReceiver {

    MainActivity auto_sms = new MainActivity();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null){
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    /** If the incoming message contains the unnecessary information along with the OTP number.
                     * Then we have to separate the required OTP number from the received SMS, then
                     * pass the below substr into getSms() method*/
                    String substr = message.substring(11, 18).trim();

                    /** In the below if condition we are validating the incoming sms
                     * by matching with the respective Header names.
                     * ex: If my incoming sms contains the header name as mentioned below.
                     *     Then only the broadcast receiver triggered and pickup the necessary message
                     *     and return as our output*/

                    try{
                        if (senderNum.contains("HP-HORNET")){
                            auto_sms.getSms(message);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
