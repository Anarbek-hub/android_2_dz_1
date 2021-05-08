package com.example.android_2_dz_2.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
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
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(this);
        binding = FragmentFromBinding.inflate(inflater , container , false);
        onClick();
        getData();


        return binding.getRoot();
    }

    public void onClick(){
        binding.btn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("name", binding.editOne.getText().toString());
            bundle.putString("number", binding.editTwo.getText().toString());
            bundle.putInt("id", id);
            getParentFragmentManager().setFragmentResult("key", bundle);
            navController.navigateUp();
        });
    }
    public void getData(){
        getParentFragmentManager().setFragmentResultListener("2", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (requestKey.equals("2") && result != null)
                    binding.editOne.setText(result.getString("number2"));
                binding.editTwo.setText(result.getString("name2"));
                id = result.getInt("id");


            }
        });
    }

    }

