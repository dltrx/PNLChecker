package com.example.pnlchecker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnlchecker.models.MyData;
import com.example.pnlchecker.viewholders.MyViewHolder;
import com.example.pnlchecker.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView dataTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            dataTextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    //
    // Code that goes after this comment is going to be changed or deleted completely
    //

    private List<MyData> dataList;

    public MyAdapter(List<MyData> dataList) {

        this.dataList = dataList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        MyData data = dataList.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.dataTextView;
        textView.setText(data.getSymbol());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


//    @Override
//    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        // Inflate the custom layout
//        View dataView = inflater.inflate(R.layout.list_item, parent, false);
//
//        // Return a new holder instance
//        ViewHolder viewHolder = new ViewHolder(dataView);
//        return viewHolder;
//    }
//
//    // Involves populating data into the item through holder
//    @Override
//    public onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
//        // Get the data model based on position
//        MyData data = dataList.get(position);
//
//        // Set item views based on your views and data model
//        TextView textView = holder.dataTextView;
//        textView.setText(data.getSymbol());
//    }
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_item, parent, false);
//        return new MyViewHolder((View) view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        MyData data = dataList.get(position);
//        // Bind data to UI elements in each item
//        holder.textView.setText(data.getColumn1());
//        // Set other UI elements as needed
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return dataList.size();
//    }
//
//    // Method to update data in the adapter
//    public void updateData(List<MyData> newData) {
//        dataList.clear();
//        dataList.addAll(newData);
//        notifyDataSetChanged();
//    }
//
//    RecyclerView recyclerView = findViewById(R.id.recyclerView);
//    MyAdapter adapter = new MyAdapter(dataList);
//    recyclerView.setAdapter(adapter);
//    recyclerView.setLayoutManager(new LinearLayoutManager(this));

