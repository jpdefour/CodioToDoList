package riis.training.codiotodolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import riis.training.codiotodolist.model.Item;
import riis.training.codiotodolist.model.ItemViewHolder;

/**
 * Created by John on 8/8/2016.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<Item> items;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_layout, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item currentItem = items.get(position);
        TextView name = holder.getNameText();
        name.setText(currentItem.getName());
        holder.setNameText(name);

        holder.getDescriptionText().setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
