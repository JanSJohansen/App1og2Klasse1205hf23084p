package dk.tec.touchgraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyGraphic extends View implements View.OnTouchListener {
    int xPos = 200, yPos = 300;
    int xPrev, yPrev;
    int radius = 100;
    boolean move = false;

    public MyGraphic(Context context)
    {
        super(context);
        setOnTouchListener(this);
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(0xFFFF00FF);
        canvas.drawCircle(xPos, yPos, radius, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int newX = (int)event.getX();
        int newY = (int)event.getY();
        int action = event.getAction();
        switch(action)
        {
            case MotionEvent.ACTION_DOWN:
                if(Math.sqrt((newX - xPos)*(newX - xPos) + (newY - yPos)*(newY - yPos)) < radius)
                {
                    move = true;
                    xPrev = newX;
                    yPrev = newY;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(move)
                {
                    xPos += newX - xPrev;
                    yPos += newY - yPrev;
                    xPrev = newX;
                    yPrev = newY;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                move = false;
                break;
        }
        return true;
    }
}
