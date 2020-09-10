package com.example.dsc.ui.home;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dsc.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE = 1;
   // private final Context context;
    private final List<Object> listRecyclerItem;

    public RecyclerAdapter(HomeFragment context, List<Object> listRecyclerItem) {
        //this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.list_item, viewGroup, false);

                return new ItemViewHolder((layoutView));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int viewType = getItemViewType(i);

        switch (viewType) {
            case TYPE:
            default:

                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                Events events = (Events) listRecyclerItem.get(i);

                itemViewHolder.name.setText(events.getName());
                itemViewHolder.date.setText(events.getDate());
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}