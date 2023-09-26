package dk.tec.movingbirthe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

public class BirtheMove extends View implements Runnable
{
    int x = 100, y = 100;
    int xInc = 3, yInc = 3;
    int viewWidth, viewHeight;
    int drwH, drwW;
    Drawable drwBirthe;

    public BirtheMove(Context context)
    {
        super(context);
        drwBirthe = context.getDrawable(R.drawable.birthe_kjaer);
        drwW = drwBirthe.getIntrinsicWidth()/4;
        drwH = drwBirthe.getIntrinsicHeight()/4;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drwBirthe.setBounds(x, y, x + drwW, y + drwH);
        drwBirthe.draw(canvas);

    }

    @Override
    public void run()
    {
        while(true)
        {
            x += xInc;
            y += yInc;
            postInvalidate();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
