package dk.tec.ourfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTrykHer, btnTrykIkke;
    TextView txtLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLabel = findViewById(R.id.txtLabel);
        btnTrykIkke = findViewById(R.id.btnTrykIkke);

        ButtonHandler1 bh = new ButtonHandler1(this);
        btnTrykIkke.setOnClickListener(bh);

        btnTrykHer = findViewById(R.id.btnTrykHer);

        //btnTrykHer.setOnClickListener(this);
        btnTrykHer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtLabel.setText("Trykket og brugt anonym handler");
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        txtLabel.setText("Der blev trykket på Tryk Her");
        Log.d("Jan", "Der blev trykket på knappen");
    }


    private class MyInternalHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            txtLabel.setText("Hej");
        }
    }

    public void myButtonHandler(View v)
    {

    }
}