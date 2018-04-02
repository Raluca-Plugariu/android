package com.example.ralucaplugariu.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raluca.plugariu on 29.03.2018.
 */

public class Sensors extends AppCompatActivity {
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ListView mTextView = (ListView) findViewById(R.id.list);
        System.out.println("list   "+mTextView);


        List<Sensor> mList
                = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        String[] list = new String[mList.size()];
        for (int i = 0; i < mList.size(); i++) {
            list[i] = ("Name : " + mList.get(i).getName()
                    + " / Int Type : " + mList.get(i).getType()
                    + " / String Type : "
                    + sensorTypeToString(mList.get(i).getType()) + " / Vendor : "
                    + mList.get(i).getVendor() + " / Version : "
                    + mList.get(i).getVersion() + " / Resolution : "
                    + mList.get(i).getResolution() + " / Power : "
                    + mList.get(i).getPower() + " mAh"
                    + " / Maximum Range : " + mList.get(i).getMaximumRange());
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.content, R.id.content, list);
        mTextView.setAdapter(listAdapter);

    }

    public static String sensorTypeToString(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accelerometer";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
            case Sensor.TYPE_TEMPERATURE:
                return "Ambient Temperature";
            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                return "Game Rotation Vector";
            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                return "Geomagnetic Rotation Vector";
            case Sensor.TYPE_GRAVITY:
                return "Gravity";
            case Sensor.TYPE_GYROSCOPE:
                return "Gyroscope";
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                return "Gyroscope Uncalibrated";
            case Sensor.TYPE_HEART_RATE:
                return "Heart Rate Monitor";
            case Sensor.TYPE_LIGHT:
                return "Light";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "Linear Acceleration";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "Magnetic Field";
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                return "Magnetic Field Uncalibrated";
            case Sensor.TYPE_ORIENTATION:
                return "Orientation";
            case Sensor.TYPE_PRESSURE:
                return "Orientation";
            case Sensor.TYPE_PROXIMITY:
                return "Proximity";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "Relative Humidity";
            case Sensor.TYPE_ROTATION_VECTOR:
                return "Rotation Vector";
            case Sensor.TYPE_SIGNIFICANT_MOTION:
                return "Significant Motion";
            case Sensor.TYPE_STEP_COUNTER:
                return "Step Counter";
            case Sensor.TYPE_STEP_DETECTOR:
                return "Step Detector";
            default:
                return "Unknown";
        }

    }
}
