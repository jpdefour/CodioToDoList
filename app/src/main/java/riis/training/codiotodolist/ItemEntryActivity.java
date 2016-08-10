package riis.training.codiotodolist;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ItemEntryActivity extends AppCompatActivity {

    EditText nameText, descriptionText;
    FloatingActionButton fabSave;
    RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_entry);

        nameText = (EditText) findViewById(R.id.nameField);
        descriptionText = (EditText) findViewById(R.id.descriptionField);

        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);

        rootLayout = (RelativeLayout) findViewById(R.id.itemEntryLayout);

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();
                if (!name.isEmpty()) {


                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("name", name);
                    returnIntent.putExtra("description", description);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else {
                    Snackbar.make(rootLayout, "Please put in a name.", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }
}
