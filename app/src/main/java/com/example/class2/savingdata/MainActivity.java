package com.example.class2.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putInt(getString(R.string.level_key),6);
        editor.commit();

        SharedPreferences activityPref= this.getPreferences(Context.MODE_PRIVATE);
        activityPref.edit().putString(getString(R.string.best_user_key), "Bob").commit();




    }

    @Override
    protected void onResume() {
        super.onResume();


       SharedPreferences sharedPref=this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
       int level = sharedPref.getInt(getString(R.string.level_key),0);
        Log.d("MyActivity", "Level:" + level);
    }
}
