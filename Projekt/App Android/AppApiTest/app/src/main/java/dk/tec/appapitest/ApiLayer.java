package dk.tec.appapitest;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import retrofit2.Call;

public class ApiLayer
{
    public static Frugt getFrugtById(int id) {
        FutureTask<Frugt> futureTask = new FutureTask<>(new Callable<Frugt>() {
            @Override
            public Frugt call() {
                Frugt f = null;
                IFrugtService service = ServiceBuilder.buildService(IFrugtService.class);
                Call<Frugt> request = service.getFrugtById(id);
                try {
                    f = request.execute().body(); // Kaldet sker i ny tråd
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return f;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        Frugt frugt = null;
        try {
            frugt = futureTask.get();// will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }
        return frugt;
    }
}
