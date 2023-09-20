package dk.tec.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Button btnSecondGoBack;
    TextView txtSecondFromCaller;
    EditText txtSecondToCaller;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecondGoBack = findViewById(R.id.btnSecondGoBack);
        btnSecondGoBack.setOnClickListener(this);

        txtSecondFromCaller = findViewById(R.id.txtSecondFromCaller);
        txtSecondToCaller = findViewById(R.id.txtSecondToCaller);

        intent = getIntent(); // Det intent som aktiviteten er kaldt med
        String strFromCaller = intent.getStringExtra(MainActivity.TEXT_FROM_CALLER);
        txtSecondFromCaller.setText(strFromCaller);
    }

    @Override
    public void onClick(View v)
    {
        String strToCaller = txtSecondToCaller.getText().toString();
        intent.putExtra(MainActivity.TEXT_FROM_SECOND, strToCaller);

        setResult(SecondActivity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}