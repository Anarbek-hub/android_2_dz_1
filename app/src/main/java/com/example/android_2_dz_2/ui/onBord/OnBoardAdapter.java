package com.example.android_2_dz_2.ui.onBord;

import android.app.Notification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_2_dz_2.R;
import com.example.android_2_dz_2.databinding.LayoutOnBoardBinding;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.OnBoarViewHolder> {
    int [] image = {R.drawable.priora,
                    R.drawable.priora ,
                    R.drawable.priora};

    public interface OnStartClickListener{
        void onClick();
        void onClicker();
    }
    public OnStartClickListener onStartClickListener;

    public void setOnStartClickListener(OnStartClickListener onStartClickListener){
        this.onStartClickListener=onStartClickListener;
    }

    @NonNull
    @Override
    public OnBoarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_on_board,
                parent,false);
        return new OnBoarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoarViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class OnBoarViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        Button button,start;

        public OnBoarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_pager);
            start=itemView.findViewById(R.id.btnStart);
            button=itemView.findViewById(R.id.btnNext);
        }

        public void onBind(int position){
            imageView.setImageResource(image[position]);
            if (position==2){
                button.setVisibility(View.GONE);
            }
            if (position==2){
                start.setVisibility(View.VISIBLE);
            }
            else {
                start.setVisibility(View.GONE);
            }
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStartClickListener.onClick();
                }
            });
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStartClickListener.onClicker();
                }
            });
        }
    }
}

