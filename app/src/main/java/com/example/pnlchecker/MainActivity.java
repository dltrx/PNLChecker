package com.example.pnlchecker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnlchecker.adapters.ItemAdapter;
import com.example.pnlchecker.client.PNLClient;
import com.example.pnlchecker.client.FeignBuilder;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.pnlchecker.domain.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ItemViewModel itemViewModel;

    FloatingActionButton mAddFab, mAddItemUrlFab, mAddItemFab;

    TextView addAlarmActionText, addPersonActionText;

    Boolean isAllFabsVisible;

    private void toggleFabsAndTextsVisibility() {
        if (isAllFabsVisible) {
            // If currently visible, hide them
            mAddItemUrlFab.hide();
            mAddItemFab.hide();
            addAlarmActionText.setVisibility(View.GONE);
            addPersonActionText.setVisibility(View.GONE);
            mAddFab.setImageResource(R.drawable.ic_add);
            isAllFabsVisible = false;
        } else {
            // If currently hidden, show them
            mAddItemUrlFab.show();
            mAddItemFab.show();
            addAlarmActionText.setVisibility(View.VISIBLE);
            addPersonActionText.setVisibility(View.VISIBLE);
            mAddFab.setImageResource(R.drawable.ic_close);
            isAllFabsVisible = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
//        getSupportActionBar().setTitle("Whatever");
//        toolbar.setNavigationIcon(getDrawable(R.drawable.your_white_navigation_icon));

        mAddFab = findViewById(R.id.add_fab);

        mAddItemUrlFab = findViewById(R.id.add_item_url_fab);
        mAddItemFab = findViewById(R.id.add_item_fab);

        addAlarmActionText = findViewById(R.id.add_item_url_fab_text);
        addPersonActionText = findViewById(R.id.add_item_fab_text);

        // Now set all the FABs and all the action name texts as GONE
        isAllFabsVisible = true;
        toggleFabsAndTextsVisibility();

        mAddFab.setOnClickListener(view -> {
            toggleFabsAndTextsVisibility();
        });

        mAddItemUrlFab.setOnClickListener(view -> {
            toggleFabsAndTextsVisibility();
        });

        mAddItemFab.setOnClickListener(view -> {
            toggleFabsAndTextsVisibility();
        });



        PNLClient client = FeignBuilder.buildClient();
        Thread thread = new Thread(() -> {
            Item response = client.getPNL();
            System.out.println(response);

        });
        thread.start();

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