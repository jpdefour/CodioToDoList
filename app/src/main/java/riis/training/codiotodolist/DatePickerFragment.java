package riis.training.codiotodolist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

import javax.inject.Inject;

import riis.training.codiotodolist.dagger.ToDoListApplication;

/**
 * Created by John on 8/10/2016.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    // Use the current date as the default date in the picker
    @Inject Calendar c;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ((ToDoListApplication) getActivity().getApplication()).getAppComponent().inject(this);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        TextView dateText = (TextView)getActivity().findViewById(R.id.dateText);
        String dateString = monthOfYear + "/" + dayOfMonth + "/" + year;
        dateText.setText(dateString);
    }
}
