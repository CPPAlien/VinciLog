package me.pengtao.ptlog_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import me.pengtao.ptlog.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PtLog.init(BuildConfig.DEBUG, "Pengtao", this);
        try {
            PtLog.saveLog(this, "log.txt");
        } catch (IOException e) {
            e.printStackTrace();
            PtLog.e("create log failed", e);
        }
        PtLog.d("test");

        try {
            PtLog.saveLog(this, "log1.txt");
        } catch (IOException e) {
            e.printStackTrace();
            PtLog.e("create log failed", e);
        }
        PtLog.d("test1");
    }
}