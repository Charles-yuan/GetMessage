package com.example.yuanhong.getmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button tel;
    private Button short_message;//短信
    private Button toast;//消息提示框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }

    public void init(){
        tel = (Button)findViewById(R.id.tel);
        short_message = (Button)findViewById(R.id.short_message);
        toast = (Button)findViewById(R.id.toast);
    }
    public void initData(){
        tel.setOnClickListener(this);
        short_message.setOnClickListener(this);
        toast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tel:
                startActivity(new Intent(MainActivity.this,TelActivity.class));
                break;
            case R.id.short_message://短信
                startActivity(new Intent(MainActivity.this,ShortMessageActivity.class));
                break;
            case R.id.toast://消息提示框
                startActivity(new Intent(MainActivity.this,ToastActivity.class));
                break;
        }
    }
}
