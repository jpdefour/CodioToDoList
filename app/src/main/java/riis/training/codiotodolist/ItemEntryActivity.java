package riis.training.codiotodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ItemEntryActivity extends AppCompatActivity {

    EditText nameText, descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_entry);

        nameText = (EditText) findViewById(R.id.nameField);
        descriptionText = (EditText) findViewById(R.id.descriptionField);


    }
}
