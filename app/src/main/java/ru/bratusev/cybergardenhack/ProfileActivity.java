package ru.bratusev.cybergardenhack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView userImage;
    private TextView userName;
    private Button inputCode;
    private Verification verificationCode;
    private ListView group_list;
    private ViewFlipper flipper;
    private boolean isTeacher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        findViews();
    }

    private void findViews() {
        userImage = findViewById(R.id.accountFragment_userImage);
        userName = findViewById(R.id.accountFragment_userName);
        inputCode = findViewById(R.id.accountFragment_codeInput);
        group_list = findViewById(R.id.group_list);
        flipper = findViewById(R.id.lectureList);

        if (isTeacher){
            inputCode.setVisibility(View.INVISIBLE);
            group_list.setVisibility(View.VISIBLE);
            setListAdapter();
        }else{
            inputCode.setVisibility(View.VISIBLE);
            group_list.setVisibility(View.INVISIBLE);
            inputCode.setOnClickListener(this);
        }

        Glide.with(getApplicationContext()).load("https://sun9-north.userapi.com/sun9-88/s/v1/if1/dCN6648LL39Vs8p12OZ51Qn1a__5opFqpV5NZbj57KaObhi-JaxoBTqxDSvNaGkyHPM6k2vo.jpg?size=606x1080&quality=96&type=album").into(userImage);
        fillData();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListAdapter(){
        group_list.setAdapter(new StudentsAdapter(getApplicationContext(), fillArray()));
        flipper.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()){
            @Override
            public void onSwipeLeft() {

            }

            @Override
            public void onSwipeRight() {

            }
        });
    }

    private ArrayList<String> fillArray(){
        ArrayList<String> students = new ArrayList<>();
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        return students;
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

    @Override
    public void onBackPressed() {

    }

    public class OnSwipeTouchListener implements View.OnTouchListener {

        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context ctx) {
            gestureDetector = new GestureDetector(ctx, new GestureListener());
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                boolean result = false;
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                onSwipeRight();
                            } else {
                                onSwipeLeft();
                            }
                            result = true;
                        }
                    } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom();
                        } else {
                            onSwipeTop();
                        }
                        result = true;
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return result;
            }
        }

        public void onSwipeRight() {
        }

        public void onSwipeLeft() {
        }

        public void onSwipeTop() {
        }

        public void onSwipeBottom() {
        }
    }
}