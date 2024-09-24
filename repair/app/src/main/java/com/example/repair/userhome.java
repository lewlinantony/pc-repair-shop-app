package com.example.repair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class userhome extends AppCompatActivity implements View.OnClickListener {
    Button bt,bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        bt=findViewById(R.id.button4);
        bt.setOnClickListener(this);
        bt1=findViewById(R.id.button5);
        bt1.setOnClickListener(this);
        bt2=findViewById(R.id.button7);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==bt){
            startActivity(new Intent(getApplicationContext(),date.class));
        }
        else if (view==bt1){

            startActivity(new Intent(getApplicationContext(),view_booking.class));
        }
        else if(view==bt2){
            startActivity(new Intent(getApplicationContext(),login.class));
        }




    }
}