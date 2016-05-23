package com.example.omar.yamosahel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Continue extends ActionBarActivity {
TextView tital,targetc,homec,datec,timec,a,b,c,d,e,username;
    EditText serilano;
    RadioButton payon,serialk;
    Button done,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);

        username=(TextView)findViewById(R.id.user_textView);
        username.setText(getIntent().getStringExtra("username"));

        a=(TextView)findViewById(R.id.a);
       b=(TextView)findViewById(R.id.b);
        c=(TextView)findViewById(R.id.c);
       d=(TextView)findViewById(R.id.d);
        e=(TextView)findViewById(R.id.e);

        tital=(TextView)findViewById(R.id.titaltext);

        targetc=(TextView)findViewById(R.id.target_text);
        targetc.setText("Your Target Door "+getIntent().getStringExtra("target"));

        homec=(TextView)findViewById(R.id.home_text);
        homec.setText("Your Home Door "+getIntent().getStringExtra("home"));

        datec=(TextView)findViewById(R.id.date_text);
        datec.setText("Your Reservation Date "+getIntent().getStringExtra("date"));

        timec=(TextView)findViewById(R.id.time_text);
        timec.setText("Your Reservation Time "+getIntent().getStringExtra("time"));

        payon=(RadioButton)findViewById(R.id.pay_on_radioButton);
        serialk=(RadioButton)findViewById(R.id.serial_radioButton);

        done=(Button)findViewById(R.id.confirm_button);
        cancel=(Button)findViewById(R.id.cancel_button);

        serilano=(EditText)findViewById(R.id.serial_no_editText);
        serilano.setEnabled(false);
       // serilano.setFocusable(false);

        payon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(serialk.isChecked())
                {
                    serialk.setChecked(false);
                    serilano.setEnabled(false);
                    //serilano.setFocusable(false);

                }
            }
        });
        serialk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(payon.isChecked())
                {
                    payon.setChecked(false);
                }
                serilano.setEnabled(true);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payon.isChecked()==false && serialk.isChecked()==false)
                {
                    Toast.makeText(getBaseContext(), "Please Choose Your Prefered Way To Pay ", Toast.LENGTH_LONG).show();
                }
                else {
                    if(payon.isChecked()==true)
                    {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("http://www.google.com"));
                        startActivity(intent);
                    }
                    else
                    {
                        //go to Our company server to check the serial number
                    }
                }
            }
        });
    }


}
