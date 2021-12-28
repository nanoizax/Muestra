package com.devs.muestra.Adaptadores;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.muestra.Mapeo.MProductos;

import com.devs.muestra.Util.Funciones;
import com.devs.muestra.Util.Globales;
import com.devs.muestra.Web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import muestra.R;

public class ADEstaciones extends RecyclerView.Adapter<ADEstaciones.NewsViewHolder>  {

    Context mContext;
    List<MProductos> mData;
    private List<MProductos> originalItems;
    Globales g = new Globales();
    Funciones f = new Funciones();

    public ADEstaciones(Context mContext, List<MProductos> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.originalItems = new ArrayList<>();
        originalItems.addAll(mData);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item,viewGroup,false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, @SuppressLint("RecyclerView") int position) {

        newsViewHolder.tv_author.setText(mData.get(position).getAuthor());
        newsViewHolder.tv_title.setText(mData.get(position).getStory_title());
        newsViewHolder.tv_created.setText(mData.get(position).getCreated_at());

        for (int i = 0; i < g.eliminados.size(); i++) {
            String id = g.eliminados.get(i);
            String comparacion = mData.get(position).getStory_id();
            if (id.equals(comparacion)){
                newsViewHolder.c_estaciones.setVisibility(View.GONE);
                newsViewHolder.c_borrar.setVisibility(View.GONE);
            }
        }

        newsViewHolder.c_estaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                g.url = mData.get(position).getStory_url();
                f.go((Activity) mContext, Web.class);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void filter(final String strSearch){
        if (strSearch.length() == 0) {
            mData.clear();
            mData.addAll(originalItems);
        }
        else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mData.clear();
                List<MProductos> collect = originalItems.stream()
                        .filter(i -> i.getStory_title().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());

                mData.addAll(collect);
            }
            else {
                mData.clear();
                for (MProductos i : originalItems) {
                    if (i.getStory_title().toLowerCase().contains(strSearch)) {
                        mData.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_author, tv_created;

        RelativeLayout container;

        public ConstraintLayout c_estaciones;

        public RelativeLayout c_borrar;

        public NewsViewHolder(@NonNull View itemView) {

            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_title = itemView.findViewById(R.id.lbl_titulo);
            tv_author = itemView.findViewById(R.id.lbl_author);
            tv_created = itemView.findViewById(R.id.lbl_create);
            c_estaciones = itemView.findViewById(R.id.c_estaciones);
            c_borrar = itemView.findViewById(R.id.c_borrar);

        }

    }

    public void removeItem(int position){
        g.eliminados.add(mData.get(position).getStory_id());

        mData.remove(position);
        notifyItemRemoved(position);

    }

    public void restoreItem(MProductos mProductos,int position){
        mData.add(position, mProductos);
        notifyItemInserted(position);
    }





}
