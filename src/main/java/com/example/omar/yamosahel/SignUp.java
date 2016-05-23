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
import android.widget.Toast;


public class SignUp extends ActionBarActivity {

    public class my_task extends AsyncTask<Integer,Integer,Integer>
    {
        ProgressDialog pd=new ProgressDialog(SignUp.this);
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
            if( db.search_primary(temp_n)==true)
            {
                Log.e("asynck task register", " work here");
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
    DB db=new DB(this);
    String temp_n,temp_p,temp_cp,temp_e;
    EditText name,pass,con_pass,Email;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=(EditText)findViewById(R.id.reg_name);
        pass=(EditText)findViewById(R.id.reg_pass);
        con_pass=(EditText)findViewById(R.id.reg_con_pass);
        Email=(EditText)findViewById(R.id.email_editText);
        register=(Button)findViewById(R.id.reg_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp_n=name.getText().toString();
                temp_p=pass.getText().toString();
                temp_cp=con_pass.getText().toString();
                temp_e=Email.getText().toString();
                if(temp_n.equals("")==true || temp_p.equals("")==true || temp_cp.equals("")==true || temp_e.equals("")==true)
                {
                    Toast.makeText(getBaseContext(), "Please Enter UserName and PassWord and Email", Toast.LENGTH_LONG).show();
                }
                else if(temp_p.equals(temp_cp)==false)
                {
                    Toast.makeText(getBaseContext(), "Password Not Matching", Toast.LENGTH_LONG).show();
                    pass.setText("");
                    con_pass.setText("");
                }
                else
                {
                   my_task t=new my_task();
                    t.execute(0);
                    if(t.doInBackground()==1)
                    {
                        Toast.makeText(getBaseContext(), "Un Available User Name Change It", Toast.LENGTH_LONG).show();
                        name.setText("");
                        pass.setText("");
                        con_pass.setText("");
                        Email.setText("");
                    }
                    else
                    {
                        db.add_into_login(temp_n, temp_p, temp_e);
                        intent();
                    }

                }
            }
        });

    }
    public void intent()
    {
        Intent I=new Intent(this,After_login.class);
        I.putExtra("name",temp_n);
        I.putExtra("password", temp_p);
        startActivity(I);
    }


}
