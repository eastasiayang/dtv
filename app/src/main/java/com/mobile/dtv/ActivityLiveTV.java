package com.mobile.dtv;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityLiveTV extends Activity {
    ListView list;
    public String[] ChannelName = {"ABS-CBN", "GMA", "TV5"};
    public String[] Epgtime = {"2:30 PM", "3:15 PM"};
    public String[] EpgEvent = {"Ikaw Lang", "Showtime"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__live__tv);
        initView();
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < ChannelName.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ChannelName", ChannelName[i]);
            map.put("Epg1Time", Epgtime[0]);
            map.put("Epg1Event", EpgEvent[0]);
            map.put("Epg2Time", Epgtime[1]);
            map.put("Epg2Event", EpgEvent[1]);
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this, listItem,//需要绑定的数据
                R.layout.item_channel,
                new String[]{"ChannelName", "Epg1Time", "Epg1Event", "Epg2Time", "Epg2Event"},
                new int[]{
            R.id.TextView_channel_name, R.id.TextView_channel_epg_time1, R.id.TextView_channel_epg_event1,
                        R.id.TextView_channel_epg_time2, R.id.TextView_channel_epg_event2}
            );
        list.setAdapter(mSimpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Toast.makeText(ActivityLiveTV.this,
                        ChannelName[arg2],Toast.LENGTH_LONG).show();
            }
        });
    }

    void initView() {
        list = (ListView) findViewById(R.id.ListView_channels);
    }
}
