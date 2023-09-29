package dk.tec.appapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{
    TextView txtFrugtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFrugtName = findViewById(R.id.txtFrugtName);

        IFrugtService frugtService = ServiceBuilder.buildService(IFrugtService.class);
        Call<Frugt> request = frugtService.getFrugtById(1001);
        request.enqueue(new Callback<Frugt>() {
            @Override
            public void onResponse(Call<Frugt> call, Response<Frugt> response)
            {
                Frugt frugt = response.body();
                txtFrugtName.setText(frugt.getName());
            }

            @Override
            public void onFailure(Call<Frugt> call, Throwable t)
            {
                txtFrugtName.setText(t.getMessage());
            }
        });


    }
}