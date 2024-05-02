package com.example.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_home extends AppCompatActivity {


    Button btn_logout;
    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn_logout = findViewById(R.id.logout_button);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Intent intent = new Intent(activity_home.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(activity_home.this, "Logout sukses cuy", Toast.LENGTH_SHORT).show();
            }
        });
    }
}