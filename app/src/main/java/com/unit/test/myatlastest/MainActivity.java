package com.unit.test.myatlastest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

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
    }

    public void switchToActivity(String key, String activityName) {
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), activityName);
        mActivityDelegate.startChildActivity(mActivityGroupContainer, key, intent);
    }
}
