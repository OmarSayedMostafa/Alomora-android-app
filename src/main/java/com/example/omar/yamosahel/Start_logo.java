package com.example.omar.yamosahel;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class Start_logo extends ActionBarActivity {


    public class task extends AsyncTask<Integer,Integer,Integer>
    {

        @Override
        protected Integer doInBackground(Integer... params)
        {
            try {

                for (int i=0;i<100;i++)
                {
                    Thread.sleep(50);
                }

                Log.e("sleep"," sleep");
                login();
            }
            catch (Exception e)
            {
                Log.e("error","can't sleep");
            }
            return  null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_logo);
        new task().execute(0);

    }



    public void login()

    {
        Intent I=new Intent(this,Login.class);
        startActivity(I);
    }
}
