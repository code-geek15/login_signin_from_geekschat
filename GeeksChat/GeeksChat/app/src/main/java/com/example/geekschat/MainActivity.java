package com.example.geekschat;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //removing the taskbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        //getting the progressbar
        progressBar = findViewById(R.id.progressBar);

        //setting the loading duration
        int loadingDuration = 4000;

        //create a method that will switch to the next activity
        simulateLoading(loadingDuration);

    }

    private void simulateLoading(int loadingDuration) {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                // Progress is done loading, switch to the next activity
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish(); // Optional: Finish the current activity to prevent going back to it

            }

        },loadingDuration);

    }

    public void userRegisterIn(View view) {
    }

    public void userLogsIn(View view) {
    }

    public void Forget(View view)
    {
        Intent intent = new Intent(this,ForgetPassword.class );

        startActivity(intent);
    }
}