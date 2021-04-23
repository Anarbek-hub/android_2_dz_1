package com.example.android_2_dz_2.ui.onBord;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android_2_dz_2.R;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.OnBoarViewHolder> {

    private int [] a = new int[]{R.raw.raw1,R.raw.raw2,R.raw.raw3};

    public interface OnStartClickListener {
        void onClick();

        void onClicker();
    }

    public OnStartClickListener onStartClickListener;

    public void setOnStartClickListener(OnStartClickListener onStartClickListener) {
        this.onStartClickListener = onStartClickListener;
    }

    @NonNull
    @Override
    public OnBoarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_on_board,
                parent, false);
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

        LottieAnimationView lottieAnimationView;
        Button button, start;

        public OnBoarViewHolder(@NonNull View itemView) {
            super(itemView);
            start = itemView.findViewById(R.id.btnStart);
            button = itemView.findViewById(R.id.btnNext);

           lottieAnimationView = itemView.findViewById(R.id.image_pager);
        }

        public void onBind(int position) {
            lottieAnimationView.setAnimation(a[position]);

            if (position == 2) {
                button.setVisibility(View.GONE);
            }
            if (position == 2) {
                start.setVisibility(View.VISIBLE);
            } else {
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

