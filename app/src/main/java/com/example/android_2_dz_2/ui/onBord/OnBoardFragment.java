package com.example.android_2_dz_2.ui.onBord;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentBordBinding;
import com.example.android_2_dz_2.databinding.FragmentFromBinding;
import com.example.android_2_dz_2.databinding.FragmentHomeBinding;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

public class OnBoardFragment extends Fragment {

    private OnBoardAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bord_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager);
        SpringDotsIndicator indicator = view.findViewById(R.id.springDotsIndicator);
        adapter = new OnBoardAdapter();
        viewPager2.setAdapter(adapter);
        indicator.setViewPager2(viewPager2);
        adapter.setOnStartClickListener(new OnBoardAdapter.OnStartClickListener() {
            @Override
            public void onClick() {
                NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigateUp();
            }

            @Override
            public void onClicker() {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
            }
        });

    }
}