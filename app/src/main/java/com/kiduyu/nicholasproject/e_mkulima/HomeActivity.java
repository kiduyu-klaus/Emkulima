package com.kiduyu.nicholasproject.e_mkulima;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kiduyu.nicholasproject.e_mkulima.StatusBar.StatusBar;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.ActivityFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.BlogFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.ExpertsFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.ForumFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.HomeFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.ProfileFragment;
import com.kiduyu.nicholasproject.e_mkulima.UserFargments.ShopFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView txtActiontitle;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.changeStatusBarColor(this);
        setContentView(R.layout.activity_home);

        txtActiontitle = findViewById(R.id.txt_actiontitle);
        drawerLayout = findViewById(R.id.drawer_layout);
        circleImageView = findViewById(R.id.profile_image_message_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void callFragment(Fragment fragmentClass) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_frame, fragmentClass).addToBackStack("adds").commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    public void ClickNavigation(View view) {

        Fragment fragment;
        switch (view.getId()) {
            case R.id.img_close:
                onBackPressedd();
                break;
            case R.id.lvl_home:
                txtActiontitle.setText("Home");
                fragment = new HomeFragment();
                callFragment(fragment);
                break;
            case R.id.myprofile:
                txtActiontitle.setText("Profile");
                fragment = new ProfileFragment();
                callFragment(fragment);
                break;
            case R.id.experts:
                txtActiontitle.setText("Experts");
                fragment = new ExpertsFragment();
                callFragment(fragment);
                break;
            case R.id.forum:
                txtActiontitle.setText("Public Forum");
                Glide.with(this).load(R.drawable.ic_forum).into(circleImageView);
                RelativeLayout relativeLayout= findViewById(R.id.layoutid);
                relativeLayout.setBackgroundColor(Color.parseColor("#56BCEC"));
                fragment = new ForumFragment();
                callFragment(fragment);
                break;
            case R.id.blog:
                txtActiontitle.setText("Blog");
                fragment = new BlogFragment();
                callFragment(fragment);

                break;
            case R.id.activities:
                txtActiontitle.setText("My Activities");
                fragment = new ActivityFragment();
                callFragment(fragment);
                break;
            case R.id.shop:
                txtActiontitle.setText("Buy Goods");
                fragment = new ShopFragment();
                callFragment(fragment);

                break;
            case R.id.logout:

                break;

            case R.id.img_noti:
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
                break;
            case R.id.share:
                shareApp();
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void onBackPressedd() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void shareApp() {
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
            String shareMessage = "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch (Exception e) {
            //e.toString();
        }
    }


}