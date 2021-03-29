package com.example.android_2_dz_2.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentHomeBinding;
import com.example.android_2_dz_2.ui.home.homeadapter.HomeAdapter;
import com.example.android_2_dz_2.ui.home.homeadapter.HomeModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;
    private HomeAdapter homeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        navController = NavHostFragment.findNavController(this);
        binding = FragmentHomeBinding.inflate(inflater , container ,false);
        homeAdapter = new HomeAdapter();
        onClick();
//        Green();
        binding.rv.setAdapter(homeAdapter);
        getDataInForm();
        return binding.getRoot();

    }


    private void getDataInForm(){
        getParentFragmentManager().setFragmentResultListener("key",
                getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String a = result.getString("name");
                        String b = result.getString("number");
                        Log.e("TAG", "onFragmentResult: " + a );
                        homeAdapter.addList(new HomeModel(a , b));

                    }
                });
    }
    private void onClick(){
        binding.fap.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_home_to_fromFragment);
        });

    }
    public void Green(){
        homeAdapter.addList(new HomeModel("Anarbek", "509988686"));
        homeAdapter.addList(new HomeModel("Kebrana", "509988686"));
        homeAdapter.addList(new HomeModel("Aidar", "509988686"));
        homeAdapter.addList(new HomeModel("Ali", "509988686"));
        homeAdapter.addList(new HomeModel("Argen", "509988686"));
        homeAdapter.addList(new HomeModel("Anara", "509988686"));
        homeAdapter.addList(new HomeModel("Alisultan", "509988686"));
    }

}