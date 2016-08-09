package riis.training.codiotodolist;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import riis.training.codiotodolist.Model.Item;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> items;
    ItemAdapter adapter;
    FloatingActionButton fab;
    Activity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisActivity = this;

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

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ItemEntryActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
}
