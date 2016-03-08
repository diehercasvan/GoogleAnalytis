package com.diego.googleanalytisexample;
import android.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import java.util.HashMap;

/**
 * Created by DIEGO CASALLAS on 8/03/2016.
 */
public class GoogleAnalytisExample extends Application {
    private static final String PROPERTY_ID = "UA-74828804-1";
    public enum TrackerName {
        APP_TRACKER,
       // GLOBAL_TRACKER,
        //E_COMMERCE_TRACKER,
    }
    HashMap<TrackerName, Tracker> mTrackers = new HashMap<>();
    public GoogleAnalytisExample() {
        super();
    }

    synchronized Tracker getTracker(TrackerName trackerId) {
        if (!mTrackers.containsKey(trackerId)) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);

            //analytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
            Tracker t = null;
            if(trackerId==TrackerName.APP_TRACKER){
                t= analytics.newTracker(PROPERTY_ID);
            }
            mTrackers.put(trackerId, t);
        }
        return mTrackers.get(trackerId);
    }

}