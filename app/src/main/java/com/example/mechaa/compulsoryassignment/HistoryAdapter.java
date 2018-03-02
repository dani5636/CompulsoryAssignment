package com.example.mechaa.compulsoryassignment;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mechaa on 02-03-2018.
 */

public class HistoryAdapter extends BaseAdapter {
    private ArrayList<HistoryEntity> history;
    private final Activity context;

    public HistoryAdapter(Activity context, ArrayList<HistoryEntity> history) {
        this.context = context;
        this.history = history;
    }
    @Override
    public int getCount() {
        return history.size()+1;
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
            rowView = inflater.inflate(R.layout.history_row_layout,null);
            //configure viewholder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtTimeStamp = rowView.findViewById(R.id.txtTimeStamp);
            viewHolder.txtDiceRolls = rowView.findViewById(R.id.txtDiceRolls);
            viewHolder.txtResultHis = rowView.findViewById(R.id.txtResultHis);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        if(pos == 0){
            holder.txtTimeStamp.setText("Time Stamp");
            holder.txtDiceRolls.setText("Dice Rolls");
            holder.txtResultHis.setText("Result");
        }
        else {
            pos--;
            HistoryEntity entity = history.get(pos);
            holder.txtTimeStamp.setText(entity.getTimeStamp());
            String rolls = "";
            rolls = rolls + entity.getRolls().get(0);
            for (int i = 1; i < entity.getRolls().size(); i++) {
                rolls = rolls + ", " + entity.getRolls().get(i);
            }
            holder.txtDiceRolls.setText(rolls);
            holder.txtResultHis.setText(entity.getResult()+"");
        }
        return rowView;


    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    static class ViewHolder
    {
        TextView txtDiceRolls, txtResultHis, txtTimeStamp;
    }
}
