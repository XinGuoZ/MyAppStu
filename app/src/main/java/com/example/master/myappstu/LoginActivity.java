package com.example.master.myappstu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.master.myappstu.entity.Student;
import com.example.master.myappstu.utils.HttpUtil;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private EditText stunum,stupwd;
    private Button btn;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String json= (String) msg.obj;
            after(json);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){
        initui();
        Student student=new Student();
        student.setStunum(stunum.getText().toString().trim());
        student.setStupwd(stupwd.getText().toString().trim());

        if (!"".equals(student.getStunum() )&&student.getStupwd()!=null) {
            new HttpUtil().doPost("app_stu_login",handler,new Gson().toJson(student));
        }else {
            Toast.makeText(LoginActivity.this,"账号密码不能为空",Toast.LENGTH_LONG).show();
        }
    }

    private void after(String json) {
        if(!json.equals("")&&json!=null){
            Student student=new Gson().fromJson(json,Student.class);
            Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor editor=getSharedPreferences("stu",MODE_PRIVATE).edit();
            editor.putInt("id",student.getId());
            editor.putString("stunum",student.getStunum());
            editor.putString("stuname",student.getStuname());
            editor.putString("stupwd",student.getStupwd());
            editor.putInt("classid",student.getClassid());
            editor.commit();
            startActivity(new Intent(LoginActivity.this,index.class));
            LoginActivity.this.finish();
        }else {
            Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
        }
    }
    private void initui() {
        stunum=findViewById(R.id.stunum);
        stupwd=findViewById(R.id.stupwd);
    }

}
