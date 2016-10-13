package riis.training.codiotodolist;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import riis.training.codiotodolist.dagger.ToDoListApplication;
import riis.training.codiotodolist.model.Item;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ItemAdapter adapter;
    FloatingActionButton fab;
    Activity thisActivity;

    @Inject List<Item> items;
    @Inject RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((ToDoListApplication) getApplication()).getAppComponent().inject(this);
        thisActivity = this;
        try {
            items = getItems();
        } catch (Exception e) {

        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
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
        return dbHandler.findItems();
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
