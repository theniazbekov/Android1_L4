package com.example.android1_l4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.android1_l4.model.CharacterModel;
import com.example.android1_l4.R;

public class DetailFragment extends Fragment {


    private ImageView ivImage;
    private CharacterModel model;
    private TextView tvName, tvAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivImage = view.findViewById(R.id.iv_image);
        tvName = view.findViewById(R.id.tv_name);
        tvAge = view.findViewById(R.id.tv_age);
        getData();
    }

    private void getData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            model = (CharacterModel) arguments.getSerializable("name");
            Glide.with(ivImage.getContext()).load(model.getImageUrl()).into(ivImage);
            tvName.setText(model.getName());
            tvAge.setText(String.valueOf(model.getAge()));
        }
    }
}