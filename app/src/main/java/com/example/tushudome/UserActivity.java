package com.example.tushudome;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tushudome.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;
    NavController navController =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    protected void onResume() {
        int fragmentFlag = this.getIntent().getIntExtra("fragment",0);
        switch (fragmentFlag){
            case 1:
                navController.navigate(R.id.navigation_home);
                break;
            case 2:
                navController.navigate(R.id.navigation_dashboard);
                break;
            case 3:
                navController.navigate(R.id.navigation_notifications);
                break;
        }
        super.onResume();
    }


}