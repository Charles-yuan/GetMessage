package com.example.yuanhong.getmessage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShortMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tel,content;//发送给谁，内容
    private Button goto_short_message;//发送短信按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_message);
        init();
        initData();
    }

    public void init(){
        tel = (EditText)findViewById(R.id.tel);
        content = (EditText)findViewById(R.id.content);
        goto_short_message = (Button)findViewById(R.id.goto_short_message);
    }
    public void initData(){
        goto_short_message.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goto_short_message:
                String tels = tel.getText().toString();              //获取电话
                String contents = content.getText().toString();      //获取短信内容
                Intent intent = new Intent();                        //创建 Intent 实例
                intent.setAction(Intent.ACTION_SENDTO);             //设置动作为发送短信
                intent.setData(Uri.parse("smsto:"+tels));           //设置发送的号码
                intent.putExtra("sms_body", contents);              //设置发送的内容
                startActivity(intent);                               //启动 Activity
                break;
        }
    }
}
