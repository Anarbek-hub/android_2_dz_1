package com.example.android_2_dz_2.ui.onBord;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentBordBinding;
import com.example.android_2_dz_2.databinding.FragmentFromBinding;
import com.example.android_2_dz_2.databinding.FragmentHomeBinding;

public class OnBoardFragment extends Fragment {

    private FragmentBordBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBordBinding.inflate(inflater, container, false);
        binding.viewPager.setAdapter(new OnBoardAdapter());
        return binding.getRoot();
    }
}