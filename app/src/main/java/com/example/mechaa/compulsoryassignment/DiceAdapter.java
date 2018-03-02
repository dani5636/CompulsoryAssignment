package com.example.mechaa.compulsoryassignment;

import android.app.Activity;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Mechaa on 01-03-2018.
 */

public class DiceAdapter extends BaseAdapter {
    private ArrayList<Integer> rolls;
    private final Activity context;

    public DiceAdapter(Activity context, ArrayList<Integer> rolls) {
        this.context = context;
        this.rolls = rolls;
    }
    @Override
    public int getCount() {
        return rolls.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View rowView = view;
        //reuse views
        if(rowView==null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.dice_grid,null);
            //configure viewholder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.imgDice = (ImageView)rowView.findViewById(R.id.imgDice);
            rowView.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        setDice(rolls.get(pos),holder.imgDice);

        return rowView;
    }
    private void setDice(int diceRoll,ImageView imgDice)
    {
        Log.d("DiceCheck","Rolled: "+ diceRoll);
        switch (diceRoll){
            case 1: imgDice.setImageResource(R.drawable.dice_one);
                break;
            case 2: imgDice.setImageResource(R.drawable.dice_two);
                break;
            case 3: imgDice.setImageResource(R.drawable.dice_three);
                break;
            case 4: imgDice.setImageResource(R.drawable.dice_four);
                break;
            case 5: imgDice.setImageResource(R.drawable.dice_five);
                break;
            case 6: imgDice.setImageResource(R.drawable.dice_six);
                break;
        }
    }
    static class ViewHolder
    {
        public ImageView imgDice;
    }
}
