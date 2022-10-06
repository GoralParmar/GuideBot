package com.example.guidebot;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainAdapter extends BaseExpandableListAdapter {
//Initialize variable
    private Context context;
    private List<String> listTitle;
    private Map<String, List<String>> listItem;

    public MainAdapter(List<String> listTitle, Map<String, List<String>> listItem)
    {
        this.context = context;
        this.listTitle = listTitle;
        this.listItem = listItem;
    }



    //create constructor


    public int getGroupCount() {

        //return group list size
        return listTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        //return child list size
        return listItem.size();
    }

    @Override
    public Object getGroup(int groupposition) {
        //return group item
        return listTitle.get(groupposition);
    }

    @Override
    public Object getChild(int groupposition, int childposition) {
        //return chile item
        return listItem.get(listTitle.get(groupposition)).get(childposition);
    }

    @Override
    public long getGroupId(int groupposition) {
        return groupposition;
    }

    @Override
    public long getChildId(int groupposition, int childposition) {
        return childposition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupposition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)getGroup(groupposition);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.group,null);

        }
        TextView textTitle = (TextView)convertView.findViewById(R.id.ListTitle);
        textTitle.setTypeface(null,Typeface.BOLD);
        textTitle.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupposition, int childposition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String)getChild(groupposition,childposition);
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.group,null);

        }
        TextView textChild = (TextView)convertView.findViewById(R.id.ListItem);
//        textChild.setTypeface(null,Typeface.BOLD);
        textChild.setText(title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupposition, int childposition) {

        return true;
    }
}

