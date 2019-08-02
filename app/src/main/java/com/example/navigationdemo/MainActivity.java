package com.example.navigationdemo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolBar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_planets:
                        Toast.makeText(MainActivity.this, "Planets Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_stars:
                        Toast.makeText(MainActivity.this, "Stars Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_Missions:
                        Toast.makeText(MainActivity.this, "Missions Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_exit:
                System.exit(0);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return  true;
    }

    private void setupToolBar() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout ,toolBar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();//ToolBar and Drawer Layout sync (Handle Drawer open and close event)
    }

}
