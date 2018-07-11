package com.example.master.myappstu.fragment;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.master.myappstu.R;
import com.example.master.myappstu.entity.Attendance;
import com.example.master.myappstu.entity.Leave;
import com.example.master.myappstu.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MyFragment_three extends Fragment {

    HttpUtil httpUtil;
    Button btn1,btn2;
    View view;
    SharedPreferences sharedPreferences;
    ListView listView;
    List<Leave> list;
    List<Attendance> listdata;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String json= (String) msg.obj;
            after(json);
        }
    };
    Handler handler1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String json= (String) msg.obj;
            after1(json);
        }
    };




    public MyFragment_three() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layoutfragment_three,container,false);
        sharedPreferences=getActivity().getSharedPreferences("stu", Context.MODE_PRIVATE);
        listView=view.findViewById(R.id.list_leave);
        httpUtil=new HttpUtil();
        init();
        return view;
    }

    private void init() {
        btn1=view.findViewById(R.id.leave1);
        btn2=view.findViewById(R.id.abs1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                httpUtil.doGet("app_stukq_all?stunum="+sharedPreferences.getString("stunum",""),handler);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                httpUtil.doGet("app_stukqa_all?stunum="+sharedPreferences.getString("stunum",""),handler1);

            }
        });
    }

    private void after(String json) {
        list=new Gson().fromJson(json,new TypeToken< List<Leave>>(){}.getType());
        List_levadp list_levadp=new List_levadp(getActivity(),list);
        listView.setAdapter(list_levadp);
    }
    private void after1(String json) {
        listdata=new Gson().fromJson(json,new TypeToken< List<Attendance>>(){}.getType());
        List_absadp list_levadp=new List_absadp(getActivity(),listdata);
        listView.setAdapter(list_levadp);
    }


}
