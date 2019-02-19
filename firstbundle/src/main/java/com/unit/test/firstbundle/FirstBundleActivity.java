package com.unit.test.firstbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//
//import com.taobao.secondbundlelibrary.SecondbundleShareActivity;

/**
 * Created by yangsimin on 2018/11/26.
 */

public class FirstBundleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_bundle_acticity);
        findViewById(R.id.second_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(FirstBundleActivity.this, SecondActivity.class));
//                Intent intent = new Intent();
//                intent.setClass(FirstBundleActivity.this, SecondbundleShareActivity.class);
//                startActivity(intent);

                Intent intent = new Intent();
                intent.setClass(FirstBundleActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
