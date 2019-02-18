package com.unit.test.myatlastest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.atlas.dex.util.FileUtils;
import com.taobao.atlas.update.AtlasUpdater;
import com.taobao.atlas.update.model.UpdateInfo;

import com.taobao.android.ActivityGroupDelegate;

public class MainActivity extends AppCompatActivity {
    private ActivityGroupDelegate mActivityDelegate;
    private ViewGroup mActivityGroupContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityDelegate = new ActivityGroupDelegate(this, savedInstanceState);
        mActivityGroupContainer = (ViewGroup) findViewById(R.id.content);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClassName(MainActivity.this, "com.unit.test.firstbundle.FirstBundleActivity");
////                intent.setClassName(MainActivity.this, "com.unit.test.myatlastest.MainActivity");
//                startActivity(intent);


                switchToActivity("home", "com.unit.test.firstbundle.FirstBundleActivity");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        Updater.update(getBaseContext());
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                }.execute();
            }
        });
    }

    public void switchToActivity(String key, String activityName) {
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), activityName);
        mActivityDelegate.startChildActivity(mActivityGroupContainer, key, intent);
    }
}
