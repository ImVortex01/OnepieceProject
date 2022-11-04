package com.example.onepieceproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.onepieceproject.databinding.FragmentDetallesPersonajesBinding;


public class DetallesPersonajes extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentDetallesPersonajesBinding binding;
    private String mParam1;
    private String mParam2;

    public DetallesPersonajes() {
        // Required empty public constructor
    }

    public static DetallesPersonajes newInstance(String param1, String param2) {
        DetallesPersonajes fragment = new DetallesPersonajes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallesPersonajesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        Bundle args = getArguments();
        if (args != null) {
            Personajes personaje = (Personajes) args.getSerializable("item");
            if (personaje != null) {
                actualizar(personaje);
            }
        }
        return view;
    }

    private void actualizar(@NonNull Personajes personaje) {
        binding.pjNombre.setText("Nombre: " + personaje.getName());
        binding.pjRace.setText("Raza: " + personaje.getRace());
        binding.tvEdad.setText("Edad: " + personaje.getAge());
        binding.pjAltura.setText("Altura: " + personaje.getHeight());
        binding.pjFruta.setText("Fruta: " + personaje.getDevilfruit());
        Glide.with(getContext()).load(
                personaje.getUserimg()
        ).into(binding.imagPersonaje);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}