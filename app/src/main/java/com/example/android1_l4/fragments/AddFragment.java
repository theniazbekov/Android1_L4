package com.example.android1_l4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android1_l4.model.CharacterModel;
import com.example.android1_l4.R;
import com.google.android.material.button.MaterialButton;

public class AddFragment extends Fragment {

    private EditText edUrl, edName, edAge;
    private MaterialButton btAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edUrl = view.findViewById(R.id.ed_url);
        edName = view.findViewById(R.id.ed_name);
        edAge = view.findViewById(R.id.ed_age);
        btAdd = view.findViewById(R.id.bt_add);
        setOnClickListener();
    }

    private void setOnClickListener() {
        btAdd.setOnClickListener(view -> {
            String edURL = edUrl.getText().toString().trim();
            String edNAME = edName.getText().toString().trim();
            String edAGE = edAge.getText().toString().trim();
            if (edURL.isEmpty() && edNAME.isEmpty() && edAGE.isEmpty()) {
                edUrl.setError("error");
                edName.setError("error");
                edAge.setError("error");
            } else if (edURL.isEmpty()) {
                edUrl.setError("error");

            } else if (edNAME.isEmpty()) {
                edName.setError("error");

            } else if (edAGE.isEmpty()) {
                edAge.setError("error");
            } else {
                Bundle bundle = new Bundle();
                CharacterModel model  = new CharacterModel(edURL,edNAME,Integer.parseInt(edAGE));
                bundle.putSerializable("key", model);
                getParentFragmentManager().setFragmentResult("backStack",bundle);
                getParentFragmentManager().popBackStack();

            }
        });
    }
}