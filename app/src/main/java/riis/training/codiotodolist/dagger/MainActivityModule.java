package riis.training.codiotodolist.dagger;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import riis.training.codiotodolist.ItemAdapter;
import riis.training.codiotodolist.model.Item;

/**
 * Created by John on 8/11/2016.
 */
@Module
public class MainActivityModule {
    private final Context context;

    public MainActivityModule (Context context) {
        this.context = context;
    }

    @Provides //scope is not necessary for parameters stored within the module
    public Context getContext() {
        return context;
    }

    @Provides static List<Item> provideItemArrayList() {
        return new ArrayList<>();
    }
    @Provides static RecyclerView.LayoutManager provideLinearLayoutManager(Context context) { return new LinearLayoutManager(context); }



}
