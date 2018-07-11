package com.example.master.myappstu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class Updatepwd extends AppCompatActivity {

    private EditText newpwd,cppwd;
    private Button save;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepwd);
        initui();
    }

    private void initui() {
        newpwd=findViewById(R.id.editTextpwd);
        cppwd=findViewById(R.id.cfppwd);
    }

    public void save(View view){
        String pwd=newpwd.getText().toString().trim();
        String cfpwd=cppwd.getText().toString().trim();
        SharedPreferences sharedPreferences=getSharedPreferences("stu",MODE_PRIVATE);
        student=new Student();
        student.setStupwd(pwd);
        student.setId(sharedPreferences.getInt("id",0));
        String json=new Gson().toJson(student);
        if(pwd.equals(cfpwd)&&!pwd.equals("")){
            new HttpUtil().Post("app_update_stu",json);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.commit();
            startActivity(new Intent(Updatepwd.this,LoginActivity.class));
            Updatepwd.this.finish();

        }else {
            Toast.makeText(Updatepwd.this,"输入合法信息",Toast.LENGTH_LONG).show();
        }

    }
}
