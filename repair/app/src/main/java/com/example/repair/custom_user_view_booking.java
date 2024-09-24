package com.example.repair;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class custom_user_view_booking extends BaseAdapter {
    String[] cid, issue,date_time,status,bid;
    private Context context;
    Button b1;

    public custom_user_view_booking(Context applicationContext,String[]cid, String[] issue, String[] date_time, String[] status) {
        this.context = applicationContext;
        this.cid = cid;
        this.issue = issue;
        this.date_time = date_time;
        this.status = status;


    }

    @Override
    public int getCount() {
        return issue.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if(view==null)
        {
            gridView=new View(context);
            //gridView=inflator.inflate(R.layout.customview, null);
            gridView=inflator.inflate(R.layout.custom_user_view_booking,null);//same class name

        }
        else
        {
            gridView=(View)view;

        }
        TextView tv1=(TextView)gridView.findViewById(R.id.textView9 );
        TextView tv2=(TextView)gridView.findViewById(R.id.textView12);
        TextView tv3=(TextView)gridView.findViewById(R.id.textView11);
        ImageButton imgb=(ImageButton)gridView.findViewById(R.id.imageButton);
        imgb.setTag(cid[i]);
        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context);
                SharedPreferences.Editor ed = sh.edit();
                ed.putString("cid",view.getTag().toString());

                ed.commit();
                Intent ij=new Intent(context,Test.class);
                ij.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(ij);
            }
        });

        Button tv6=(Button)gridView.findViewById(R.id.button3);





        tv1.setTextColor(Color.BLACK);//color setting
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);



        tv1.setText(issue[i]);
        tv2.setText(date_time[i]);
        tv3.setText(status[i]);


        tv6.setTag(cid[i]);
        // Load image using Picasso

//
        SharedPreferences sh=PreferenceManager.getDefaultSharedPreferences(context);
        // Load image using Picasso




        // Set OnClickListener for the button
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the tid associated with the clicked button
                String clickedTid = (String) v.getTag();

                // Call your function with the tid
                handleButtonClick(clickedTid);
            }
        });

        return gridView;

    }
    private void handleButtonClick(String bid) {
        Toast.makeText(context, bid, Toast.LENGTH_SHORT).show();
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor ed = sh.edit();
        ed.putString("bid",bid);
        ed.commit();
        Intent u=new Intent(context,adding_additional_payment.class);
        u.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(u);
    }


}