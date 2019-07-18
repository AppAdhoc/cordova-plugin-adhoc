package com.appadhoc.plugin;

import com.adhoc.adhocsdk.AdhocTracker;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static com.adhoc.hybrid.AdhocWebViewClient.DOUBLE_PATTERN;
import static com.adhoc.hybrid.AdhocWebViewClient.LONG_PATTERN;

/**
 * This class echoes a string called from JavaScript.
 */
public class AdhocCordovaPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getFlag")) {
            getFlag(args, callbackContext);
            return true;
        } else if (action.equals("getFlagFast")) {
            getFlagFast(args, callbackContext);
            return false;
        } else if (action.equals("asynchronousGetFlag")) {
            asynchronousGetFlag(args, callbackContext);
            return true;
        } else if (action.equals("track")) {
            track(args, callbackContext);
            return true;
        } else if (action.equals("trackWithAttribute")) {
            trackWithAttribute(args, callbackContext);
            return true;
        } else if (action.equals("getClientId")) {
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
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof Number) {
            try {
                AdhocTracker.track(oneArg, NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            cac.error("Expected a numberical parameter");
        }
    }

    private void getClientId(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof Number) {
            try {
                AdhocTracker.track(oneArg, NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            cac.error("Expected a numberical parameter");
        }
    }

    private void getCurrentExperiments(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof Number) {
            try {
                AdhocTracker.track(oneArg, NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            cac.error("Expected a numberical parameter");
        }
    }

    private void trackWithAttribute(JSONArray args, CallbackContext cac) {
        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("Expected one non-empty string argument.");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof Number) {
            try {
                AdhocTracker.track(oneArg, NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            cac.error("Expected a numberical parameter");
        }
    }

    private void getFlag(JSONArray args, CallbackContext cac) {

        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof String) {
            String value = AdhocTracker.getFlag(oneArg, twoArg);
            cac.success(value);
        } else if (obj instanceof Boolean) {
            boolean value = AdhocTracker.getFlag(oneArg, Boolean.valueOf(twoArg));
            cac.success(Boolean.toString(value));

        } else if (obj instanceof Number) {
            Number x = null;
            try {
                x = NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Number value = AdhocTracker.getFlag(oneArg, x);
            cac.success(value.toString());
        }
    }

    private void getFlagFast(JSONArray args, CallbackContext cac) {

        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof String) {
            String value = AdhocTracker.getFlag(oneArg, twoArg);
            cac.success(value);
        } else if (obj instanceof Boolean) {
            boolean value = AdhocTracker.getFlag(oneArg, Boolean.valueOf(twoArg));
            cac.success(Boolean.toString(value));

        } else if (obj instanceof Number) {
            Number x = null;
            try {
                x = NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Number value = AdhocTracker.getFlag(oneArg, x);
            cac.success(value.toString());
        }
    }

    private void asynchronousGetFlag(JSONArray args, CallbackContext cac) {

        String oneArg = args.optString(0);
        String twoArg = args.optString(1);
        if (oneArg == null || oneArg.equals("") || twoArg == null || twoArg.equals("")) {
            cac.error("error! flag name or default value is empty");
            return;
        }
        Object obj = convert(twoArg);
        if (obj instanceof String) {
            String value = AdhocTracker.getFlag(oneArg, twoArg);
            cac.success(value);
        } else if (obj instanceof Boolean) {
            boolean value = AdhocTracker.getFlag(oneArg, Boolean.valueOf(twoArg));
            cac.success(Boolean.toString(value));

        } else if (obj instanceof Number) {
            Number x = null;
            try {
                x = NumberFormat.getNumberInstance(Locale.FRENCH).parse(twoArg);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Number value = AdhocTracker.getFlag(oneArg, x);
            cac.success(value.toString());
        }
    }
//    private void coolMethod(String message, CallbackContext callbackContext) {
//        if (message != null && message.length() > 0) {
//            callbackContext.success(message);
//        } else {
//            callbackContext.error("Expected one non-empty string argument.");
//        }
//    }

    public static Object convert(String item) {
        if (item == null || item.trim().equals("")) {
            return null;
        }
        item = item.trim();
        if ("true".equalsIgnoreCase(item) || "false".equalsIgnoreCase(item)) {
            return Boolean.valueOf(item);
        }
        if (item.matches(LONG_PATTERN)) {
            return Long.valueOf(item);
        }
        if (item.matches(DOUBLE_PATTERN)) {
            return Double.valueOf(item);
        }
        return item;
    }
}

