package com.cayhualla.ecommerce_cineplanet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cayhualla.ecommerce_cineplanet.R;
import com.cayhualla.ecommerce_cineplanet.model.ListPremier;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListPremiersAdapter extends RecyclerView.Adapter<ListPremiersAdapter.ViewHolder> {

    private static String TAG = ListPremiersAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<ListPremier> premiers;


    public ListPremiersAdapter(Context context) {
        this.premiers = new ArrayList<>();
        this.context = context;

    }

    public void setListPremiers(List<ListPremier> premiers) {
        this.premiers = new ArrayList<>(premiers);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_premiers, parent, false);
        return new ViewHolder(itemView);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_pre_nom;
        private ImageView img_pre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_pre_nom = itemView.findViewById(R.id.txt_pre_nom);
            img_pre = itemView.findViewById(R.id.img_pre);

        }
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListPremier premier = this.premiers.get(position);
        String[] parts = premier.getImage().split(".jpgg");

        Picasso.with(context).load(premier.getImage()).placeholder(R.drawable.ic_no_foto).error(R.drawable.ic_no_foto).into(holder.img_pre);
        holder.txt_pre_nom.setText(premier.getDescription());

    }


    @Override
    public int getItemCount() {
        return premiers.size();
    }


}
