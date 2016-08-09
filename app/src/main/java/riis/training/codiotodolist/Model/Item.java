package riis.training.codiotodolist.Model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by John on 8/8/2016.
 */
public class Item {
    private String name;
    private String description;
    private boolean isChecked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
