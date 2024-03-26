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

public class AddItemActivity extends AppCompatActivity {
    private EditText editTextSymbol;
    private EditText editTextBuyExchange;
    private EditText editTextSellExchange;
    private EditText editTextTime;
    private EditText editTextPnl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_item);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        editTextSymbol = findViewById(R.id.add_item_symbol);
        editTextBuyExchange = findViewById(R.id.add_item_buyExchange);
        editTextSellExchange = findViewById(R.id.add_item_sellExchange);
        editTextTime = findViewById(R.id.add_item_time);
        editTextPnl = findViewById(R.id.add_item_pnl);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Item");
    }

    private void saveItem() {
        String symbol = editTextSymbol.getText().toString();
        String buyExchange = editTextBuyExchange.getText().toString();
        String sellExchange = editTextSellExchange.getText().toString();
        String time = editTextTime.getText().toString();
        String pnl = editTextPnl.getText().toString();

        if (symbol.trim().isEmpty() || buyExchange.trim().isEmpty() || sellExchange.trim().isEmpty() || time.trim().isEmpty() || pnl.trim().isEmpty()) {
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