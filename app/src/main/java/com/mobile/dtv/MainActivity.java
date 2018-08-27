package com.mobile.dtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    LinearLayout live_tv, recording, settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView(){
        live_tv = (LinearLayout) findViewById(R.id.LinearLayout_Live_tv);
        recording = (LinearLayout) findViewById(R.id.LinearLayout_recording);
        settings = (LinearLayout) findViewById(R.id.LinearLayout_settings);

        live_tv.setOnClickListener(this);
        recording.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LinearLayout_Live_tv:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ActivityLiveTV.class);
                startActivity(intent);
                break;
            case R.id.LinearLayout_recording:
                 intent = new Intent();
                intent.setClass(MainActivity.this, ActivityRecording.class);
                startActivity(intent);
                break;
            case R.id.LinearLayout_settings:
                intent = new Intent();
                intent.setClass(MainActivity.this, ActivitySettings.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
