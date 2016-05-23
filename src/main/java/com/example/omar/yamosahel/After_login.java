package com.example.omar.yamosahel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class After_login extends ActionBarActivity {

    ImageButton profile_pic;
    TextView account_name;
    String name,pass;

   // DigitalClock my_date;
    ListView my_list;
    ArrayList<String> arr=new ArrayList<>();
    ListAdapter adapt;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        back=(Button)findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pass=getIntent().getStringExtra("password");
        name=getIntent().getStringExtra("name");


        profile_pic=(ImageButton)findViewById(R.id.account_imageButton);
        account_name=(TextView)findViewById(R.id.account_user_name);
        name=getIntent().getStringExtra("name");
        account_name.setText(name);
        //my_date=(DigitalClock)findViewById(R.id.digitalClock);
      //  my_date.animate();

        my_list=(ListView)findViewById(R.id.listView1);
        arr.add("View Available Places");
        arr.add("New Reservation");
        arr.add("Help Or Contact Us");
        adapt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        my_list.setAdapter(adapt);
        //****************************************************/

        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    intent(0);
                }
                else if (position==1)
                {
                    intent(1);
                }
                else
                {

                }

            }
        });



    }
    public void intent(int pos)
    {
        Intent i;
        if(pos==0)
        {
             i=new Intent(this,map.class);

            startActivity(i);
        }
        else if(pos==1)
        {
           i =new Intent(this,New_reaservation.class);
            i.putExtra("name",name);
            i.putExtra("password",pass);
            startActivity(i);
        }
        else
        {

        }

    }

}



