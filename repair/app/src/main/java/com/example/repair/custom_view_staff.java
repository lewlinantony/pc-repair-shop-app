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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class custom_view_staff extends BaseAdapter  {
    String[] sid,fn,ln,eid,p,ph,photo,specialization;
    private Context context;
    Button b1;

    public custom_view_staff(Context applicationContext, String[] sid, String[] fn, String[] ln, String[] eid, String[] p, String[] ph, String[] specialization, String[] photo) {
        this.context = applicationContext;
        this.sid = sid;
        this.fn = fn;
        this.ln = ln;
        this.eid = eid;
        this.p = p;
        this.ph = ph;
        this.specialization = specialization;
        this.photo = photo;

    }

    @Override
    public int getCount() {
        return fn.length;
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
            gridView=inflator.inflate(R.layout.custom_view_staff,null);//same class name

        }
        else
        {
            gridView=(View)view;

        }
        ImageView tv7=(ImageView)gridView.findViewById(R.id.imageView2);
        TextView tv1=(TextView)gridView.findViewById(R.id.textView9 );
        TextView tv2=(TextView)gridView.findViewById(R.id.textView12);
        TextView tv3=(TextView)gridView.findViewById(R.id.textView11);
        TextView tv4=(TextView)gridView.findViewById(R.id.textView8);
        TextView tv5=(TextView)gridView.findViewById(R.id.textView10);
        TextView tv8=(TextView)gridView.findViewById(R.id.textView3);



        Button tv6=(Button)gridView.findViewById(R.id.button3);





        tv1.setTextColor(Color.BLACK);//color setting
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
        tv4.setTextColor(Color.BLACK);
        tv5.setTextColor(Color.BLACK);
        tv8.setTextColor(Color.BLACK);




        tv1.setText(fn[i]);
        tv2.setText(ln[i]);
        tv3.setText(eid[i]);
        tv4.setText(p[i]);
        tv5.setText(ph[i]);
        tv8.setText(specialization[i]);


        tv6.setTag(sid[i]);

        // Load image using Picasso

//
        SharedPreferences sh=PreferenceManager.getDefaultSharedPreferences(context);
        // Load image using Picasso

        String imgUrl = sh.getString("url", "") + photo[i]; //viewing image
        Picasso.with(context).load(imgUrl).into(tv7);



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
    private void handleButtonClick(String sid) {
        Toast.makeText(context, sid, Toast.LENGTH_SHORT).show();
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor ed = sh.edit();
        ed.putString("gid",sid);
        ed.commit();
        Intent u=new Intent(context,make_payment.class);
        u.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(u);
    }


}