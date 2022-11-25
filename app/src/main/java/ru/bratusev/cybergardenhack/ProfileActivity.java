package ru.bratusev.cybergardenhack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView userImage;
    private TextView userName;
    private Button inputCode;
    private Verification verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        findViews();
    }

    private void findViews() {
        userImage = findViewById(R.id.accountFragment_userImage);
        userName = findViewById(R.id.accountFragment_userName);
        inputCode = findViewById(R.id.accountFragment_codeInput);
        inputCode.setOnClickListener(this);
        Glide.with(getApplicationContext()).load("https://sun9-north.userapi.com/sun9-88/s/v1/if1/dCN6648LL39Vs8p12OZ51Qn1a__5opFqpV5NZbj57KaObhi-JaxoBTqxDSvNaGkyHPM6k2vo.jpg?size=606x1080&quality=96&type=album").into(userImage);
        fillData();
    }

    private void onInputCodeClick() {
        inputCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View promptsView = View.inflate(getApplicationContext(), R.layout.code_input_dialog, null);
                AlertDialog alertDialog = new AlertDialog.Builder(ProfileActivity.this)
                        .setView(promptsView)
                        .create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                promptsView.findViewById(R.id.codeSuccess_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        verificationCode = promptsView.findViewById(R.id.code_inputText);
                        Toast.makeText(ProfileActivity.this, verificationCode.getPhoneCode(), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });
    }

    private void fillData() {
        userName.setText("Братусев Денис Витальевич");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.accountFragment_codeInput: {
                onInputCodeClick();
            }
            break;
        }
    }
}