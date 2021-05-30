package com.example.pythonfire;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Draw> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Draw> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false); //뷰 연결
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
       Glide.with(holder.itemView)
               .load(arrayList.get(position).getProfile())
               .into(holder.iv_profle);
       holder.tv_id.setText(arrayList.get(position).getId());
       holder.tv_pw.setText(arrayList.get(position).getPw());
        holder.tv_linkk.setText(arrayList.get(position).getLinkk());
//       holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
//       holder.tv_userName.setText(arrayList.get(position).getUserName());
//        holder.tv_store.setText(arrayList.get(position).getStore());
//        holder.tv_date.setText(arrayList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        //삼항연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profle;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_linkk;
//        TextView tv_userName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profle = itemView.findViewById((R.id.iv_profile));
            this.tv_id = itemView.findViewById((R.id.tv_id));
            this.tv_pw = itemView.findViewById((R.id.tv_pw));
            this.tv_linkk = itemView.findViewById(R.id.tv_linkk);

            tv_linkk.setAutoLinkMask(Linkify.WEB_URLS);
//            this.tv_userName = itemView.findViewById((R.id.tv_userName));


        }
    }
}
