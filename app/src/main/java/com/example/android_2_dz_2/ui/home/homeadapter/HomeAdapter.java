package com.example.android_2_dz_2.ui.home.homeadapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_2_dz_2.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>  {
    private ItemLayoutBinding binding;
    private List<HomeModel> list = new ArrayList();


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent ,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position));
        if (position % 2 == 0) {
            binding.holderItem.setBackgroundColor(Color.GREEN);
        } else {
            binding.holderItem.setBackgroundColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(HomeModel homeModel){
        list.add(homeModel);
        notifyDataSetChanged();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {


        public HomeViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void onBind(HomeModel homeModel) {

            binding.nameItem.setText(homeModel.getName());
            binding.numberItem.setText(homeModel.getNumber());

//            binding.getRoot().setOnClickListener(v -> {
//                Toast.makeText(binding.getRoot().getContext(),"post "
//                        + getAdapterPosition(), Toast.LENGTH_LONG).show();
//
//            });

            binding.getRoot().setOnLongClickListener(v -> {
                AlertDialog.Builder adg = new AlertDialog.Builder(binding.getRoot().getContext());
                String positive = "ДА";
                String negative = "НЕТ";
                adg.setMessage("Вы хотите удалить ?");
                adg.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(getAdapterPosition());
                        notifyDataSetChanged();
                    }
                });
                adg.setNegativeButton(negative, null);
                adg.show();
                return true;

            });






        }
    }
}
