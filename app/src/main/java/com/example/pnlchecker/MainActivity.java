package com.example.pnlchecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemAdapter adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getAllItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
            adapter.setItems(items);
            }
        });


//        PNLClient client = FeignBuilder.buildClient();
//        Thread thread = new Thread(() -> {
//            Response response = client.getPNL();
//            updateTextView(response.msg);
//        });
//        thread.start();
//        setContentView(R.layout.activity_main);
//
//
//    private void updateTextView(String text) {
//        runOnUiThread(() -> {
//            TextView textView = findViewById(R.id.Response);
//            textView.setText(text);
//        });
    }
}