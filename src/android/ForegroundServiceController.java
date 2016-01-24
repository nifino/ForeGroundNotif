package com.nifino.android.fgn;

import android.content.Context;
import android.content.Intent;

/*
    cordova plugin remove com.nifino.android.bubble && cordova plugin add ..\..\ArrowBubble && ionic run --livereload
*/

/**
 * Created by roehrdor on 1/2/2016.
 */
public class ForegroundServiceController  {

    private Context cxt;

    public ForegroundServiceController(Context cxt){
        this.cxt = cxt;
    }

    public void startForegroundService() {
        Intent intent = new Intent(this.cxt, ForegroundService.class);
        intent.setAction(Constants.FOREGROUND_SERVICE_START);
        cxt.startService(intent);
    }

    public void stopForegroundService() {
        Intent intent = new Intent(this.cxt, ForegroundService.class);
        intent.setAction(Constants.FOREGROUND_SERVICE_STOP);
        cxt.startService(intent);
    }

    public void updateTitle(String title) {
        Intent intent = new Intent(this.cxt, ForegroundService.class);
        intent.setAction(Constants.FOREGROUND_SERVICE_UPDATE_TITLE);
        intent.putExtra("u", title);
        cxt.startService(intent);
    }

    public void updateText(String text) {
        Intent intent = new Intent(this.cxt, ForegroundService.class);
        intent.setAction(Constants.FOREGROUND_SERVICE_UPDATE_TEXT);
        intent.putExtra("u", text);
        cxt.startService(intent);
    }
}
