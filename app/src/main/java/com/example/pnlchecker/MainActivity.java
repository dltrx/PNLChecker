package com.example.pnlchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pnlchecker.client.FeignBuilder;
import com.example.pnlchecker.client.PNLClient;
import com.example.pnlchecker.domain.Response;

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
    }

    private void updateTextView(String text) {
        runOnUiThread(() -> {
            TextView textView = findViewById(R.id.Response);
            textView.setText(text);
        });
    }
}
