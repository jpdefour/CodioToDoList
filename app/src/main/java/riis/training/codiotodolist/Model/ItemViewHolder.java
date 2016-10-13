package riis.training.codiotodolist.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import riis.training.codiotodolist.R;

/**
 * Created by John on 8/8/2016.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder{
    private TextView nameText;
    private TextView descriptionText;
    private CheckBox checkBox;

    public ItemViewHolder(View itemView) {
        super(itemView);
        nameText = (TextView) itemView.findViewById(R.id.name);
        descriptionText = (TextView) itemView.findViewById(R.id.descripton);
    }

    public TextView getNameText() {
        return nameText;
    }

    public void setNameText(TextView nameText) {
        this.nameText = nameText;
    }

    public TextView getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(TextView descriptionText) {
        this.descriptionText = descriptionText;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
