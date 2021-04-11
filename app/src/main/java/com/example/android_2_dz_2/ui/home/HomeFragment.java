package com.example.android_2_dz_2.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.FragmentHomeBinding;
import com.example.android_2_dz_2.ui.home.homeadapter.HomeAdapter;
import com.example.android_2_dz_2.ui.home.homeadapter.HomeModel;
import com.example.android_2_dz_2.ui.home.homeadapter.Listen;
import com.example.android_2_dz_2.utils.App;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements Listen {

    private FragmentHomeBinding binding;
    private NavController navController;
    private HomeAdapter homeAdapter;
    private List<HomeModel> list = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeAdapter = new HomeAdapter( this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        navController = NavHostFragment.findNavController(this);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        App.database.noteDao().getAll().observe(getViewLifecycleOwner(), new Observer<List<HomeModel>>() {
            @Override
            public void onChanged(List<HomeModel> homeModelList) {
                homeAdapter.addList(homeModelList);
            }
        });
        binding.rv.setAdapter(homeAdapter);
        getDataInForm();
        click();

        return binding.getRoot();

    }


    private void getDataInForm() {
        getParentFragmentManager().setFragmentResultListener("key",
                getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String name = result.getString("name");
                        String number = result.getString("number");
                        int id = result.getInt("id");

                        HomeModel homeModel = homeAdapter.getModelToId(id);
                        if (homeModel != null) {
                            homeModel.setName(name);
                            homeModel.setNumber(number);
                            App.database.noteDao().updata(homeModel);
                        } else {
                            App.database.noteDao().insert(new HomeModel(name, number));
                        }
                    }


                });
        }
//    public void Green(){
//        homeAdapter.addElement(new HomeModel("Anarbek", "509988686", id))


    @Override
    public void setDataForForm(HomeModel homeModel, int position) {
        Bundle bundle = new Bundle();

        bundle.putString("name2",homeModel.getName());
        bundle.putString("number2",homeModel.getNumber());
        bundle.putInt("id",homeModel.getId());
        getParentFragmentManager().setFragmentResult("2",bundle);
        navController.navigate(R.id.action_navigation_home_to_fromFragment);
    }
    public void click(){
        binding.fap.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_home_to_fromFragment);
        });
    }
}

