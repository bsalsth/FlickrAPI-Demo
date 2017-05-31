package com.softlica.bishal.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softlica.bishal.myapplication.Model.Number;
import com.softlica.bishal.myapplication.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by bishal on 2/9/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    //Creating custom onclick listener to handle click from activity
    public interface OnClickListener {
        public void onCutomAdapterClick(Number number, int position);
    }

    List<Number> data = Collections.emptyList();
    private static Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Number no = data.get(position);
        holder.mTextView.setText(no.getValue()+"");

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCutomAdapterClick(no, position);
            }
        });

    }

    public void setData(List<Number> data) {
        this.data = data;
        notifyItemRangeChanged(0, data.size());


    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.item);
        }
    }

}
