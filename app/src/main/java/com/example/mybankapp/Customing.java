package com.example.mybankapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Customing extends RecyclerView.Adapter<Customing.CustomViewHolder> {

    private List<Bank_account> dataList;
    private Context context;

    public Customing.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Customing.CustomViewHolder holder, int position) {

    }


    public Customing(Context context, List<Bank_account> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            //coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
