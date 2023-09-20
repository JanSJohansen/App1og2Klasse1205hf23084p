package dk.tec.spinnerelev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    TextView txtChosen;
    Spinner spnElever;
    ArrayAdapter<String> adapter;
    String[] elever = {"Nisha", "Nicklas", "Marco", "Niyazi",
            "Leonard", "Magnus", "Ahmed", "Frederik", "Christian",
             "Jan", "Daniel", "Marcus", "Wiktor", "Kevvin", "Abdi"};

    Elev[] elever2 = new Elev[6];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtChosen = findViewById(R.id.txtChosen);
        spnElever = findViewById(R.id.spnElever);
//-----------------------------------------------------------------
//        adapter = new ArrayAdapter<String>(
//                    this,
//                android.R.layout.simple_spinner_item,
//                elever);
//        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spnElever.setAdapter(adapter);
        spnElever.setOnItemSelectedListener(this);
// -------------------------------------------------
        elever2[0] = new Elev("Magnus","Spise mad", 43);
        elever2[1] = new Elev("Marco","Spille guitar", 41);
        elever2[2] = new Elev("Marcus","Spille smart", 42);
        elever2[3] = new Elev("Niyazi","Ikke noget særligt", 43);
        elever2[4] = new Elev("Ahmed","Chatte med gbt", 43);
        elever2[5]  = new Elev("Jan","Huske navne på Andreas eller Abdi", 39);

        ArrayAdapter<Elev> adapter = new ArrayAdapter<Elev>(this,
                           android.R.layout.simple_spinner_item,
                           elever2);
        spnElever.setAdapter(adapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        //txtChosen.setText(elever[position]);
        //Bruger parameter
        //txtChosen.setText(parent.getSelectedItem().toString());
        // Bruger ikke parametre. Kan bruges alle steder.
        Elev e = (Elev)spnElever.getSelectedItem();
        String name = e.getName();
        String skill = e.getSkill();
        int sko = e.getSko();
        txtChosen.setText(name + " " + skill + " " + sko);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}