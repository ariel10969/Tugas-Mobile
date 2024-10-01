package com.example.fragmentbuttonactivity.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragmentbuttonactivity.R;
import com.example.fragmentbuttonactivity.fragment.BerandaFragment;
import com.example.fragmentbuttonactivity.fragment.PemberitahuanFragment;
import com.example.fragmentbuttonactivity.fragment.ProfileFragment;
import com.example.fragmentbuttonactivity.fragment.actifitas;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        loadFragment(new BerandaFragment());
        BottomNavigationView navigationView =findViewById(R.id.navigation);
        navigationView.setOnItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.fr_beranda);
    }

    private boolean loadFragment (Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int selected = item.getItemId();
        Fragment fragment = null;
        if (selected == R.id.fr_aktifitas) {
            fragment = new actifitas();
        } else if (selected == R.id.fr_beranda) {
            fragment = new BerandaFragment();
        } else if (selected == R.id.fr_pemberitahuan) {
            fragment = new PemberitahuanFragment();
        } else {
            fragment = new ProfileFragment();
        }

        return loadFragment(fragment);
    }
}