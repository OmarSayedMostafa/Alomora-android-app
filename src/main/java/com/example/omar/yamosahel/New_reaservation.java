package com.example.omar.yamosahel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class New_reaservation extends ActionBarActivity {

    ArrayList<String> spinner_list1=new ArrayList<>();
    ArrayList<String> spinner_list2=new ArrayList<>();
    ArrayList<String> spinner_list3=new ArrayList<>();
    ArrayList<String> spinner_list4=new ArrayList<>();
    Spinner my_spinner1,my_spinner2,my_spinner3,my_spinner4;
    SpinnerAdapter adapt1,adapt2,adapt3,adapt4;
    TextView username;
    EditText enter_ur_pass;
    ImageButton magic_door;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reaservation);

        magic_door=(ImageButton)findViewById(R.id.magic_imageButton2);

        username=(TextView)findViewById(R.id.usernameee);
        username.setText(getIntent().getStringExtra("name"));

        enter_ur_pass=(EditText)findViewById(R.id.enterpass_edittext);

        my_spinner1=(Spinner)findViewById(R.id.spinner1);
        my_spinner2=(Spinner)findViewById(R.id.spinner2);
        my_spinner3=(Spinner)findViewById(R.id.spinner3);
        my_spinner4=(Spinner)findViewById(R.id.spinner4);
        spinner_list1.add("Target Places : Available Now");
        spinner_list1.add("Egypt");
        spinner_list1.add("France");
        spinner_list1.add("germany");
        adapt1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinner_list1);
        my_spinner1.setAdapter(adapt1);
        my_spinner1.animate();
        //*******************************************/
        spinner_list2.add("Home Place : Available Now ");
        spinner_list2.add("Egypt");
        spinner_list2.add("France");
        spinner_list2.add("Germany");
        adapt2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinner_list2);
        my_spinner2.setAdapter(adapt2);
        //**********************************//

        spinner_list3.add("Available Date ");
        spinner_list3.add("13/10/2016");
        spinner_list3.add("20/10/2016");
        spinner_list3.add("20/11/2016");
        adapt3=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinner_list3);
        my_spinner3.setAdapter(adapt3);
        //*******************************************/

        spinner_list4.add("Available time");
        spinner_list4.add("12:00 AM");
        spinner_list4.add("1:30 AM");
        spinner_list4.add("9:00 PM");
        spinner_list4.add("3:30 PM");
        adapt4=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,spinner_list4);

        my_spinner4.setAdapter(adapt4);

//***************************************//

        magic_door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(my_spinner1.getSelectedItem().toString().equals("Target Places : Available Now")||my_spinner2.getSelectedItem().toString().equals("Home Place : Available Now ")||my_spinner3.getSelectedItem().toString().equals("Available Date ")||my_spinner4.getSelectedItem().toString().equals("Available time") )
                {
                    Toast.makeText(getBaseContext(), "Make Sure You Entered Full Data", Toast.LENGTH_SHORT).show();
                }
                else if(enter_ur_pass.getText().toString().equals("")==true )
                {
                    Toast.makeText(getBaseContext(),"Enter Your Password please",Toast.LENGTH_SHORT).show();
                }
                else if(my_spinner1.getSelectedItem().toString().equals(my_spinner2.getSelectedItem().toString()))
                {
                    Toast.makeText(getBaseContext(),"YOU CHOOSE THE SAME MAGICAL DOOR YOU WILL NOT GO ANY Place",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(enter_ur_pass.getText().toString().equals(getIntent().getStringExtra("password"))==true)
                    {
                        Toast.makeText(getBaseContext(),"done",Toast.LENGTH_SHORT).show();
                        intent();
                    }
                    else
                    {

                        Toast.makeText(getBaseContext(), "password not correct", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }


    public void intent()
    {
        Intent I=new Intent(this,Continue.class);
        I.putExtra("username",username.getText().toString());
        I.putExtra("target",my_spinner1.getSelectedItem().toString());
        I.putExtra("home",my_spinner2.getSelectedItem().toString());
        I.putExtra("date",my_spinner3.getSelectedItem().toString());
        I.putExtra("time",my_spinner4.getSelectedItem().toString());

        startActivity(I);
    }

}



