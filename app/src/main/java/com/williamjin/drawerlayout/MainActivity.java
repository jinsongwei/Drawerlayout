package com.williamjin.drawerlayout;

import android.app.FragmentManager;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.williamjin.drawerlayout.camera.CameraActivity;
import com.williamjin.drawerlayout.camera.CameraFragment;
import com.williamjin.drawerlayout.gallery.GalleryActivity;
import com.williamjin.drawerlayout.gallery.GalleryFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int activityFrequency;
    TextView tvFrequency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activityFrequency = 0;
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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // handle incoming intent for new same activity
        if (intent != null) {

            Bundle bundle = intent.getExtras();
            if(bundle == null)
                return;
            int number = bundle.getInt("frequencyOfActivity");
            tvFrequency = findViewById(R.id.tv_frequency_number);
            tvFrequency.setText(Integer.toString(number));
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        FragmentManager fragmentManager = getFragmentManager();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_camera:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new CameraFragment()).commit();
                break;
            case R.id.action_gallery:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new GalleryFragment()).commit();
                break;
            case R.id.action_video:
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame,
                                new VideoFragment()).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_camera_layout) {
            // Handle the camera action
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new CameraFragment()).commit();
        } else if (id == R.id.nav_gallery_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new GalleryFragment()).commit();
        } else if (id == R.id.nav_video_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,
                            new VideoFragment()).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void handleCameraBtn(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra("frequencyOfActivity", ++activityFrequency);
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(intent);
    }

    public void handleGalleryBtn(View view) {
        Intent intent = new Intent(this, GalleryActivity.class);
        intent.putExtra("frequencyOfActivity", ++activityFrequency);
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        startActivity(intent);
    }

    public void handleHomeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("frequencyOfActivity", ++activityFrequency);
        startActivity(intent);
    }
}
