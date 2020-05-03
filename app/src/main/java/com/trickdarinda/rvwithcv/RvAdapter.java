package com.trickdarinda.rvwithcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private LinkedList<String> linkedList;
    /*
    LayoutInflater used for reading a layout XML description
    and converts it into the corresponding View items
    */
    private LayoutInflater inflater;

    public RvAdapter(Context context, LinkedList<String> linkedList) {
        //Initiating LayoutInflater for inflater
        inflater = LayoutInflater.from(context);
        this.linkedList = linkedList;
    }

    /*
    onCreateViewHolder() inflates the item layout,
    and returns a ViewHolder with the layout and the adapter.
    */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.cv_layout, parent, false);
        return new ViewHolder(itemView, this);
    }

    /*
    onBindViewHolder() method connects your data to the view holder
    */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String pos = linkedList.get(position);
        holder.CVTextView.setText(pos);
    }

    /*
    using getItemCount() for getting the size of the LinkedList
    */
    @Override
    public int getItemCount() {
        return linkedList.size();
    }

    /*
    To connect data with View items,
    the adapter needs to know about the View items.
    The adapter uses a ViewHolder that describes a
    View item and its position within the RecyclerView.
    */

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView CVTextView;
        private RvAdapter adapter;

        public ViewHolder(@NonNull View itemView, RvAdapter adapter) {
            super(itemView);
            CVTextView = itemView.findViewById(R.id.CVText);
            this.adapter = adapter;
        }
    }
}
