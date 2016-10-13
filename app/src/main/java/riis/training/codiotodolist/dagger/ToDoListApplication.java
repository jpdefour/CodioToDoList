package riis.training.codiotodolist.dagger;

import android.app.Application;

import riis.training.codiotodolist.MainActivity;

/**
 * Created by John on 8/10/2016.
 */
public class ToDoListApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .mainActivityModule(new MainActivityModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
