package dk.tec.movingbirthe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);
        BirtheMove birthe = new BirtheMove(this);
        theLayout.addView(birthe);
        Thread t = new Thread(birthe);
        t.start();




    }
}