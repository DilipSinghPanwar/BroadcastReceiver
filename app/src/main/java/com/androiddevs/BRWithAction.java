package com.androiddevs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

public class BRWithAction extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String action = intent.getAction();
        if (action != null) {
            if (action.equals(ACTION_POWER_CONNECTED)) {
                Toast.makeText(context, "POWER_CONNECTED", Toast.LENGTH_SHORT).show();
            } else if (action.equals(ACTION_POWER_DISCONNECTED)) {
                Toast.makeText(context, "POWER_DISCONNECTED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
