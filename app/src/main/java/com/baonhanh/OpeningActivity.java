package com.baonhanh;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class OpeningActivity extends AppCompatActivity {

    public static OpeningActivity instance = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        instance = this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isNetworkAvaiable()) {
                    Intent intent = new Intent(OpeningActivity.this,
                            NewspapersList.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_enter,
                            R.anim.zoom_exit);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            OpeningActivity.this);
                    builder.setTitle("Network no avaiable");
                    builder.setMessage("Please check the network connection!");
                    builder.setPositiveButton("Finish",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    finish();

                                }
                            });
                    builder.show();
                }
            }
        }, 2000);

    }

    private boolean isNetworkAvaiable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        Log.d("Network", (info != null) + "  " + info);
        return (info != null);
    }


}
