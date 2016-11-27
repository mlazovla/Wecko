package com.example.vml.wecko;

import android.content.Intent;
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
import android.widget.RelativeLayout;

public class NearestToilet extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearest_toilet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        this.switchContentLayouts(R.id.content_nearest_toilet);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nearest_toilet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
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
            this.switchContentLayouts(R.id.content_add_toilet);
        } else if (id == R.id.nav_myToilet) {
            startActivity(new Intent(getApplicationContext(), NearestToilet.class));
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(getApplicationContext(), NearestToilet.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(getApplicationContext(), NearestToilet.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchContentLayouts(int idToEnable) {
        // Disable all contents
        (findViewById(R.id.content_nearest_toilet)).setVisibility(View.GONE);
        (findViewById(R.id.content_approve_toilet)).setVisibility(View.GONE);
        (findViewById(R.id.content_add_toilet)).setVisibility(View.GONE);

        // Enable choosed content
        (findViewById(idToEnable)).setVisibility(View.VISIBLE);
    }
}
