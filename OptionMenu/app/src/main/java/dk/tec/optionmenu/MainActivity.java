package dk.tec.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{
    LinearLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.mnuFlemming:
                Toast.makeText(this, "Hej Flemming", Toast.LENGTH_LONG).show();
                break;
            case R.id.mnuHenrik:
                Snackbar snack = Snackbar.make(theLayout, "Næ er det dig Henrik", Snackbar.LENGTH_LONG);
                snack.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Lukket for Henrik", Toast.LENGTH_LONG).show();
                    }
                });
                snack.show();
                break;
            case R.id.mnuJan:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Gå på pension");
                dialog.setMessage("Ønsker De at gå på pension - Ja eller Nej?");
                dialog.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Han vil sandelig på pension", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Han føler sig for ung", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                break;
        }
        return true;
    }
}