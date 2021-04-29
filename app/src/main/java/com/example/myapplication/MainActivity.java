package com.example.myapplication;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.myapplication.monhoc.DiaLyFragment;
import com.example.myapplication.monhoc.GDCDFragment;
import com.example.myapplication.monhoc.LichSuFragment;
import com.example.myapplication.monhoc.SinhFragment;
import com.example.myapplication.monhoc.TAFragment;
import com.example.myapplication.monhoc.ToanHocFragment;
import com.example.myapplication.monhoc.TrangChuFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        TrangChuFragment trangChuFragment = new TrangChuFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, trangChuFragment, trangChuFragment.getTag()).commit();

        NavigationView drawer1 = findViewById(R.id.nav_view);
        drawer1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem item){
                int id = item.getItemId();
                if(id == R.id.home) {
                    TrangChuFragment trangChuFragment = new TrangChuFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, trangChuFragment, trangChuFragment.getTag()).commit();
                } else if(id == R.id.monta){
                    TAFragment taFragment = new TAFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, taFragment, taFragment.getTag()).commit();

                }else if(id == R.id.montoan){
                    ToanHocFragment toanHocFragment = new ToanHocFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, toanHocFragment, toanHocFragment.getTag()).commit();
                } else if(id == R.id.monhoa){
                    LichSuFragment lichSuFragment = new LichSuFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, lichSuFragment, lichSuFragment.getTag()).commit();

                } else if(id == R.id.monly){
                    DiaLyFragment diaLyFragment = new DiaLyFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, diaLyFragment, diaLyFragment.getTag()).commit();
                } else if(id == R.id.monsinh){
                    SinhFragment sinhFragment = new SinhFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, sinhFragment, sinhFragment.getTag()).commit();
                } else if(id == R.id.mongdcd){
                    GDCDFragment gdcdFragment = new GDCDFragment();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, gdcdFragment, gdcdFragment.getTag()).commit();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}