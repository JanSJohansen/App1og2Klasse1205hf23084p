package dk.tec.buttonscommonhandlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnKnapEt, btnKnapTo;
    TextView txtNoget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKnapEt = findViewById(R.id.btnKnapEt);
        btnKnapTo = findViewById(R.id.btnKnapTo);
        txtNoget = findViewById(R.id.txtNoget);

        btnKnapEt.setOnClickListener(this);
        btnKnapTo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //Button b = (Button) v;
        //b.getText();
        switch(v.getId())
        {
            case R.id.btnKnapEt:
                btnKnapEtHandler();
                break;
            case R.id.btnKnapTo:
                btnKnapToHandler();
                break;
        }


//        if(v.getId() == R.id.btnKnapEt)
//        {
//            btnKnapEtHandler();
//        }
//        else if(v == btnKnapTo)
//        {
//            btnKnapToHandler();
//        }
    }

    private void btnKnapToHandler()
    {
        txtNoget.setText("Trykket på Knap To");
    }

    private void btnKnapEtHandler()
    {
        txtNoget.setText("Trykket på Knap Et");
    }

}