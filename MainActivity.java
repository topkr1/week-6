package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chro;
    RadioButton rdo1, rdo2;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView year,month,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        //크로노 미터
        chro = (Chronometer) findViewById(R.id.chro);

        //라디오 버튼 2개
        rdo1 = (RadioButton) findViewById(R.id.rdo1);
        rdo2 = (RadioButton) findViewById(R.id.rdo2);

        dPicker = (DatePicker) findViewById(R.id.dPicker);
        tPicker = (TimePicker) findViewById(R.id.tPicker);
        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        year = (TextView) findViewById(R.id.year);
        month = (TextView) findViewById(R.id.month);
        day = (TextView) findViewById(R.id.day);
        hour = (TextView) findViewById(R.id.hour);
        min = (TextView) findViewById(R.id.min);

        rdo1.setVisibility(View.INVISIBLE);
        rdo2.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);
        rdo1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });
        rdo2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });
        // 크로노미터를 클릭하면..타이머 시작
        chro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
                chro.setTextColor(Color.RED);
                rdo1.setVisibility(View.VISIBLE);
                rdo2.setVisibility(View.VISIBLE);
            }
        });
// 크로노미터를 롱클릭하면..타이머 중지
        year.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                chro.stop();
                chro.setTextColor(Color.BLUE);
                year.setText(Integer.toString(dPicker.getYear()));
                month.setText(Integer.toString(1 + dPicker.getMonth()));
                day.setText(Integer.toString(dPicker.getDayOfMonth()));
                hour.setText(Integer.toString(tPicker.getCurrentHour()));
                min.setText(Integer.toString(tPicker.getCurrentMinute()));
                rdo1.setVisibility(View.INVISIBLE);
                rdo2.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
                return false;
            }
        });

    }
}