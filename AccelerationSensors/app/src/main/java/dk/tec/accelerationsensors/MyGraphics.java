package dk.tec.accelerationsensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

public class MyGraphics extends View implements SensorEventListener
{
    float xBall= 200, yBall = 300;
    float xPace = 0, yPace = 0;
    Drawable drwBall;
    int ballWidth, ballHeight;
    MainActivity context;
    public MyGraphics(MainActivity context) {
        super(context);
        this.context = context;
        drwBall = getResources().getDrawable(R.drawable.kugle_rwb, null);
        ballWidth = drwBall.getIntrinsicWidth()/3;
        ballHeight = drwBall.getIntrinsicHeight()/3;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        drwBall.setBounds((int)xBall, (int)yBall,(int)(xBall + ballWidth), (int)(yBall + ballHeight) );
        drwBall.draw(canvas);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            context.updateGUI(event.values);
            float xSlope = event.values[0];
            float ySlope = event.values[1];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}
