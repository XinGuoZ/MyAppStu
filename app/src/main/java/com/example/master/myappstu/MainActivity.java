package com.example.master.myappstu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences("stu",MODE_PRIVATE);
        String stunum=sharedPreferences.getString("stunum","");
        if (stunum.equals("")||stunum==null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    MainActivity.this.finish();
                }
            },1000);
        } else {
            startActivity(new Intent(MainActivity.this,index.class));
            MainActivity.this.finish();
        }

    }


}
