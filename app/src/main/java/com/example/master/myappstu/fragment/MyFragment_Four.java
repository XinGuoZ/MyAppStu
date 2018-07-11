package com.example.master.myappstu.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.myappstu.LoginActivity;
import com.example.master.myappstu.R;
import com.example.master.myappstu.Updatepwd;
import com.example.master.myappstu.entity.Student;
import com.google.gson.Gson;

public class MyFragment_Four extends Fragment implements View.OnClickListener{
    View view;
    private Button exit,clean,updatepwd;
    private TextView stunameinfo,stunuminfo,leaveall,adttendall;
    Student student;
    SharedPreferences sharedPreferences;
    public MyFragment_Four() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_4,container,false);
        Bundle bundle =getArguments();
        student=new Gson().fromJson(bundle.getString("info"),Student.class);
        sharedPreferences=getActivity().getSharedPreferences("stu", Context.MODE_PRIVATE);
        initui();
        leaveall.setText(student.getLevel().toString());
        adttendall.setText(student.getAttendance().toString());
        stunameinfo.setText(student.getStuname());
        stunuminfo.setText(student.getStunum());
        return view;
    }

    private void initui() {
        exit=view.findViewById(R.id.exit);
        clean=view.findViewById(R.id.clean);
        updatepwd=view.findViewById(R.id.updatepwd1);
        stunameinfo=view.findViewById(R.id.stunameinfo);
        stunuminfo=view.findViewById(R.id.stunuminfo);
        leaveall=view.findViewById(R.id.leaveall);
        adttendall=view.findViewById(R.id.adttendall);

        exit.setOnClickListener(this);
        clean.setOnClickListener(this);
        updatepwd.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.exit:
                    System.exit(0);
            break;
            case R.id.clean:
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.updatepwd1:
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                LayoutInflater inflater= LayoutInflater.from(getActivity());
                View Dialog=inflater.inflate(R.layout.cfpwd,null);
                final EditText pwd=Dialog.findViewById(R.id.fpwd);
                builder.setView(Dialog);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (pwd.getText().toString().trim().equals(student.getStupwd())){
                        startActivity(new Intent(getActivity(), Updatepwd.class));
                        getActivity().finish();}
                    }
                });
                builder.create().show();

             /*   SharedPreferences.Editor editor1=sharedPreferences.edit();
                editor1.clear();
                editor1.commit();*/
                //startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
}
