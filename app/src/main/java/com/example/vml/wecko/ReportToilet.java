package com.example.vml.wecko;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ReportToilet extends AppCompatActivity {

    private Button cancelBtn;
    private Button sendBtn;
    private Button thankYouFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_toilet);

        cancelBtn = (Button)this.findViewById(R.id.btn_cancel_report);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        sendBtn = (Button)this.findViewById(R.id.btn_send_report);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_report)).setVisibility(View.GONE);
                (findViewById(R.id.content_thanks)).setVisibility(View.VISIBLE);
            }
        });

        thankYouFinish = (Button)this.findViewById(R.id.btn_thank_you_finish);
        thankYouFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}
