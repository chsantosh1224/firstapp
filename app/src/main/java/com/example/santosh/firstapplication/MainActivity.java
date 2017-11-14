package com.example.santosh.firstapplication;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean flashLightStatus = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onTouch(View v)
    {
        Toast mytoast=Toast.makeText(getApplicationContext(),"Switched On",Toast.LENGTH_SHORT);
        Toast mytoast1=Toast.makeText(getApplicationContext(),"Switched Off",Toast.LENGTH_SHORT);
                if(flashLightStatus) {
                    onFlash();
                    mytoast.show();
                }
                else {
                    FlashLightOff();
                    mytoast1.show();
                }
    }
    public void onFlash()
    {
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            flashLightStatus=false;
            String cameraId = camManager.getCameraIdList()[0]; // Usually front camera is at 0 position.
            camManager.setTorchMode(cameraId, true);
        } catch (Exception e)
        {
        }
    }
    private void FlashLightOff() {
        CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            flashLightStatus=true;
            String cameraId = camManager.getCameraIdList()[0]; // Usually front camera is at 0 position.
            camManager.setTorchMode(cameraId, false);
        } catch (Exception e){
        }
    }

}

