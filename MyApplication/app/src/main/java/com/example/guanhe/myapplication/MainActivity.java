package com.example.guanhe.myapplication;

import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "android.intent.extra.alarm.MESSAGE";
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        //Do something  in response to button
        //this 和 Main2Activity 之间的Intent
        Intent intent = new Intent(this, Main2Activity.class);
        //通过id找到EcitText 视图对象
        EditText editText = (EditText) findViewById(R.id.editText);
        //获取EditText的文本,并转换为String类型
        String message = editText.getText().toString();
        //EXTRA_MESSAGE 键名 message 键值
        intent.putExtra(EXTRA_MESSAGE, message);
        //启动另一个activity,并传递intent对象
        startActivity(intent);
    }
}

