package com.example.hankomin.wikiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText inputText = findViewById(R.id.edt_txt);
        Button btnSearch = findViewById(R.id.btn_serach);
         final TextView viewText = findViewById(R.id.view_txt);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String key = inputText.getText().toString();

                Thread netThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=" + key;


                            String jsonText = HttpHelper.sendGet(url);
                            GenericDeserializer<Wiki> wikiDeserializer = new GenericDeserializer<>(Wiki.class);
                            Wiki wiki = wikiDeserializer.parse(jsonText);
                            WikiQuery query = wiki.getQuery();
                            ArrayList<WikiSearch> searches = query.getSearch();
                            String result = "";
                            for (WikiSearch item : searches) {
                                result += item.getTitle() + "\n";
                                result += item.getSnippet() + "\n\n";
                            }
                            final String finalResult = result;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    viewText.setText(finalResult);
                                }
                            });

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });

                netThread.start();

            }
        });
    }


}
