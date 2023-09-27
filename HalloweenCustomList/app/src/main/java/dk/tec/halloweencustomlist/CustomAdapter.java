package dk.tec.halloweencustomlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter
{
    ArrayList<Monster> monsterList;
    MainActivity main;
    public CustomAdapter(MainActivity mainActivity, ArrayList<Monster> list)
    {
        this.monsterList = list;
        this.main = mainActivity;
    }

    @Override
    public int getCount()
    {
        return this.monsterList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Monster monster = monsterList.get(position);

        View v = main.getLayoutInflater().inflate(R.layout.monster_item, null);

        ImageView imv = v.findViewById(R.id.drwMonster);
        imv.setImageResource(monster.getImgId());

        TextView title = v.findViewById(R.id.txtTitle);
        title.setText(monster.getName());

        TextView desc = v.findViewById(R.id.txtDesc);
        desc.setText(monster.getDesc());

        Button btnDelete = v.findViewById(R.id.btnDelete);
        btnDelete.setText("Delete " + monster.getName());

        return v;
    }
}
