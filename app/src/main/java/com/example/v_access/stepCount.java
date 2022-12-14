package com.example.v_access;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class stepCount extends AppCompatActivity implements SensorEventListener {
TextView stepTaken;
SensorManager sensorManager;
boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_count);
        stepTaken=findViewById(R.id.tv_stepsTaken);
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor!=null){
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText(this,"sensor not found",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        running=false;

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running){
            stepTaken.setText(String.valueOf(sensorEvent.values[0]));
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
super.onPause();
//sensorManager.unregisterListener(this);
    }
}