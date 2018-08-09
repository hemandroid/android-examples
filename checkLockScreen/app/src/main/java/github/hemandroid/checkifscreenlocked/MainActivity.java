package github.hemandroid.checkifscreenlocked;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_check;
    private KeyguardManager mKeyguardManager;
    private Uri mUri;
    private Ringtone mRingtone;
    private Intent mIntent;
    private String str_action;
    private static final String LOGTAG = "CheckIfScreenLocked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mKeyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//        mUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//        mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mUri);
//
//        mIntent = new Intent();

//        if( mKeyguardManager.inKeyguardRestrictedInputMode()) {
//            try {
//                mUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//                mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mUri);
//                mRingtone.play();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            mUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//            mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mUri);
//            if (mRingtone.isPlaying()){
//                mRingtone.stop();
//            }
//        }
        checkScreenLockState();

//        btn_check = findViewById(R.id.btn_check);
//        btn_check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
//                    r.play();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    private void checkScreenLockState() {
        final IntentFilter i_filter = new IntentFilter();
        /** System Defined Broadcast Actions */
        i_filter.addAction(Intent.ACTION_SCREEN_ON);
        i_filter.addAction(Intent.ACTION_SCREEN_OFF);
        i_filter.addAction(Intent.ACTION_USER_PRESENT);

        BroadcastReceiver screenStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String strAction = intent.getAction();
                KeyguardManager kgMgr =
                        (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
                if (strAction.equals(Intent.ACTION_SCREEN_OFF)) {
                    Log.d(LOGTAG, "Screen Off");
                } else if (strAction.equals(Intent.ACTION_SCREEN_ON)) {
                    Log.d(LOGTAG, "Screen On");
                }
                if (strAction.equals(Intent.ACTION_USER_PRESENT) && !kgMgr.inKeyguardRestrictedInputMode()) {
                    Log.d(LOGTAG, "Device UNLOCKED");
                } else {
                    Log.d(LOGTAG, "Device LOCKED");
                }
            }
        };

        getApplicationContext().registerReceiver(screenStateReceiver, i_filter);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mKeyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
//        str_action = mIntent.getAction();
//        if (str_action.equals(Intent.ACTION_SCREEN_ON)){
//            mUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//            mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mUri);
//            if (mRingtone.isPlaying()){
//                mRingtone.stop();
//            }
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        str_action = mIntent.getAction();
//        if (str_action.equals(Intent.ACTION_SCREEN_OFF)){
//            try {
//                mUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//                mRingtone = RingtoneManager.getRingtone(getApplicationContext(), mUri);
//                mRingtone.play();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
