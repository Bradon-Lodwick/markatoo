package com.bradonlodwick.markatoo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences prefs;
    public SharedPreferences.Editor prefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initial setup
        super.onCreate(savedInstanceState);

        // Get shared preferences
        prefs = this.getSharedPreferences(
                getString(R.string.package_name), Context.MODE_PRIVATE);

        // Get if the app has been used or not
        boolean first_time = prefs.getBoolean(getString(R.string.first_time), true);

        // If the app is being opened for the first time, runs special instance
        if (first_time) {
            // Sets the app to use the welcome screen before moving to the default screen
            setContentView(R.layout.activity_first_launch);
            // Sets up the button to return the application to the default view
            Button getStartedButton = findViewById(R.id.getStartedBtn);
            getStartedButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Sets the preference value to show the app has been used before
                    prefsEditor.putBoolean(getString(R.string.first_time), true);
                    // Set the view to the normal view
                    setContentView(R.layout.activity_main);
                }
            });
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }
}
