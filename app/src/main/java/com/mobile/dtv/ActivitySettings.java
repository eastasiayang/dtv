package com.mobile.dtv;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class ActivitySettings extends Activity {
    public String[] groupStrings = {"Channels", "System manage", "System log"};
    public String[][] childStrings = { {"Scan Channels"},
            {"Network setup", "Clear cache", "Exit App"},
            {"View log", "Get remote log"}};

    private ExpandableListView listview;
    private MyExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__settings);
        listview = (ExpandableListView) findViewById(R.id.ExpandableListView_settings);
        adapter = new MyExpandableListAdapter(this);
        listview.setAdapter(adapter);
    }

    private class MyExpandableListAdapter extends BaseExpandableListAdapter {
        private Context mContext;
        public MyExpandableListAdapter(Context c){
            mContext = c;
        }
        @Override
        public int getGroupCount() {
            return groupStrings.length;
        }

        //  获得某个父项的某个子项
        @Override
        public Object getChild(int parentPos, int childPos) {
            return childStrings[parentPos][childPos];
        }

        //  获得某个父项的子项数目
        @Override
        public int getChildrenCount(int parentPos) {
            return childStrings[parentPos].length;
        }

        //  获得某个父项
        @Override
        public Object getGroup(int parentPos) {
            return groupStrings[parentPos];
        }

        //  获得某个父项的id
        @Override
        public long getGroupId(int parentPos) {
            return parentPos;
        }

        //  获得某个父项的某个子项的id
        @Override
        public long getChildId(int parentPos, int childPos) {
            return childPos;
        }

        //  获得父项显示的view
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = View.inflate(mContext, R.layout.item_main_group, null);
            TextView title = (TextView) convertView.findViewById(R.id.textview_item_main_group_title);
            String s = groupStrings[groupPosition];
            title.setText(s);
            return convertView;
        }

        //  获得子项显示的view
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = View.inflate(mContext, R.layout.item_main_child, null);
            TextView title = (TextView) convertView.findViewById(
                    R.id.textview_item_main_child_title);
            title.setText(childStrings[groupPosition][childPosition]);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition,
                                         int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
