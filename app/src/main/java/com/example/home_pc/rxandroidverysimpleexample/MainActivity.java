package com.example.home_pc.rxandroidverysimpleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLoad;
    ListView listView;
    ArrayList<String> jokes = new ArrayList<>();
    public static final String baseUrl = "http://www.icndb.com/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = findViewById(R.id.btnSet);
        btnLoad.setOnClickListener(this);
        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jokes);
    }


    @Override
    public void onClick(View v) {

    }
}
