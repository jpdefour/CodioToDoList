package riis.training.codiotodolist.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by John on 10/12/2016.
 */
@Module
public class AppModule {
    private ToDoListApplication application;

    public AppModule(ToDoListApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }
}
