package com.example.dsc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

   String[] eventList;
public EventAdapter(String[] eventList, Context context) {
        this.eventList = eventList;
        }

@Override
public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);
        EventViewHolder viewHolder=new EventViewHolder(v);
        return viewHolder;
        }

@Override
public void onBindViewHolder(EventAdapter.EventViewHolder holder, int position) {
        holder.text.setText(eventList[position]);
        }

@Override
public int getItemCount() {
        return eventList.length;
        }

public static class EventViewHolder extends RecyclerView.ViewHolder{
protected TextView text;

    public EventViewHolder(View itemView) {
        super(itemView);
         text= (TextView) itemView.findViewById(R.id.text_id);
    }
}
}