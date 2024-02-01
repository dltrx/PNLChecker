package com.example.pnlchecker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnlchecker.R;
import com.example.pnlchecker.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private List<Item> items = new ArrayList<>();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.textViewSymbol.setText(currentItem.getSymbol());
        holder.textViewBuyExchange.setText(currentItem.getBuyExchange());
        holder.textViewSellExchange.setText(currentItem.getSellExchange());
        holder.textViewTime.setText(currentItem.getTime());
        holder.textViewPNL.setText(String.valueOf(currentItem.getPnl()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private TextView textViewSymbol;
        private TextView textViewBuyExchange;
        private TextView textViewSellExchange;
        private TextView textViewTime;
        private TextView textViewPNL;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            textViewSymbol = itemView.findViewById(R.id.text_view_symbol);
            textViewBuyExchange = itemView.findViewById(R.id.text_view_buyExchange);
            textViewSellExchange = itemView.findViewById(R.id.text_view_sellExchange);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewPNL = itemView.findViewById(R.id.text_view_pnl);
        }
    }
}
