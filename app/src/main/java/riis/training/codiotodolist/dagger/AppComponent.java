package riis.training.codiotodolist.dagger;

import android.content.Context;

import dagger.Component;
import riis.training.codiotodolist.DatePickerFragment;
import riis.training.codiotodolist.MainActivity;

/**
 * Created by John on 8/10/2016.
 */
@Component (modules = {AppModule.class, MainActivityModule.class, DatePickerFragmentModule.class})
public interface AppComponent {
    Context getContext();
    void inject(MainActivity activity);
    void inject(DatePickerFragment datePickerFragment);
}
