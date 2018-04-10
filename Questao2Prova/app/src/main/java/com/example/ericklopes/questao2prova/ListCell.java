package com.example.ericklopes.questao2prova;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ericklopes on 09/04/18.
 */

public class ListCell extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nome;
    private final String[] partido;

    public ListCell(Activity context, String[] nome, String[] partido) {
        super(context, R.layout.activity_list_cell, time);
        this.context = context;
        this.nome = nome;
        this.partido = partido;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.activity_list_cell, null, true);
        TextView textTitle = rowview.findViewById(R.id.);
        TextView partidoTitle = rowview.findViewById(R.id.);
        textTitle.setText(time[position]);
        imageView.setImageResource(imageId[position]);
        return rowview;

    }
}
