package com.diego.googleanalytisexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {
    private Tracker tracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadView();
            }
        });
        try
        {
            tracker=((GoogleAnalytisExample)getApplication()).getTracker(GoogleAnalytisExample.TrackerName.APP_TRACKER);
        }
        catch(Exception e){
            Log.e("Error", e.getMessage());
        }

    }
    @Override
    public void onStop() {
        super.onStop();
        //GoogleAnalytics.getInstance(this).reportActivityStop(this);
        tracker.setScreenName(null);
    }
    public void  loadView(){


        loadAnalytics("OtrasVainaFicti");

    }
    public void loadAnalytics(String sScreen){
        tracker.setScreenName(sScreen);
        // Send a screen view.
        tracker.send(new HitBuilders.AppViewBuilder().build());

    }

}
