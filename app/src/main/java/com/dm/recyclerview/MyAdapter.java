package com.dm.recyclerview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Car> data;

    private OnItemClickListener listener;

    public MyAdapter(List<Car> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Car car = data.get(position);
        holder.image.setImageBitmap(car.getImage());
        holder.modelTextView.setText(car.getManufacturer()
                + " "
                + car.getName());
        holder.hpTextView.setText(car.getHorsePower() + "");
        holder.hpTextView.setBackgroundColor(car.getColor());
        if (car.isSelected()) {
            holder.itemView.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(car, holder.getAdapterPosition());
                }
            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                    data.remove(car);
                    notifyItemRemoved(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView modelTextView;
        public TextView hpTextView;
        public ImageView image;
        public Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            modelTextView = itemView.findViewById(R.id.modelTextView);
            hpTextView = itemView.findViewById(R.id.hpTextView);
            image = itemView.findViewById(R.id.image);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(Car car, int position);
    }
}
