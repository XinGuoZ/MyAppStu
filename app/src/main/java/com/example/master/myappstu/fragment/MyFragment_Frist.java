package com.example.master.myappstu.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.myappstu.R;
import com.example.master.myappstu.entity.Leave;
import com.example.master.myappstu.entity.StunameVo;
import com.example.master.myappstu.index;
import com.example.master.myappstu.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MyFragment_Frist extends Fragment {

    Button save,select;
    EditText context;
    List<StunameVo> list;
    View view;
    StunameVo stunameVo;
    public MyFragment_Frist() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_1,container,false);
        Bundle bundle=getArguments();
        initui();
        list=new Gson().fromJson(bundle.getString("listdata"),new TypeToken<List<StunameVo>>(){}.getType());
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater= LayoutInflater.from(getActivity());
                View Dialog=inflater.inflate(R.layout.list_adp,null);
                List_classadp list_classadp=new List_classadp(getActivity(),list);
                ListView listView=Dialog.findViewById(R.id.list_kc);
                listView.setAdapter(list_classadp);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        stunameVo=list.get(i);
                    }
                });
                new AlertDialog.Builder(getActivity())
                        .setMessage("请假")
                        .setView(Dialog)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                select.setText(stunameVo.getTeaname()+"-"+stunameVo.getCoursename());
                            }
                        })
                        .create().show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!stunameVo.getTeanum().equals("")&&stunameVo.getTeanum()!=null&&!context.getText().toString().equals("")){
                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("stu", Context.MODE_PRIVATE);
                    Leave leave=new Leave();
                    leave.setLeavecontext(context.getText().toString());
                    leave.setTeanum(stunameVo.getTeanum());
                    leave.setStuname(sharedPreferences.getString("stuname",""));
                    leave.setStunum(sharedPreferences.getString("stunum",""));
                    new HttpUtil().Post("app_leave_add",new Gson().toJson(leave));
                    Toast.makeText(getActivity(),"提交成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(),index.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(),"请填写信息",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @SuppressLint("WrongViewCast")
    private void initui() {
        context =view.findViewById(R.id.leaveContext);
        select=view.findViewById(R.id.sel);
        save=view.findViewById(R.id.save);

    }

}
