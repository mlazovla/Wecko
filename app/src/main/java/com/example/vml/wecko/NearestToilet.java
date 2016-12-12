package com.example.vml.wecko;

import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NearestToilet extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton mapButton;
    ImageButton compasButton;
    ImageButton swipeUpButton, swipeDownButton;
    ImageButton mapNav, compassNav;
    Button alertNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_toilet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout toiletImageSection = (LinearLayout) findViewById(R.id.toiletImageSection);
        toiletImageSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.content_nearest_toilet)).setVisibility(View.GONE);
                (findViewById(R.id.content_detail)).setVisibility(View.VISIBLE);
            }
        });

        //LinearLayout toiletInfoLeafs = (LinearLayout )findViewById(R.id.toiletInfo);
        final LinearLayout toiletInfoLeafs = (LinearLayout )findViewById(R.id.toiletInfo);
        final TextView toiletReview = (TextView) findViewById(R.id.toiletReview);
        toiletReview.setVisibility(View.INVISIBLE);

        toiletInfoLeafs.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if (toiletReview.getVisibility() ==  View.VISIBLE) {
                    toiletReview.setVisibility(View.INVISIBLE);
                    return;
                }
                if (toiletReview.getVisibility() ==  View.INVISIBLE) {
                    toiletReview.setVisibility(View.VISIBLE);
                    return;
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        this.switchContentLayouts(R.id.content_nearest_toilet);

        // Map button
        mapButton = (ImageButton)this.findViewById(R.id.btnNavMap);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.cz/maps/dir/50.0752982,14.4561334/Ve%C5%99ejn%C3%A9+WC,+Orlick%C3%A1,+130+00+Praha+3/@50.0764717,14.453885,17z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x470b9362bcbf46cd:0x8de28d810eb34686!2m2!1d14.4555697!2d50.0776336!3e2?hl=cs"));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        // Compas button
        compasButton = (ImageButton)this.findViewById(R.id.btnNavCompass);
        compasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Compass.class);
                startActivity(intent);
            }
        });

        // swipe up Button
        swipeUpButton = (ImageButton)this.findViewById(R.id.swipeUp);
        swipeUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchContentLayouts(R.id.content_detail);
            }
        });

        // swipe down Button
        swipeDownButton = (ImageButton)this.findViewById(R.id.swipeDown);
        swipeDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchContentLayouts(R.id.content_nearest_toilet);
            }
        });

        // map nav button in detail
        mapNav = (ImageButton)this.findViewById(R.id.mapNav);
        mapNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.cz/maps/dir/50.0752982,14.4561334/Ve%C5%99ejn%C3%A9+WC,+Orlick%C3%A1,+130+00+Praha+3/@50.0764717,14.453885,17z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x470b9362bcbf46cd:0x8de28d810eb34686!2m2!1d14.4555697!2d50.0776336!3e2?hl=cs"));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        // compass button in detail
        compassNav = (ImageButton)this.findViewById(R.id.compassNav);
        compassNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Compass.class);
                startActivity(intent);
            }
        });

        // report button in detail
        alertNav = (Button) this.findViewById(R.id.alertNav);
        alertNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReportToilet.class );
                startActivity(intent);
            }
        });


        Button approveButton = (Button)findViewById(R.id.btnApprove);
        Button disapproveButton = (Button)findViewById(R.id.btnDisapprove);
        View.OnClickListener approveListener = new View.OnClickListener() {
            int state;
            @Override
            public void onClick(View view) {
                ImageView aprImage = ((ImageView)findViewById(R.id.imgApprove));
                TextView toiletName = ((TextView)findViewById(R.id.lblToiletName));
                aprImage.setImageResource(0);
                state = (state + 1) % 3;
                switch (state)
                {
                    case 0: aprImage.setImageResource(R.drawable.toalety_karlovo_namesti);toiletName.setText("WC Karlovo náměstí");break;
                    case 1: aprImage.setImageResource(R.drawable.toilet_to_approve_2);toiletName.setText("WC Hlavní nádraží");break;
                    case 2: aprImage.setImageResource(R.drawable.toilet_to_approve_3);toiletName.setText("WC Strahov");break;
                }
            }
        };
        approveButton.setOnClickListener(approveListener);
        disapproveButton.setOnClickListener(approveListener);
    }

    @Override
    public void onResume ()
    {
        super.onResume();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        switchContentLayouts(R.id.content_nearest_toilet);
    }

    @Override
    public void onBackPressed ()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if ( (findViewById(R.id.content_nearest_toilet)).getVisibility() == View.GONE )
        {
            switchContentLayouts(R.id.content_nearest_toilet);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(0).setChecked(true);
        }

        else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_nearestToilet) {
            this.switchContentLayouts(R.id.content_nearest_toilet);
        } else if (id == R.id.nav_mapToilet) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.cz/maps/place/Ve%C5%99ejn%C3%A9+WC/@50.0776336,14.453381,17z/data=!3m1!4b1!4m5!3m4!1s0x470b9362bcbf46cd:0x8de28d810eb34686!8m2!3d50.0776336!4d14.4555697"));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
        } else if (id == R.id.nav_approve_toilet) {
            this.switchContentLayouts(R.id.content_approve_toilet);
        } else if (id == R.id.nav_addToilet) {
            Intent intent = new Intent(getApplicationContext(), AddToilet.class);
            startActivity(intent);
        } else if (id == R.id.nav_myToilet) {
            this.switchContentLayouts(R.id.content_my_toilets);
        } else if (id == R.id.nav_settings) {
            this.switchContentLayouts(R.id.content_settings);
        } else if (id == R.id.nav_about) {
            this.switchContentLayouts(R.id.content_about);
        } else if (id == R.id.nav_testRating) {
            Intent intent = new Intent(getApplicationContext(), RatingToilet.class);
            startActivity(intent);
        } else if (id == R.id.nav_testReport) {
            Intent intent = new Intent(getApplicationContext(), ReportToilet.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchContentLayouts(int idToEnable) {
        // Disable all contents
        (findViewById(R.id.content_nearest_toilet)).setVisibility(View.GONE);
        (findViewById(R.id.content_approve_toilet)).setVisibility(View.GONE);
//        (findViewById(R.id.content_add_toilet)).setVisibility(View.GONE);
        (findViewById(R.id.content_my_toilets)).setVisibility(View.GONE);
        (findViewById(R.id.content_settings)).setVisibility(View.GONE);
        (findViewById(R.id.content_about)).setVisibility(View.GONE);
        (findViewById(R.id.content_detail)).setVisibility(View.GONE);

        // Enable one content
        (findViewById(idToEnable)).setVisibility(View.VISIBLE);
    }
}
