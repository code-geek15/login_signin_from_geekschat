package com.example.geekschat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //removing the taskbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login_or_signup);

        TextView rightsReservedTextView = findViewById(R.id.rightsReservedTextView);

        // Get the current year
        int currentYear = getCurrentYear();

        // Replace the placeholder with the current year
        String copyrightText = rightsReservedTextView.getText().toString().replace("%YEAR%", String.valueOf(currentYear));
        rightsReservedTextView.setText(copyrightText);

    }

    private int getCurrentYear() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date currentDate = new Date();
        return Integer.parseInt(yearFormat.format(currentDate));
    }

    public void userLogsIn(View view) {
        Intent intent = new Intent(Login.this, SignIn.class);
        startActivity(intent);
        // Optional: Finish the current activity to prevent going back to it
    }

    public void userRegisterIn(View view) {
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }
}