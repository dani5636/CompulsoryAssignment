package com.example.mechaa.compulsoryassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //All XML objects
    GridView grdDices;
    Button btnRoll;
    ImageButton btnHistory;
    NumberPicker npDices;
    TextView txtResult;
    //Needed Objects
    ArrayList<Integer> diceRolls;
    DiceAdapter diceAdapter;
    ArrayList<HistoryEntity> historyEntities;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult= findViewById(R.id.txtResult);
        if (savedInstanceState == null) {
            diceRolls = new ArrayList<>();
            historyEntities = new ArrayList<>();
        } else { // savedInstanceState has saved values
            diceRolls = savedInstanceState.getIntegerArrayList("OneDiceRoll");
            historyEntities = (ArrayList<HistoryEntity>) savedInstanceState.getSerializable("History");
            int res= 0;
            for (Integer roll: diceRolls) {
                res+=roll;
            }
            txtResult.setText("Result: " +res);

        }

        npDices = findViewById(R.id.npDices);
        npDices.setMaxValue(6);
        npDices.setMinValue(1);


        diceAdapter = new DiceAdapter(this,diceRolls);
        grdDices= findViewById(R.id.grdDices);
        grdDices.setAdapter(diceAdapter);

        btnHistory = findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(action-> moveToHistory());

        btnRoll= findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(action -> rollDices());
        //saves important instances of objects


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putIntegerArrayList("OneDiceRoll", diceRolls);
        savedInstanceState.putSerializable("History", historyEntities);
        super.onSaveInstanceState(savedInstanceState);
    }
    private void moveToHistory(){
        Intent intent = HistoryActivity.getHistoryIntent(this);
        intent.putExtra("History", historyEntities);
        startActivity(intent);
    }
    private void rollDices() {
        diceRolls.clear();
        ArrayList<Integer> diceRollHistory = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < npDices.getValue() ; i++) {
            Random rand = new Random();
            int diceroll = rand.nextInt(6) + 1;
            diceRolls.add(diceroll);
            diceRollHistory.add(diceroll);
            result+=diceroll;
        }
        long milSeconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date rollDate = new Date(milSeconds);
        String time = sdf.format(rollDate);
        historyEntities.add(new HistoryEntity(time, diceRollHistory, result));
        diceAdapter.notifyDataSetChanged();
        txtResult.setText("Result: " + result);
        for (HistoryEntity historyEnt:historyEntities) {
            Log.d("History: ", "Date: "+ historyEnt.getTimeStamp()
                    + " Rolls: " + historyEnt.getRolls().size() + "Result: "+ historyEnt.getResult());

        }

    }
}
