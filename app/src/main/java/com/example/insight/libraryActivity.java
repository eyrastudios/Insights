package com.example.insight;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class libraryActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private static final int Activity_Num = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(libraryActivity.this, homeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.navigation_library:

                        break;
                    case R.id.navigation_search:
                        Intent intent3 = new Intent(libraryActivity.this,exploreActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.navigation_settings:
                        Intent intent4 = new Intent(libraryActivity.this,settingsActivity.class);
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
