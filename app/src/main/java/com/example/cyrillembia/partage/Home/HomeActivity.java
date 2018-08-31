package com.example.cyrillembia.partage.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cyrillembia.partage.R;
import com.example.cyrillembia.partage.Utils.BottomNavigationViewHelper;
import com.example.cyrillembia.partage.Utils.SectionsPagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;

    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: Demarrage.");

        setupBottomNavigationView();
        setupViewPager();
    }

            /**
            * Responsable de l'ajout des 3 onglets: Camera, Home, Messages
            */


            private void setupViewPager(){
                SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
                adapter.addFragment(new CameraFragment()); //index 0
                adapter.addFragment(new HomeFragment()); //index 1
                adapter.addFragment(new MessagesFragment()); //index 2
                ViewPager viewPager = (ViewPager) findViewById(R.id.container);
                viewPager.setAdapter(adapter);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
                tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
                tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
            }


    /**
     * Configuration de BottomNavigationView
     */
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: configuration de BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        //bottomNavigationViewEx.setItemBackgroundResource(R.drawable.transparent);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
