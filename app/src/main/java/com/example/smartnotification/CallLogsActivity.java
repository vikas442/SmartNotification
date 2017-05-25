package com.example.smartnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smartnotification.util.LogHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CallLogsActivity extends AppCompatActivity {

    @BindView(R.id.tv_call_log)
    TextView mTVCallLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_logs);
        ButterKnife.bind(this);
        mTVCallLog.setText(LogHelper.readFromFile(getApplicationContext()));
    }
}
