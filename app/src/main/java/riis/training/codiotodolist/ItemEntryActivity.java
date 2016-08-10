package riis.training.codiotodolist;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import riis.training.codiotodolist.Model.Item;

public class ItemEntryActivity extends AppCompatActivity {

    TextView dateText, timeText;
    EditText nameText, descriptionText;
    FloatingActionButton fabSave;
    RelativeLayout rootLayout;
    Button dateButton, timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_entry);

        dateText = (TextView) findViewById(R.id.dateText);
        timeText = (TextView) findViewById(R.id.timeText);

        nameText = (EditText) findViewById(R.id.nameField);
        descriptionText = (EditText) findViewById(R.id.descriptionField);

        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);

        rootLayout = (RelativeLayout) findViewById(R.id.itemEntryLayout);

        dateButton = (Button) findViewById(R.id.date);
        timeButton = (Button) findViewById(R.id.time);

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String description = descriptionText.getText().toString();
                String date = dateText.getText().toString();
                String time = timeText.getText().toString();
                if (!name.isEmpty()) {
                    DBHandler dbHandler = new DBHandler(getApplicationContext(), null, null, 1);
                    Item item = new Item();
                    item.setName(name);
                    item.setDescription(description);
                    dbHandler.addItem(item);

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

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }
}
