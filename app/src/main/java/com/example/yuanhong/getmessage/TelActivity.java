package com.example.yuanhong.getmessage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText input_tel;
    private Button goto_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);
        init();
        initData();
    }
    public void init(){
        input_tel = (EditText)findViewById(R.id.input_tel);
        goto_tel = (Button)findViewById(R.id.goto_tel);
    }
    public void initData(){
        goto_tel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.goto_tel:
                String tel = input_tel.getText().toString();
                Intent intent = new Intent();               //创建Intent对象
                intent.setAction(Intent.ACTION_CALL);      //设置动作为拨打电话
                intent.setData(Uri.parse("tel:" + tel));   // 设置要拨打的电话号码
                startActivity(intent);                      //启动Activity
                break;
        }
    }
}
