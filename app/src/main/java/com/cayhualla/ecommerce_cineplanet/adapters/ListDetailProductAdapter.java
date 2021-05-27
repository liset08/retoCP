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
import com.cayhualla.ecommerce_cineplanet.model.payu.Items;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListDetailProductAdapter extends RecyclerView.Adapter<ListDetailProductAdapter.ViewHolder> {
    private static String TAG = ListDetailProductAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<Items> items;

    public ListDetailProductAdapter(Context context) {
        this.items = new ArrayList<>();
        this.context = context;
    }

    public void setListDetailProductAdapter(List<Items> items) {
        this.items = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_detail_buy, parent, false);
        return new ViewHolder(itemView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_det_des_pro,txt_det_uni_pro,txt_det_pri_pro;
        private ImageView img_det_pro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_det_des_pro = itemView.findViewById(R.id.txt_det_des_pro);
            txt_det_uni_pro = itemView.findViewById(R.id.txt_det_uni_pro);
            txt_det_pri_pro = itemView.findViewById(R.id.txt_det_pri_pro);
            img_det_pro = itemView.findViewById(R.id.img_det_pro);


        }
    }

    @Override
    public void onBindViewHolder(@NonNull ListDetailProductAdapter.ViewHolder holder, int position) {

        final Items items = this.items.get(position);
        holder.txt_det_des_pro.setText(items.getDescription());
        holder.txt_det_uni_pro.setText(items.getUnit());
        float num_price = Float.parseFloat(items.getPrice());

        holder.txt_det_pri_pro.setText("S/. "+String.format("%.2f", num_price));
        Picasso.with(context).load(items.getName()).placeholder(R.drawable.ic_no_foto).error(R.drawable.ic_no_foto).into(holder.img_det_pro);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
