package com.example.project.ui.shagomer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.project.R;

public class ShagomerFragment extends Fragment implements SensorEventListener { //наследуется от обработчика слушателя сенсора
      private SensorManager mSensorManager; //переменная типа SensorManager
      private Sensor mOrientation; // переменная типа Sensor
    TextView mTt;
    TextView mTpedometer;
    private float lastValue;
    protected int pedometer;

           public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_shagomer, container, false);
pedometer=0;
lastValue=0f;
         mTt=root.findViewById(R.id.text_shagomer);
         mTpedometer=root.findViewById(R.id.textView2);
         mTt.setText ("");



         mSensorManager = (SensorManager) getContext(). getSystemService(Context.SENSOR_SERVICE);
         mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         mSensorManager.registerListener( this, mOrientation,SensorManager.SENSOR_DELAY_NORMAL);
        return root;
    }
    @Override
    public void onSensorChanged (SensorEvent sensorEvent) {
               float val = sensorEvent.values[0];
               mTt.setText(String.valueOf(sensorEvent.values [0]));
               if (Math.abs(val-lastValue)>4.4f) pedometer++;
               mTpedometer.setText(String.valueOf(pedometer));
               lastValue=val;
    }
    @Override
    public void onAccuracyChanged (Sensor sensor, int i) {

    }
}