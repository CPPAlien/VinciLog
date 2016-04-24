package me.pengtao.ptlog_example;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import me.pengtao.ptlog.*;

public class MainActivity extends AppCompatActivity {

    TextView tvLog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLog = (TextView)findViewById(R.id.log_text);

        PtLog.init(BuildConfig.DEBUG, "Pengtao", this);

        PtLog.startLogSave();

        PtLog.d("test");
        PtLog.d("test1");

        findViewById(R.id.display_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    displayLog();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.delete_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PtLog.deleteLog()) {
                    Toast.makeText(getApplicationContext(), "Delete success", Toast.LENGTH_SHORT).show();
                    try {
                        displayLog();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void displayLog() throws IOException {
        tvLog.setText("");
        FileReader fr = new FileReader(PtLog.getLogPath());
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ( (line = br.readLine()) != null ) {
            tvLog.append(line);
            tvLog.append("\n");
        }
        br.close();
    }
}