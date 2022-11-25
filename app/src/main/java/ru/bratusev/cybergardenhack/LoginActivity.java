package ru.bratusev.cybergardenhack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private CheckBox remember;
    private Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private Pattern VALID_PASS_REGEX =
            Pattern.compile("^[a-zA-Z0-9_]{8,32}+$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        findViews();
    }

    private void findViews() {
        remember = (CheckBox) findViewById(R.id.remember_me);
        if (getCheckFromPref()) {
            fillData();
        }
        findViewById(R.id.signIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput()) {
                    login();
                } else
                    Toast.makeText(getApplicationContext(), "Проверьте правильность введёных данных", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillData() {
        ((EditText) findViewById(R.id.signIn_email)).setText(getMailFromPref());
        ((EditText) findViewById(R.id.signIn_pass)).setText(getPassFromPref());
        remember.setChecked(getCheckFromPref());
    }

    private void login() {
        String mail = ((EditText) findViewById(R.id.signIn_email)).getText().toString();
        String pass = ((EditText) findViewById(R.id.signIn_pass)).getText().toString();
        if (remember.isChecked()) {
            saveData(mail, pass);
        }
        saveData(remember.isChecked());
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
    }

    private boolean checkInput() {
        String mail = ((EditText) findViewById(R.id.signIn_email)).getText().toString();
        String pass = ((EditText) findViewById(R.id.signIn_pass)).getText().toString();

        if (VALID_EMAIL_ADDRESS_REGEX.matcher(mail).find() && VALID_PASS_REGEX.matcher(pass).find())
            return true;
        return false;
    }

    @Override
    public void onBackPressed() {

    }

    private void saveData(String email, String password) {
        SharedPreferences sharedPref = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", email);
        editor.putString("pass", password);
        editor.apply();
    }

    private void saveData(Boolean remember) {
        SharedPreferences sharedPref = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("remember", remember);
        editor.apply();
    }

    private String getMailFromPref() {
        SharedPreferences sharedPref = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        return sharedPref.getString("email", "").toString();
    }

    private String getPassFromPref() {
        SharedPreferences sharedPref = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        return sharedPref.getString("pass", "").toString();
    }

    private boolean getCheckFromPref() {
        SharedPreferences sharedPref = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("remember", false);
    }
}