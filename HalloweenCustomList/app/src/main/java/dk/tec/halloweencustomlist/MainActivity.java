package dk.tec.halloweencustomlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView lstMonsters;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Monster> list = new ArrayList<>();
        list.add(new Monster("Abdi","Kaldet Andreas i folkemunde", R.drawable.abdi));
        list.add(new Monster("Ahmed","Kommer tidligt i skole ind imellem", R.drawable.ahmed_sharkarji));
        list.add(new Monster("Daniel","Elsker en crazy joint", R.drawable.daniel));
        list.add(new Monster("Hele klassen","The crazy pupils", R.drawable.h4_klassen));
        list.add(new Monster("Jan","Giver kage hvert år", R.drawable.jan));
        list.add(new Monster("Kevin","Ikke gambling addicts", R.drawable.kevin));
        list.add(new Monster("Leonard","Airfryer pølse-steger", R.drawable.leonard));
        list.add(new Monster("Marco","Dygtig, dygtig, dygtig", R.drawable.marco));
        list.add(new Monster("Marcus","Marcussen kan lide mad", R.drawable.marcus));
        list.add(new Monster("Nicklas","Meget kan man sige om ham", R.drawable.nicklas));
        list.add(new Monster("Nisha","Bjergbestiger 50 af Mount Everest", R.drawable.nisha));
        list.add(new Monster("Wobin","Mr. Fredagsbar", R.drawable.wobin));

        CustomAdapter adapter = new CustomAdapter(this,list);
        lstMonsters = findViewById(R.id.lstMonsters);
        lstMonsters.setAdapter(adapter);
    }
}