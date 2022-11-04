package com.example.onepieceproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.onepieceproject.databinding.FragmentDfLayoutBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class dfLayout extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentDfLayoutBinding binding;
    private String mParam1;
    private String mParam2;
    private ArrayList<Personajes> items;
    private Adapter2 adapter;

    public dfLayout() {

    }

    public static dfLayout newInstance(String param1, String param2) {
        dfLayout fragment = new dfLayout();
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
        binding = FragmentDfLayoutBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        items = new ArrayList<>();
        adapter = new Adapter2(
                getContext(),
                R.layout.df_layout,
                R.id.tvDevilfruit,
                items
        );

        binding.lvDevilfruits.setAdapter(adapter);
        refresh();

        binding.lvDevilfruits.setOnItemClickListener((adapter, fragment, i, l) -> {
            Personajes personajes = (Personajes) adapter.getItemAtPosition(i);
            Bundle args = new Bundle();
            Personajes item = (Personajes) adapter.getItemAtPosition(i);

            args.putSerializable("item", item);

        });
    }

    private void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            URLS api = new URLS();
            ArrayList<Personajes> personajes = api.getPersonajes2();
            handler.post(() -> {
                adapter.clear();
                adapter.addAll(personajes);
            });
        });
    }
}