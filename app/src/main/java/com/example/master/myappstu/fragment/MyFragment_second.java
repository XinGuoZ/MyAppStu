package com.example.master.myappstu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.myappstu.R;
import com.example.master.myappstu.entity.Course;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;



public class MyFragment_second extends Fragment {
    private TextView txt11,txt12,txt13,txt14,txt15;
    private TextView txt21,txt22,txt23,txt24,txt25;
    private TextView txt31,txt32,txt33,txt34,txt35;
    private TextView txt41,txt42,txt43,txt44,txt45;
    View view;
    public MyFragment_second() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_second, container, false);
        initui();
        Bundle bundle =getArguments();
        List<Course> list=new Gson().fromJson(bundle.getString("list_cur"), new TypeToken<List<Course>>() {}.getType());

        if (list.size()>0) {
            for (Course c:list) {
                if(c.getCorder()==1&&c.getCday()==1)txt11.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==1&&c.getCday()==2)txt12.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==1&&c.getCday()==3)txt13.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==1&&c.getCday()==4)txt14.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==1&&c.getCday()==5)txt15.setText(c.getAddr()+"-"+c.getCoursename());

                if(c.getCorder()==2&&c.getCday()==1)txt21.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==2&&c.getCday()==2)txt22.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==2&&c.getCday()==3)txt23.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==2&&c.getCday()==4)txt24.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==2&&c.getCday()==5)txt25.setText(c.getAddr()+"-"+c.getCoursename());

                if(c.getCorder()==3&&c.getCday()==1)txt31.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==3&&c.getCday()==2)txt32.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==3&&c.getCday()==3)txt33.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==3&&c.getCday()==4)txt34.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==3&&c.getCday()==5)txt35.setText(c.getAddr()+"-"+c.getCoursename());

                if(c.getCorder()==4&&c.getCday()==1)txt41.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==4&&c.getCday()==2)txt42.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==4&&c.getCday()==3)txt43.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==4&&c.getCday()==4)txt44.setText(c.getAddr()+"-"+c.getCoursename());
                if(c.getCorder()==4&&c.getCday()==5)txt45.setText(c.getAddr()+"-"+c.getCoursename());
            }
        }
        return view;
    }

    private void initui() {
        txt11=view.findViewById(R.id.tx11);
        txt12=view.findViewById(R.id.tx12);
        txt13=view.findViewById(R.id.tx13);
        txt14=view.findViewById(R.id.tx14);
        txt15=view.findViewById(R.id.tx11);

        txt21=view.findViewById(R.id.tx21);
        txt22=view.findViewById(R.id.tx22);
        txt23=view.findViewById(R.id.tx23);
        txt24=view.findViewById(R.id.tx24);
        txt25=view.findViewById(R.id.tx21);

        txt31=view.findViewById(R.id.tx31);
        txt32=view.findViewById(R.id.tx32);
        txt33=view.findViewById(R.id.tx33);
        txt34=view.findViewById(R.id.tx34);
        txt35=view.findViewById(R.id.tx31);

        txt41=view.findViewById(R.id.tx41);
        txt42=view.findViewById(R.id.tx42);
        txt43=view.findViewById(R.id.tx43);
        txt44=view.findViewById(R.id.tx44);
        txt45=view.findViewById(R.id.tx41);
    }


}
