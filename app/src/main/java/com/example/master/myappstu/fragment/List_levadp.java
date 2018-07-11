package com.example.master.myappstu.fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.master.myappstu.R;
import com.example.master.myappstu.entity.Leave;

import java.util.List;


/**
 * Created by master on 2017/11/8.
 */

public class List_levadp extends BaseAdapter {
    private Context context;
    private List<Leave> list;
    private LayoutInflater layoutInflater;

    public List_levadp(Context context, List<Leave> list) {
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
            convertView = layoutInflater.inflate(R.layout.list_lel, null);
            viewHolder.time = convertView.findViewById(R.id.time);
            viewHolder.context = convertView.findViewById(R.id.text);
            viewHolder.lstate=convertView.findViewById(R.id.lstate);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Leave leave = list.get(position);
        viewHolder.time.setText(leave.getTime());
        viewHolder.context.setText(leave.getLeavecontext());
        if(leave.getLeavstate()==0){
            viewHolder.lstate.setText("已提交");
        }else if(leave.getLeavstate()==1){
            viewHolder.lstate.setText("批准");
        }else if(leave.getLeavstate()==2){
            viewHolder.lstate.setText("已拒绝");
        }else if(leave.getLeavstate()==3){
            viewHolder.lstate.setText("已完成");
        }else {viewHolder.lstate.setText("未完成");}
        return convertView;
    }

    private static class ViewHolder {
        public TextView time;
        public TextView lstate;
        public TextView context;

    }
}
