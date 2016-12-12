package com.example.vml.wecko;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AddToilet extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_toilet);
        ((CheckBox)findViewById(R.id.cbFree)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                LinearLayout lPrice = (LinearLayout) findViewById(R.id.layoutPrice);
                if (lPrice.isShown())
                    lPrice.setVisibility(View.GONE);
                else
                    lPrice.setVisibility(View.VISIBLE);
            }
        });
        (findViewById(R.id.imgMapGPSSelector)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText)findViewById(R.id.txtToiletCoordinates)).setText("50.075915, 14.420579");
                ImageView mapImage = ((ImageView)findViewById(R.id.imgMapGPSSelector));
                mapImage.setImageResource(0);
                mapImage.setImageResource(R.drawable.add_toilet_map_clicked);
                mapImage.setScaleType(ImageView.ScaleType.FIT_START);
            }
        });

        View.OnClickListener addListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed ();
            }
        };
        findViewById(R.id.btnCancelAdd).setOnClickListener(addListener);
        findViewById(R.id.btnAcceptAdd).setOnClickListener(addListener);
    }

}
