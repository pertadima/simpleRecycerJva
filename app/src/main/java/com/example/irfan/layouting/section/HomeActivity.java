package com.example.irfan.layouting.section;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.irfan.layouting.R;
import com.example.irfan.layouting.helper.BottomNavigationViewHelper;
import com.example.irfan.layouting.section.categories.FragmentCategories;
import com.example.irfan.layouting.section.home.FragmentHome;
import com.example.irfan.layouting.section.home.FragmentMain;

public class HomeActivity extends AppCompatActivity {

    private FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Fragment fragment = null;
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (!(currentFragment instanceof FragmentMain)) {
                        addFragment(new FragmentMain());
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if (!(currentFragment instanceof FragmentCategories)) {
                        addFragment(new FragmentCategories());
                    }
                    return true;
                case R.id.navigation_notifications:

                    return true;
                case R.id.profile:

                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, new FragmentMain());
        ft.commit();
    }

    private void addFragment(Fragment fragment) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}
