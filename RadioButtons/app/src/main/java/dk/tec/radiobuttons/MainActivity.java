package dk.tec.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    RadioGroup rdgElev;
    Button btnTjek;
    TextView txtChoosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdgElev = findViewById(R.id.rdgElev);
        rdgElev.setOnCheckedChangeListener(this);

        btnTjek = findViewById(R.id.btnTjek);
        txtChoosen = findViewById(R.id.txtValgtElev);
        btnTjek.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(rdgElev.getCheckedRadioButtonId())
        {
            case R.id.rdbKevin:
                txtChoosen.setText("Kevin");
                break;
            case R.id.rdbMarcus:
                txtChoosen.setText("Marcus");
                break;
            case R.id.rdbWiktor:
                txtChoosen.setText("Wiktor");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch(checkedId)
        {
            case R.id.rdbKevin:
                Toast.makeText(this, "Kevin valgt", Toast.LENGTH_LONG).show();
                break;
            case R.id.rdbWiktor:
                Toast.makeText(this, "Wiktor valgt", Toast.LENGTH_LONG).show();
                break;case R.id.rdbMarcus:
            Toast.makeText(this, "Marcus valgt", Toast.LENGTH_LONG).show();
            break;
        }
    }
}