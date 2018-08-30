package com.androiddevs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BRWithoutAction extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String valueReceived = intent.getStringExtra("key");
        Toast.makeText(context.getApplicationContext(), "Static BroadCast\n" + valueReceived, Toast.LENGTH_SHORT).show();
    }
}
