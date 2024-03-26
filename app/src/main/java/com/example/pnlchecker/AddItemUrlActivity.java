package com.example.pnlchecker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddItemUrlActivity extends AppCompatActivity {
    private EditText editTextSymbolUrl;
    private EditText editTextBuyExchangeUrl;
    private EditText editTextSellExchangeUrl;
    private EditText editTextTimeUrl;
    private EditText editTextPnlUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_item_url);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        editTextSymbolUrl = findViewById(R.id.add_item_symbol_url);
        editTextBuyExchangeUrl = findViewById(R.id.add_item_buyExchange_url);
        editTextSellExchangeUrl = findViewById(R.id.add_item_sellExchange_url);
        editTextTimeUrl = findViewById(R.id.add_item_time_url);
        editTextPnlUrl = findViewById(R.id.add_item_pnl_url);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Item via URLs");
    }

    private void saveItem() {
        String symbolUrl = editTextSymbolUrl.getText().toString();
        String buyExchangeUrl = editTextBuyExchangeUrl.getText().toString();
        String sellExchangeUrl = editTextSellExchangeUrl.getText().toString();
        String timeUrl = editTextTimeUrl.getText().toString();
        String pnlUrl = editTextPnlUrl.getText().toString();

        if (symbolUrl.trim().isEmpty() || buyExchangeUrl.trim().isEmpty() || sellExchangeUrl.trim().isEmpty() || timeUrl.trim().isEmpty() || pnlUrl.trim().isEmpty()) {
            Toast.makeText(this, "Please, insert any information", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_item) {
            saveItem();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}