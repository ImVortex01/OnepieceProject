package com.example.onepieceproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.onepieceproject.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ArrayList<Personajes> items;
    private Adapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.personajesBton.setOnClickListener(new View.OnClickListener() {
            final FirstFragment x = new FirstFragment();

            @Override
            public void onClick(View view) {
                if (esTablet()) {
                    Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_firstFragment);
                } else {
                    NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
                }
            }
        });

        binding.dfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esTablet()) {
                    Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_dfLayout2);
                } else {
                    NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_dfLayout);
                }
            }
        });
    }

    boolean esTablet() {
        return getResources().getBoolean(R.bool.tablet);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}