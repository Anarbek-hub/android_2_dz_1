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
import com.example.android_2_dz_2.utils.App;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>  {
    private ItemLayoutBinding binding;
    private List<HomeModel> list = new ArrayList();
    private  Listen listen;


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent ,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position), listen);
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

//    public void addElement(HomeModel homeModel){
//        list.add(homeModel);
//        notifyDataSetChanged();
//    }
    public void addList(List<HomeModel> homeModelList){
        list = homeModelList;
        notifyDataSetChanged();
    }
    public HomeAdapter(Listen listen){
        this.listen = listen;
    }

    public HomeModel getModelToId(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return list.get(i);
            }
        }
        return null;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {


        public HomeViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void onBind(HomeModel homeModel, Listen listen) {
            binding.march1.setText(homeModel.getDate());
            binding.march2.setText(homeModel.getEditDate());
            binding.nameItem.setText(homeModel.getName());
            binding.numberItem.setText(homeModel.getNumber());




            binding.getRoot().setOnClickListener(v -> {
               Toast.makeText(binding.getRoot().getContext(),"post "
                        + getAdapterPosition(), Toast.LENGTH_LONG).show();
               listen.setDataForForm(homeModel,getAdapterPosition());
            });

            binding.getRoot().setOnLongClickListener(v -> {
                AlertDialog.Builder adg = new AlertDialog.Builder(binding.getRoot().getContext());
                String positive = "ДА";
                String negative = "НЕТ";
                adg.setMessage("Вы хотите удалить ?");
                adg.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        App.database.noteDao().dalete(homeModel);
                        notifyItemChanged(getAdapterPosition());
                    }




                });
                adg.setNegativeButton(negative, null);
                adg.show();
                return true;

            });






        }
    }
}
