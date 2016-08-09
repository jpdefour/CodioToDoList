package riis.training.codiotodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import riis.training.codiotodolist.Model.Item;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.add(new Item());
            int j = i + 1;
            items.get(i).setName("Dummy name " + j);
            items.get(i).setDescription("Dummy description " + j);
        }

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
