package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    TimePicker time;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.txt1);
        time = (TimePicker) findViewById(R.id.time1);
        b1 = (Button) findViewById(R.id.btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h,m;
                String am_pm;
                if(Build.VERSION.SDK_INT>=23)
                {
                    h = time.getHour();
                    m = time.getMinute();
                }
                else{
                    h = time.getCurrentHour();
                    m = time.getCurrentMinute();
                }
                if(h>12){
                    am_pm="pm";
                    h = h-12;
                }
                else {
                    am_pm = "am";
                }
                tv.setText("Selected Date:"+h+":"+m+" "+am_pm);
            }
        });
    }
}