package com.example.vml.wecko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RatingToilet extends AppCompatActivity {

    Button btnToiletOk, btnClean1, btnClean2, btnClean3, btnClean4, btnFinish, btnReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        // STEP 1
        btnToiletOk = (Button)this.findViewById(R.id.btn_toiletOk);
        btnToiletOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_1)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_2)).setVisibility(View.VISIBLE);
            }
        });
        btnReport = (Button)this.findViewById(R.id.btn_report);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReportToilet.class);
                startActivity(intent);
            }
        });

        // STEP 2
        btnClean1 = (Button)this.findViewById(R.id.btn_clean1);
        btnClean1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_3)).setVisibility(View.VISIBLE);
            }
        });
        btnClean2 = (Button)this.findViewById(R.id.btn_clean2);
        btnClean2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_3)).setVisibility(View.VISIBLE);
            }
        });
        btnClean3 = (Button)this.findViewById(R.id.btn_clean3);
        btnClean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_3)).setVisibility(View.VISIBLE);
            }
        });
        btnClean4 = (Button)this.findViewById(R.id.btn_clean4);
        btnClean4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_3)).setVisibility(View.VISIBLE);
            }
        });

        // STEP 3
        btnFinish = (Button)this.findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (findViewById(R.id.content_ratings_3)).setVisibility(View.GONE);
                (findViewById(R.id.content_ratings_1)).setVisibility(View.VISIBLE);
                // TODO --> Thank you page --> Toilet Details
                Intent intent = new Intent(getApplicationContext(), NearestToilet.class);
                startActivity(intent);
            }
        });

        //  Make page numbers clickable
        (findViewById(R.id.textView16)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_1);
            }
        });

        (findViewById(R.id.textView17)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_2);
            }
        });

        (findViewById(R.id.textView18)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_3);
            }
        });

        (findViewById(R.id.textView21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_1);
            }
        });
        (findViewById(R.id.textView22)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_2);
            }
        });
        (findViewById(R.id.textView23)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_3);
            }
        });
        (findViewById(R.id.textView31)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_1);
            }
        });
        (findViewById(R.id.textView32)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_2);
            }
        });
        (findViewById(R.id.textView33)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchContentLayouts(R.id.content_ratings_3);
            }
        });
    }

    @Override
    public void onBackPressed ()
    {
        if ((findViewById(R.id.content_ratings_2)).getVisibility() == View.VISIBLE) {
            (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
            (findViewById(R.id.content_ratings_1)).setVisibility(View.VISIBLE);
        }
        else if ((findViewById(R.id.content_ratings_3)).getVisibility() == View.VISIBLE)
        {
            (findViewById(R.id.content_ratings_3)).setVisibility(View.GONE);
            (findViewById(R.id.content_ratings_2)).setVisibility(View.VISIBLE);
        }

        else {
            super.onBackPressed();
        }
    }

    private void switchContentLayouts(int idToEnable) {
        // Disable all contents
        (findViewById(R.id.content_ratings_1)).setVisibility(View.GONE);
        (findViewById(R.id.content_ratings_2)).setVisibility(View.GONE);
        (findViewById(R.id.content_ratings_3)).setVisibility(View.GONE);

        // Enable one content
        (findViewById(idToEnable)).setVisibility(View.VISIBLE);
    }
}
