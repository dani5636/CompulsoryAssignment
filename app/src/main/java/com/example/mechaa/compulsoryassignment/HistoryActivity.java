package com.example.mechaa.compulsoryassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listHistory;
    private ArrayList<HistoryEntity> historyEntities;
    HistoryAdapter historyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Log.d("Created Activity", "1");
        Bundle extras = getIntent().getExtras();
        historyEntities = (ArrayList<HistoryEntity>) extras.getSerializable("History");

        Log.d("Created Activity", "2");
        if( historyEntities == null){
            historyEntities = new ArrayList<>();

            Log.d("Created Activity", "2a");
        }
        historyAdapter = new HistoryAdapter(this, historyEntities);

        Log.d("Created Activity", "3");
        listHistory = findViewById(R.id.listHistory);
        listHistory.setAdapter(historyAdapter);

        Log.d("Created Activity", "4");



    }

    public static Intent getHistoryIntent(Context context){
    Intent intent = new Intent(context, HistoryActivity.class);

    return intent;
    }
}
