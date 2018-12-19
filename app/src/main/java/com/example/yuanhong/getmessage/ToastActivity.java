package com.example.yuanhong.getmessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener{
    private Button toast;//普通的   Toast
    private Button image_toast;//带图片的 Toast
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        init();
        initData();
    }
    public void init(){
        toast = (Button)findViewById(R.id.toast);
        image_toast = (Button)findViewById(R.id.image_toast);
    }
    public void initData(){
        toast.setOnClickListener(this);
        image_toast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.toast:
                Toast.makeText(ToastActivity.this, "普通的Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image_toast:
                Toast toast = new Toast(this);
                toast.setDuration(Toast.LENGTH_SHORT);              //设置持续时间
                toast.setGravity(Gravity.CENTER, 0, 0);              //设置对齐方式

                LinearLayout linearLayout = new LinearLayout(this); //创建一个线性布局

                ImageView imageView = new ImageView(this);          //创建一个 ImageView
                imageView.setImageResource(R.mipmap.ic_launcher);   //加载图片
                imageView.setPadding(0, 0, 10, 0);                    //设置 ImageView 的右边距
                linearLayout.addView(imageView);                      //将图片添加到线性布局

                TextView textView = new TextView(this);               //创建一个 TextView
                textView.setText("这个就是有图片的 Toast ");         //设置文本内容
                linearLayout.addView(textView);                        //将文本添加到线性布局

                toast.setView(linearLayout);                            //设置消息框的视图
                toast.show();                                           //显示提示框
                break;
        }
    }
}
