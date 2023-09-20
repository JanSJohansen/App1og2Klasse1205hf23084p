package dk.tec.twoactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMainGoToSecond;
    TextView txtMainFromSecond;
    EditText txtMainToSecond;
    public static final String TEXT_FROM_CALLER = "TextFromCaller";
    public static final String TEXT_FROM_SECOND = "TextFromSecond";
    ActivityResultLauncher<Intent> secondActivityLauncher;
    ActivityResultLauncher<Intent> thirdActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMainGoToSecond = findViewById(R.id.btnMainGoToSecond);
        txtMainFromSecond = findViewById(R.id.txtMainFromSecond);
        txtMainToSecond = findViewById(R.id.txtMainToSecond);
        btnMainGoToSecond.setOnClickListener(this);
        secondActivityLauncher = registerForActivityResult
                (
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>()
                    {
                        @Override
                        public void onActivityResult(ActivityResult result)
                        {
                            if(result.getResultCode() == Activity.RESULT_OK)
                            {
                                Intent intent = result.getData();
                                String strFromSecond =
                                        intent.getStringExtra(MainActivity.TEXT_FROM_SECOND);
                                txtMainFromSecond.setText(strFromSecond);
                            }
                        }
                    }
                );
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MainActivity.TEXT_FROM_CALLER, txtMainToSecond.getText().toString());
        intent.putExtra("Tal1", 7);
        Elev e = new Elev();
        e.name = "Jan";
        e.shoeNo = 42;
        Serializable s = e;
        Elev e2 = (Elev)s;

        intent.putExtra("EnElev", e);
        Elev e3 = (Elev)intent.getSerializableExtra("EnElev");



        //startActivity(intent);
        secondActivityLauncher.launch(intent);
    }


}