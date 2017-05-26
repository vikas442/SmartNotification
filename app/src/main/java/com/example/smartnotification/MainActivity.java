package com.example.smartnotification;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.smartnotification.receivers.PhoneUnlockReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    private PhoneUnlockReceiver mPhoneUnlockReceiver = new PhoneUnlockReceiver();

    @BindView(R.id.switch_unlock)
    Switch mUnlockSwitch;

    @BindView(R.id.switch_log_calls)
    Switch mLogCallsSwitch;

    @BindView(R.id.btn_show_logs)
    Button mBtnShowCallLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        updateView();
    }

    private void updateView() {
        mUnlockSwitch.setChecked(AppSetting.isUnlockTrackingEnabled(getApplicationContext()));
        mLogCallsSwitch.setChecked(AppSetting.isCallLoggingEnabled(getApplicationContext()));
        mBtnShowCallLog.setVisibility(mLogCallsSwitch.isChecked() ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        IntentFilter filter = new IntentFilter(Intent.ACTION_USER_PRESENT);
//        registerReceiver(mPhoneUnlockReceiver, filter);
    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(mPhoneUnlockReceiver);
        super.onDestroy();
    }

    @OnCheckedChanged({R.id.switch_unlock, R.id.switch_log_calls})
    public void onEventTrackStatusChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.switch_unlock:
                enableUnlockTracking(isChecked);
                break;
            case R.id.switch_log_calls:
                MainActivityPermissionsDispatcher.enableCallLoggingWithCheck(this, isChecked);
                break;
        }
    }

    @OnClick(R.id.btn_show_logs)
    public void showCallLog(View view) {
        startActivity(new Intent(this, CallLogsActivity.class));
    }

    @NeedsPermission({Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE})
    public void enableCallLogging(boolean enable) {
        AppSetting.updateCallEventTracking(getApplicationContext(), enable);
        mBtnShowCallLog.setVisibility(enable ? View.VISIBLE : View.GONE);
    }

    private void enableUnlockTracking(boolean enable) {
        AppSetting.updateUnlockEventTracking(getApplicationContext(), enable);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
