package com.digzdigital.eaglesconnect;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.digzdigital.eaglesconnect.fragments.ArchiveFragment;
import com.digzdigital.eaglesconnect.fragments.ContactsFragment;
import com.digzdigital.eaglesconnect.fragments.ForumFragment;
import com.digzdigital.eaglesconnect.fragments.HomeFragment;
import com.digzdigital.eaglesconnect.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getFragmentManager();
        Fragment homeFragment = new HomeFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, homeFragment)
                .commit();

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

        switch (item.getItemId()) {
            case R.id.action_settings:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_contacts:
            Fragment contactsFragment = new ContactsFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, contactsFragment)
                    .commit();
                break;
            case R.id.nav_forum:
                Fragment forumFragment = new ForumFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, forumFragment)
                        .commit();
                break;
            case R.id.nav_archive:
                Fragment archiveFragment = new ArchiveFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, archiveFragment)
                        .commit();
                break;
            case R.id.nav_home:
                Fragment homeFragment = new HomeFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, homeFragment)
                        .commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateContactFragment(String name, String entryYear, String gradYear, String location, String course, String email, String phone, int resId, String birthday){
        Fragment profileFragment = new ProfileFragment();

        Bundle data = new Bundle();
        data.putString("name", name);
        data.putString("entryYear", entryYear);
        data.putString("gradYear", gradYear);
        data.putString("location", location);
        data.putString("course", course);
        data.putString("email", email);
        data.putString("phone", phone);
        data.putInt("image", resId);
        data.putString("birthday", birthday);
        profileFragment.setArguments(data);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_frame, profileFragment);
        ft.commit();
    }
}
