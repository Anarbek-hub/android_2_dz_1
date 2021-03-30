package com.example.android_2_dz_2.ui.onBord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_2_dz_2.databinding.LayoutOnBoardBinding;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.OnBoarViewHolder> {
    private String[] list = new String[]{"Pager1", "Pager2", "Pager3"};

    @NonNull
    @Override
    public OnBoarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoarViewHolder(LayoutOnBoardBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoarViewHolder holder, int position) {
        holder.onBind();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class OnBoarViewHolder extends RecyclerView.ViewHolder {

        public OnBoarViewHolder(@NonNull LayoutOnBoardBinding itemView) {
            super(itemView.getRoot());
        }

        public void onBind() {
        }
    }
}

