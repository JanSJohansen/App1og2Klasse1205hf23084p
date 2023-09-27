package dk.tec.accelerationsensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {
    LinearLayout theLayout;
    TextView txtX, txtY, txtZ;
    Button btnShowGraphics;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        btnShowGraphics = findViewById(R.id.btnShowGraphics);
        btnShowGraphics.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 10000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sm.unregisterListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            //updateGUI(event.values);
        }
    }
    public void updateGUI(float[] values)
    {
        txtX.setText(String.format("%8.1f", values[0]));
        txtY.setText(String.format("%8.1f", values[1]));
        txtZ.setText(String.format("%8.1f", values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    public void onClick(View v)
    {
        MyGraphics mg = new MyGraphics(this);
        sm.unregisterListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
        sm.registerListener(mg, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 10000);

        theLayout.addView(mg);

    }
}