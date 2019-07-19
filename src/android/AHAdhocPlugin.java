package com.appadhoc.plugin;

import android.text.TextUtils;
import android.util.Log;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.adhocsdk.ExperimentFlags;
import com.adhoc.adhocsdk.OnAdHocReceivedData;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import static com.adhoc.hybrid.AdhocWebViewClient.DOUBLE_PATTERN;
import static com.adhoc.hybrid.AdhocWebViewClient.LONG_PATTERN;
import static com.adhoc.hybrid.AdhocWebViewClient.TAG;

/**
 * This class echoes a string called from JavaScript.
 */
public class AHAdhocPlugin extends CordovaPlugin {

    private static final String TAG = "AHAdhocPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getFlag")) {
            getFlag(args, callbackContext);
            return true;
        } else if (action.equals("getFlagFast")) {
            getFlagFast(args, callbackContext);
            return true;
        } else if (action.equals("asynchronousGetFlag")) {
            asynchronousGetFlag(args, callbackContext);
            return true;
        } else if (action.equals("track")) {
            track(args, callbackContext);
            return true;
        } else if (action.equals("trackWithAttribute")) {
            trackWithAttribute(args, callbackContext);
            return true;
        } else if (action.equals("getClientID")) {
            getClientId(args, callbackContext);
            return true;
        } else if (action.equals("getCurrentExperiments")) {
            getCurrentExperiments(args, callbackContext);
            return true;
        }
        return false;
    }

    private void track(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        int twoArg = args.optInt(1);
        if (TextUtils.isEmpty(oneArg)) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        AdhocTracker.track(oneArg, twoArg);
        cac.success();
    }

    private void getClientId(JSONArray args, CallbackContext cac) {
        cac.success(AdhocTracker.getClientId());
    }

    private void getCurrentExperiments(JSONArray args, CallbackContext cac) {
        cac.success(AdhocTracker.getCurrentExperiments());
    }

    private static HashMap<String, String> toMap(JSONObject jsonobj) {
        HashMap<String, String> map = new HashMap<String, String>();
        if (jsonobj == null) {
            return map;
        }
        try {
            Iterator<String> keys = jsonobj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonobj.getString(key);
                map.put(key, value);
            }
        } catch (Throwable t) {
            Log.i(TAG, "toMap: ");
        }
        return map;
    }

    private void trackWithAttribute(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        int twoArg = args.optInt(1);
        JSONObject attribute = args.optJSONObject(2);
        if (TextUtils.isEmpty(oneArg)) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        AdhocTracker.track(oneArg, twoArg, toMap(attribute));
        cac.success();
    }

    private void getFlag(JSONArray args, CallbackContext cac) {

        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (TextUtils.isEmpty(oneArg) || TextUtils.isEmpty(twoArg)) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        String value = AdhocTracker.getFlag(oneArg, twoArg);
        cac.success(value);
    }

    private void getFlagFast(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        double timeOut = args.optDouble(2);
        if (TextUtils.isEmpty(oneArg) || TextUtils.isEmpty(twoArg)) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        AdhocTracker.fastGetFlag((int) (timeOut * 1000), new OnAdHocReceivedData() {
            @Override
            public void onReceivedData(ExperimentFlags experimentFlags) {
                cac.success(experimentFlags.getFlag(oneArg, twoArg));
            }
        });

    }

    private void asynchronousGetFlag(JSONArray args, CallbackContext cac) {

        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        double timeOut = args.optDouble(2);
        if (TextUtils.isEmpty(oneArg) || TextUtils.isEmpty(twoArg)) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        AdhocTracker.asyncGetFlag((int) (timeOut * 1000), new OnAdHocReceivedData() {
            @Override
            public void onReceivedData(ExperimentFlags experimentFlags) {
                cac.success(experimentFlags.getFlag(oneArg, twoArg));
            }
        });
    }

}



