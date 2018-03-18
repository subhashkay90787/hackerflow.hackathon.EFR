package com.example.subhash.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Subhash on 16/03/2018.
 */

public class myprogres extends AsyncTask<Void,Integer,String> {
    Context tx;
    ProgressDialog pd;
    public myprogres(Context t) {
        tx = t;
    }
    @Override
    protected void onPreExecute() {
       pd=new ProgressDialog(tx);
       pd.setMessage("Please Wait...");
       pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       pd.setIndeterminate(true);
        pd.show();
    }


    @Override
    protected String doInBackground(Void... voids) {


           try {
               for(int i=0;i<5;i++)
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

        return "u";
    }

    @Override
    protected void onPostExecute(String s) {
        pd.dismiss();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tx);
        alertDialogBuilder.setMessage("You request has been accepted....Thanks for your help");
                alertDialogBuilder.setPositiveButton("Click here to get back on the map",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int arg1) {
                                dialogInterface.cancel();
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(0);
                            }
                        });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
