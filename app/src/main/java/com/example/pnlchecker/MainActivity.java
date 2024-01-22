package com.example.pnlchecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pnlchecker.models.MyData;
import com.example.pnlchecker.utils.MyDatabaseHelper;
import com.example.pnlchecker.adapters.*;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pnlchecker.client.FeignBuilder;
import com.example.pnlchecker.client.PNLClient;
import com.example.pnlchecker.domain.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PNLClient client = FeignBuilder.buildClient();
        Thread thread = new Thread(() -> {
            Response response = client.getPNL();
            updateTextView(response.msg);
        });
        thread.start();
        setContentView(R.layout.activity_main);
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Initialize data
        dataList = MyData.createDataList();
        // Create adapter passing in the sample user data
        MyAdapter adapter = new MyAdapter(dataList);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
    List<MyData> dataList = dbHelper.getLocalData();


    private void updateTextView(String text) {
        runOnUiThread(() -> {
            TextView textView = findViewById(R.id.Response);
            textView.setText(text);
        });
    }
}