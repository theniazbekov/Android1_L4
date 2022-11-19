package com.example.android1_l4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1_l4.adapter.Adapter;
import com.example.android1_l4.model.CharacterModel;
import com.example.android1_l4.model.CharacterRepository;
import com.example.android1_l4.OnItemClickListener;
import com.example.android1_l4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecyclerFragment extends Fragment implements OnItemClickListener {

    private final CharacterRepository repository = new CharacterRepository();
    private final Adapter adapter = new Adapter(this);
    private RecyclerView rvCharacters;
    private FloatingActionButton buttonAdd;
    private EditText edUrl, edName, edAge;
    private CharacterModel model;
    private List<CharacterModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCharacters = view.findViewById(R.id.rv_characters);
        buttonAdd = view.findViewById(R.id.btn_add);
        edUrl = view.findViewById(R.id.ed_url);
        edName = view.findViewById(R.id.ed_name);
        edAge = view.findViewById(R.id.ed_age);
        initialize();
        setUpListeners();
        adapter.setData(repository.getListOfCharacters());
        onAdd();
        list = repository.getListOfCharacters();
    }

    private void initialize() {
        rvCharacters.setAdapter(adapter);
    }

    @Override
    public void onClick(CharacterModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("name", model);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, DetailFragment.class, bundle)
                .addToBackStack("RecyclerFragment")
                .commit();
    }


    private void setUpListeners() {
        buttonAdd.setOnClickListener((View view) -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AddFragment())
                    .addToBackStack("RecyclerFragment")
                    .commit();
        });
    }

    private void onAdd() {
        requireActivity().getSupportFragmentManager().setFragmentResultListener("backStack", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (requestKey.equals("backStack")) {
                    model = (CharacterModel) result.getSerializable("key");
                    list.add(model);
                    adapter.setData(list);

                }
            }
        });
    }
}

