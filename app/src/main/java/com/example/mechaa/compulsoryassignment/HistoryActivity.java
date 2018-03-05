package com.example.mechaa.compulsoryassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    Button btnClear;
    ListView listHistory;
    private ArrayList<HistoryEntity> historyEntities;
    Boolean clearHistory = false;
    HistoryAdapter historyAdapter;

    int RESULT_CLEAR = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Bundle extras = getIntent().getExtras();
        historyEntities = (ArrayList<HistoryEntity>) extras.getSerializable("History");

        if( historyEntities == null){
            historyEntities = new ArrayList<>();

        }
        historyAdapter = new HistoryAdapter(this, historyEntities);

        listHistory = findViewById(R.id.listHistory);
        listHistory.setAdapter(historyAdapter);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(action -> ClearHistory());



    }

    private void ClearHistory() {
        historyEntities.clear();
        clearHistory = true;
        historyAdapter.notifyDataSetChanged();
    }

    public static Intent getHistoryIntent(Context context){
    Intent intent = new Intent(context, HistoryActivity.class);
    return intent;
    }
    @Override
    public void onBackPressed() {
        if(clearHistory){
            setResult(RESULT_CLEAR);
        }
        else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }

}
