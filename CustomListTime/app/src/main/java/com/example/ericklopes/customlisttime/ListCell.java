package com.example.ericklopes.customlisttime;

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
    private final String[] time;
    private final Integer[] imageId;

    public ListCell(Activity context, String[] time, Integer[] imageId) {
        super(context, R.layout.list_cell, time);
        this.context = context;
        this.time = time;
        this.imageId = imageId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.list_cell, null, true);
        TextView textTitle = rowview.findViewById(R.id.txt);
        ImageView imageView = rowview.findViewById(R.id.img);
        textTitle.setText(time[position]);
        imageView.setImageResource(imageId[position]);
        return rowview;

    }
}
