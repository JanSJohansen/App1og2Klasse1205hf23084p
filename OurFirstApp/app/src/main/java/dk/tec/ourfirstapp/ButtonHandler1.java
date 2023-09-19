package dk.tec.ourfirstapp;

import android.view.View;

public class ButtonHandler1 implements View.OnClickListener
{
    MainActivity main;

    public ButtonHandler1(MainActivity mainActivity)
    {
        main = mainActivity;
    }

    @Override
    public void onClick(View v)
    {
        main.txtLabel.setText("Der blev trykket på Tryk Ikke");
    }
}
