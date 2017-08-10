package com.anhlt.metronome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by tuananh on 8/10/17.
 */

public class TemposListAdapter extends BaseAdapter{
    Data data = Data.getInstance();
    Context context;
    public TemposListAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.getTemposList().size();
    }

    @Override
    public Object getItem(int i) {
        return data.getTemposList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null)
        {
            viewHolder = new ViewHolder();
            view = (LayoutInflater.from(context)).inflate(R.layout.item_tempo_list,parent,false);
            viewHolder.tvName = view.findViewById(R.id.tv_tempo_name);
            viewHolder.tvSpeedScope = view.findViewById(R.id.tv_tempo_speed_scope);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvName.setText(data.getTemposList().get(i).getName());
        viewHolder.tvSpeedScope.setText(data.getTemposList().get(i).generateSpeedScope());
        return view;
    }

    private static class ViewHolder
    {
        TextView tvName;
        TextView tvSpeedScope;
    }
}
