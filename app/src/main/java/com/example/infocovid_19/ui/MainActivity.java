package com.example.infocovid_19.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.infocovid_19.R;
import com.example.infocovid_19.ui.menu.menu_bantuan.BantuanFragment;
import com.example.infocovid_19.ui.menu.menu_informasi.InformasiFragment;
import com.example.infocovid_19.ui.menu.menu_kasus.KasusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
//        navigation.setItemIconTintList(null);

        loadFragment(new KasusFragment());
    }

    /**
     * Fragment
     **/
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    /**
     * Menu Bottom Navigation Drawer
     * */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_menu_kasus:
                fragment = new KasusFragment();
                break;
            case R.id.nav_menu_informasi:
                fragment = new InformasiFragment();
                break;
            case R.id.nav_menu_bantuan:
                fragment = new BantuanFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
