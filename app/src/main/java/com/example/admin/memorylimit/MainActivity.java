package com.example.admin.memorylimit;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        calculate();
    }

    private void findview() {
        info = (TextView) findViewById(R.id.info);
    }

    private void calculate() {
        StringBuilder stringBuilder = new StringBuilder();
        //activityManager系统服务对象
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memClass = activityManager.getMemoryClass();//以m为单位 内存限制
        int LargememClass = activityManager.getLargeMemoryClass(); //以m为单位
        stringBuilder.append("memClass:" + memClass + "\n");
        stringBuilder.append("LargememClass:" + LargememClass + "\n");

        Float totalMemory = Runtime.getRuntime().totalMemory() * 1.0f / (1024*1024);
        Float freeMemory = Runtime.getRuntime().freeMemory() * 1.0f / (1024*1024); //空闲内存
        Float maxMemory = Runtime.getRuntime().maxMemory() * 1.0f / (1024*1024); //最大内存
        stringBuilder.append("totalMemory:" + totalMemory + "\n");
        stringBuilder.append("freeMemory:" + freeMemory + "\n");
        stringBuilder.append("maxMemory:" + maxMemory + "\n");

        info.setText(stringBuilder.toString());
        Log.d("huangchixing", stringBuilder.toString());


    }
}
