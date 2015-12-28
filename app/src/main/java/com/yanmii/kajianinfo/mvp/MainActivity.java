package com.yanmii.kajianinfo.mvp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yanmii.kajianinfo.R;
import com.yanmii.kajianinfo.mvp.populer.PopulerFragment;
import com.yanmii.kajianinfo.mvp.tag.TagFragment;
import com.yanmii.kajianinfo.mvp.terbaru.TerbaruFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    SectionPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(3);

        mTabs.setupWithViewPager(mPager);
        mTabs.setTabMode(TabLayout.MODE_FIXED);


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class SectionPagerAdapter extends FragmentPagerAdapter {

        TerbaruFragment terbaruFragment;
        PopulerFragment popularFragment;
        TagFragment tagFragment;

        String[] TAB_TITLES = new String[]{"Populer", "Terbaru", "Tag"};

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
            terbaruFragment = new TerbaruFragment();
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (terbaruFragment == null) terbaruFragment = new TerbaruFragment();
                    return terbaruFragment;
                case 1:
                    if (popularFragment == null) popularFragment = new PopulerFragment();
                    return popularFragment;

                case 2:
                    if (tagFragment == null) tagFragment = new TagFragment();
                    return tagFragment;
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_TITLES[position];
        }

        @Override
        public int getCount() {
            return TAB_TITLES.length;
        }
    }


}
