package com.gzeinnumer.getpermission;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.gzeinnumer.getpermission.base.BasePermissionActivity;

public class MainActivity extends BasePermissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickSingle();
        clickMulti();
        clickCamera();
    }

    private void clickSingle() {
        findViewById(R.id.btn_single).setOnClickListener(v -> {
            requestPermission(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    new PermissionCallBack() {
                        @Override
                        public void isGranted(boolean isGranted) {
                            if (isGranted)
                                Toast.makeText(MainActivity.this, "intent to clickSingle", Toast.LENGTH_SHORT).show();
                            else
                                openSettings();
                        }
                    });
        });
    }

    private void clickMulti() {
        findViewById(R.id.btn_multi).setOnClickListener(v -> {
            String[] permission = {
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };
            requestPermission(
                    permission,
                    new PermissionCallBack() {
                        @Override
                        public void isGranted(boolean isGranted) {
                            if (isGranted)
                                Toast.makeText(MainActivity.this, "intent to clickMulti", Toast.LENGTH_SHORT).show();
                            else
                                openSettings();
                        }
                    });
        });
    }

    private void clickCamera() {
        findViewById(R.id.btn_camera).setOnClickListener(v -> {
            requestPermissionCamera(
                    new PermissionCallBack() {
                        @Override
                        public void isGranted(boolean isGranted) {
                            if (isGranted)
                                Toast.makeText(MainActivity.this, "intent to clickCamera", Toast.LENGTH_SHORT).show();
                            else
                                openSettings();
                        }
                    });
        });
    }
}