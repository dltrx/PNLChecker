package com.example.pnlchecker.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pnlchecker.R;


public class MyViewHolder extends RecyclerView.ViewHolder {

    // Declare your UI elements here
    public TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        // Initialize UI elements
        textView = itemView.findViewById(R.id.textView);
    }
}