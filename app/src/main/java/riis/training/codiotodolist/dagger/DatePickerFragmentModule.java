package riis.training.codiotodolist.dagger;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

/**
 * Created by John on 10/13/2016.
 */
@Module
public class DatePickerFragmentModule {
    @Provides static Calendar getCalendarInstance() {
        return Calendar.getInstance();
    }
}
