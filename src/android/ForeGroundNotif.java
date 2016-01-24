package com.nifino.android.fgn;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ForeGroundNotif extends CordovaPlugin {

    private ForegroundServiceController mForegroundServiceController = null;

    private static CordovaInterface sI = null;

    public static CordovaInterface getCordovaInterface() { return sI; }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);        
        sI = cordova;
        this.mForegroundServiceController = new ForegroundServiceController(this.cordova.getActivity());        
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("startFGN")) {
            this.mForegroundServiceController.startForegroundService();
            callbackContext.success();
            return true;
        } else if(action.equals("stopFGN")) {
            this.mForegroundServiceController.stopForegroundService();
            callbackContext.success();
            return true;
        } else if(action.equals("updateTitle")) {
            this.mForegroundServiceController.updateTitle(args.getString(0));
            callbackContext.success();
            return true;
        } else if(action.equals("updateText")) {
            this.mForegroundServiceController.updateText(args.getString(0));
            callbackContext.success();
            return true;
        }

        return false;
    }
}
