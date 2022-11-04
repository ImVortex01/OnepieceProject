package com.example.onepieceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.example.onepieceproject.databinding.LvOnepieceBinding;

import java.util.List;

public class Adapter extends ArrayAdapter<Personajes> {
    public Adapter(Context context, int resource, int tvPersonajes, List<Personajes> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Personajes personaje = getItem(position);
        LvOnepieceBinding binding = null;

        if (convertView == null) {
            binding = LvOnepieceBinding.inflate(LayoutInflater.from(getContext()), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (LvOnepieceBinding) convertView.getTag();
        }

        binding.tvPersonajes.setText(personaje.getName());
        Glide.with(getContext()).load(
                personaje.getUserimg()
        ).into(binding.personajeImg);

        return binding.getRoot();
    }
}
