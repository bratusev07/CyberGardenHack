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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ru.bratusev.cybergardenhack.models.LectureModel;
import ru.bratusev.cybergardenhack.services.adapter.StudentsAdapter;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView userImage;
    private TextView userName;
    private Button inputCode;
    private Verification verificationCode;
    private ListView group_list;
    private ViewFlipper flipper;
    private int pos = 0;
    private ArrayList<LectureModel> lectureModels;
    private boolean isTeacher = true;
    private ArrayList<String> students;

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
        findViewById(R.id.arrow_back).setOnClickListener(this);
        findViewById(R.id.arrow_forward).setOnClickListener(this);

        if (isTeacher) {
            inputCode.setVisibility(View.INVISIBLE);
            group_list.setVisibility(View.VISIBLE);
            setListAdapter();
        } else {
            inputCode.setVisibility(View.VISIBLE);
            group_list.setVisibility(View.INVISIBLE);
            inputCode.setOnClickListener(this);
        }

        fillData();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListAdapter() {
        group_list.setAdapter(new StudentsAdapter(getApplicationContext(), fillArray()));

        group_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onStudentClick((String) adapterView.getItemAtPosition(i));
            }
        });
        flipper.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeLeft() {
                if (pos < lectureModels.size() - 1) {
                    pos++;
                    updateData();
                }
            }

            @Override
            public void onSwipeRight() {
                if (pos > 0) {
                    pos--;
                    updateData();
                }
            }
        });
    }

    private ArrayList<String> fillArray() {
        students = new ArrayList<>();
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
        students.add("Иванов Василий Семёнович");
        students.add("Пупкин Иван Сергеевич");
        students.add("Петров Петр Витальевич");
        students.add("Орешков Константин Викторович");
        students.add("Сидоров Сидор Сидорович");
        students.add("Гениальный Гений Гениевич");
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
                        alertDialog.cancel();
                        Toast.makeText(ProfileActivity.this, verificationCode.getPhoneCode(), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });
    }

    private void onStudentClick(String student) {
        View promptsView = View.inflate(getApplicationContext(), R.layout.remove_student_dialog, null);
        AlertDialog alertDialog = new AlertDialog.Builder(ProfileActivity.this)
                .setView(promptsView)
                .create();

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        promptsView.findViewById(R.id.removeSuccess_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(student);
                group_list.setAdapter(new StudentsAdapter(getApplicationContext(), students));
                alertDialog.cancel();
                Toast.makeText(ProfileActivity.this, "Студент был удалён с пары", Toast.LENGTH_SHORT).show();
            }
        });
        promptsView.findViewById(R.id.removeCancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void fillData() {
        Glide.with(getApplicationContext()).load("https://sun9-north.userapi.com/sun9-88/s/v1/if1/dCN6648LL39Vs8p12OZ51Qn1a__5opFqpV5NZbj57KaObhi-JaxoBTqxDSvNaGkyHPM6k2vo.jpg?size=606x1080&quality=96&type=album").into(userImage);
        userName.setText("Братусев Денис Витальевич");

        lectureModels = new ArrayList<>();
        lectureModels.add(new LectureModel("Первая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Вторая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Третья пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Чевертая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Пятая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Шестая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Седьмая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
        lectureModels.add(new LectureModel("Восьмая пара", "Д-419", "пр. Программирование на языке Java", "09:50-11:25", "Шкурко А. Н."));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.accountFragment_codeInput: {
                onInputCodeClick();
            }
            break;
            case R.id.arrow_forward:
                if (pos < lectureModels.size() - 1) {
                    pos++;
                    updateData();
                }
                break;
            case R.id.arrow_back:
                if (pos > 0) {
                    pos--;
                    updateData();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }

    private void updateData() {
        ((TextView) findViewById(R.id.para)).setText(lectureModels.get(pos).getPara());
        ((TextView) findViewById(R.id.cabinet)).setText(lectureModels.get(pos).getCabinet());
        ((TextView) findViewById(R.id.sines)).setText(lectureModels.get(pos).getSines());
        ((TextView) findViewById(R.id.time)).setText(lectureModels.get(pos).getTime());
        ((TextView) findViewById(R.id.teacher)).setText(lectureModels.get(pos).getTeacher());
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