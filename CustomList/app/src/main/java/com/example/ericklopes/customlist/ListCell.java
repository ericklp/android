package com.example.ericklopes.customlist;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ericklopes on 07/04/18.
 */

public class ListCell extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] refri;
    private final Integer[] imageId;

    public ListCell(Activity context, String[] refri, Integer[] imageId) {
        super(context, R.layout.list_cell);
        this.context = context;
        this.refri = refri;
        this.imageId = imageId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.list_cell, null, true);
        TextView textTitle = (TextView) rowview.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowview.findViewById(R.id.img);
        textTitle.setText(refri[position]);
        imageView.setImageResource(imageId[position]);
        return rowview;

    }
}
