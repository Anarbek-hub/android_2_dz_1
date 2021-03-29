package com.example.android_2_dz_2.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentFromBinding;


public class FromFragment extends Fragment {
    private NavController navController;
    private FragmentFromBinding binding;
    private String s = "Поле  не должен быть пустым";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(this);
        binding = FragmentFromBinding.inflate(inflater , container , false);
        onClick();


        return binding.getRoot();
    }
    public void onClick(){
        binding.btn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.editOne.getText().toString());
            bundle.putString("number", binding.editTwo.getText().toString());
            getParentFragmentManager().setFragmentResult("key", bundle);
            navController.navigateUp();
        });
    }
    }

