package cn.hadcn.log_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.hadcn.davinci.log.LogLevel;
import cn.hadcn.davinci.log.VinciLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VinciLog.init(LogLevel.DEBUG, "PENG", this);

        VinciLog.e("This is a test");
    }
}
