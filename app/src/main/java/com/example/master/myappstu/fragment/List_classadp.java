package com.example.master.myappstu.fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.master.myappstu.R;
import com.example.master.myappstu.entity.StunameVo;

import java.util.List;



/**
 * Created by master on 2017/11/8.
 */

public class List_classadp extends BaseAdapter {
    private Context context;
    private List<StunameVo> list;
    private LayoutInflater layoutInflater;

    public List_classadp(Context context, List<StunameVo> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_kc,null);
            viewHolder.coursename = convertView.findViewById(R.id.course_tea);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        StunameVo stunameVo = list.get(position);
        viewHolder.coursename.setText(stunameVo.getCoursename()+"-"+stunameVo.getTeaname());
        return convertView;
    }

    private static class ViewHolder {
        public TextView coursename;

    }
}
