package com.example.onepieceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter2 extends ArrayAdapter<Personajes> {
    public Adapter2(Context context, int resource, int tvPersonajes, List<Personajes> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Personajes personaje = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.df_layout, parent, false);
        }


        TextView tvTitle = convertView.findViewById(R.id.tvDevilfruit);
        ImageView ivPosterImage = convertView.findViewById(R.id.imag_dfruit);

        tvTitle.setText(personaje.getDevilfruit());

        Glide.with(getContext()).load(
                personaje.getDfimage()
        ).into(ivPosterImage);
        return convertView;
    }
}