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
import java.util.List;

import riis.training.codiotodolist.Model.Item;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items;
    ItemAdapter adapter;
    FloatingActionButton fab;
    Activity thisActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisActivity = this;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        try {
            items = getItems();
        } catch (Exception e) {
            items = new ArrayList<>();
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

    public List<Item> getItems() {
        DBHandler dbHandler = new DBHandler(this, null, null, 1);

        List<Item> dbItems = dbHandler.findItems();

        return dbItems;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Item newItem = new Item();
                newItem.setName(data.getStringExtra("name"));
                newItem.setDescription(data.getStringExtra("description"));
                items.add(newItem);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
