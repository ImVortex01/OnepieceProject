package com.example.onepieceproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.onepieceproject.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private ArrayList<Personajes> items;
    private Adapter adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter = new Adapter(
                getContext(),
                R.layout.lv_onepiece,
                R.id.tvPersonajes,
                items
        );


        binding.lvOnepiece.setAdapter(adapter);
        refresh();

        binding.lvOnepiece.setOnItemClickListener((adapter, fragment, i, l) -> {
            Personajes personajes = (Personajes) adapter.getItemAtPosition(i);
            Bundle args = new Bundle();
            Personajes item = (Personajes) adapter.getItemAtPosition(i);

            args.putSerializable("item", item);

            if (esTablet()) {
                NavHostFragment.findNavController(
                        this
                ).navigate(R.id.action_firstFragment_to_detallesPersonajes2, args);
            } else {
                NavHostFragment.findNavController(
                        this
                ).navigate(R.id.action_FirstFragment_to_detallesPersonajes, args);

            }
        });
    }

    private void refresh() {
        Toast.makeText(getContext(), "Refrescando..", Toast.LENGTH_LONG).show();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            URLS api = new URLS();
            ArrayList<Personajes> personajes = api.getPersonajes();
            handler.post(() -> {
                adapter.clear();
                adapter.addAll(personajes);
            });
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