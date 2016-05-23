package com.example.omar.yamosahel;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends ActionBarActivity {
    DB db=new DB(this);
    boolean found=false;
    //*******************//

    public class task extends AsyncTask<Integer,Integer,Integer>
    {
        ProgressDialog pd=new ProgressDialog(Login.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("Loading...");
            pd.setMessage("Please wait...");
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.show();

        }

        @Override
        protected Integer doInBackground(Integer... params)
        {
            if( db.search(temp_name,temp_pass)==true)
            {
                Log.e("asynck task","here");
                return  1;
            }
            publishProgress();
            return  0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pd.incrementProgressBy(1);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            pd.dismiss();
        }
    }


    task t;
    EditText username,password;
    Button login,register;
    TextView or;
    /* DB db=new DB(this);*/
    String temp_name,temp_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.login_user_edittext);
        password = (EditText) findViewById(R.id.login_pass_edittext);
        or = (TextView) findViewById(R.id.or_textview);
        login = (Button) findViewById(R.id.login_button);
        register = (Button) findViewById(R.id.reg_butt_1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp_name=username.getText().toString();
                temp_pass=password.getText().toString();
                if(temp_pass.equals("")==true || temp_name.equals("")==true)
                {
                    Toast.makeText(getBaseContext(), "Please Enter UserName and PassWord", Toast.LENGTH_LONG).show();
                }
                else
                {
                    task t=new task();
                    t.execute();

                    if (t.doInBackground()==1)
                    {
                        Log.e("search","true");
                        Toast.makeText(getBaseContext(),"WELCOME",Toast.LENGTH_LONG).show();
                        home();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"not working",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_to_register();
            }
        });
    }

    public void go_to_register()
    {
        Intent I=new Intent(this,SignUp.class);
        startActivity(I);
    }
    public void home()
    {
        Intent i=new Intent(this,After_login.class);
        i.putExtra("name",temp_name);
        i.putExtra("password",temp_pass);
        startActivity(i);
    }



}
