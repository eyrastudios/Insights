package com.example.insight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private static final int Activity_Num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);





        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                case R.id.navigation_home:

                    break;
                case R.id.navigation_library:
                    Intent intent2 = new Intent(homeActivity.this, libraryActivity.class);
                        startActivity(intent2);
                    break;
                case R.id.navigation_search:
                    Intent intent3 = new Intent(homeActivity.this,exploreActivity.class);
                        startActivity(intent3);
                    break;
                case R.id.navigation_settings:
                    Intent intent4 = new Intent(homeActivity.this,settingsActivity.class);
                    startActivity(intent4);
                    break;
                }

                return false;
            }
        });

    }
    private void setupButtomNavigationView(){
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(Activity_Num);
        menuItem.setChecked(true);
    }

}
