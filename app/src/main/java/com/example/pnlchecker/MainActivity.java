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
        try {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Response response = client.getPNL();
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            TextView text = findViewById(R.id.Response);
                            text.setText(response.msg);
                        }
                    });
                    System.out.println(response);

                }
            });
            thread.start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        setContentView(R.layout.activity_main);
    }


}