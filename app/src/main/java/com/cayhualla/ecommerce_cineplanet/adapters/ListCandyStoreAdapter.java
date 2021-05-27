package com.cayhualla.ecommerce_cineplanet.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cayhualla.ecommerce_cineplanet.R;
import com.cayhualla.ecommerce_cineplanet.model.payu.Items;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCandyStoreAdapter extends RecyclerView.Adapter<ListCandyStoreAdapter.ViewHolder> {
    private static String TAG = ListCandyStoreAdapter.class.getSimpleName();
    private Context context;
    private ArrayList<Items> items;
    private Integer[] product_units;
    private JSONArray objArray = new JSONArray();

    private ListDetailItemsInterface listDetailItemsInterface;

    public interface ListDetailItemsInterface {
        void updateList(JSONArray objArray);
    }

    public ListCandyStoreAdapter(Context context, ListDetailItemsInterface listDetailItemsInterface) {
        this.items = new ArrayList<>();
        this.context = context;
        this.listDetailItemsInterface = listDetailItemsInterface;

    }

    public void setListaSolicitudes(List<Items> items) {
        this.items = new ArrayList<>(items);
        product_units = new Integer[items.size()];
        Arrays.fill(product_units, 0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_candy_store, parent, false);
        return new ViewHolder(itemView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView it_cs_des, txt_num_pro, it_pri_des;
        private ImageView img_cs_nam;
        private Button btn_remove_pro;
        private Button btn_add_pro;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            it_cs_des = itemView.findViewById(R.id.it_cs_des);
            img_cs_nam = itemView.findViewById(R.id.img_cs_nam);
            btn_remove_pro = itemView.findViewById(R.id.btn_remove_pro);
            btn_add_pro = itemView.findViewById(R.id.btn_add_pro);
            txt_num_pro = itemView.findViewById(R.id.txt_num_pro);
            it_pri_des = itemView.findViewById(R.id.it_pri_des);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ListCandyStoreAdapter.ViewHolder holder, int position) {
        final Items items = this.items.get(position);
        insertData(null, null, 0, 0, position);

        Picasso.with(context).load(items.getName()).placeholder(R.drawable.ic_no_foto).error(R.drawable.ic_no_foto).into(holder.img_cs_nam);
        holder.it_cs_des.setText(items.getDescription());
        holder.it_pri_des.setText("S/. " + items.getPrice());
        holder.btn_add_pro.setOnClickListener(v -> {
            product_units[position]++;

            if (product_units[position] <= 0) {
                holder.btn_add_pro.setEnabled(false);
            } else {
                holder.btn_remove_pro.setEnabled(true);
                //Agregar los productos
                insertData(items.getDescription(), items.getName(), Double.parseDouble(items.getPrice()) * product_units[position], product_units[position], position);
            }

            holder.txt_num_pro.setText(product_units[position].toString());
            listDetailItemsInterface.updateList(objArray);

        });

        holder.btn_remove_pro.setOnClickListener(v -> {
            product_units[position]--;
            if (product_units[position] <= 0) {
                holder.btn_remove_pro.setEnabled(false);
                insertData(null, null, 0, 0, position);

            } else {
                insertData(items.getDescription(), items.getName(), Double.parseDouble(items.getPrice()) * product_units[position], product_units[position], position);

            }

            holder.txt_num_pro.setText(product_units[position].toString());
            listDetailItemsInterface.updateList(objArray);

            Log.e(TAG, "onBindViewHolder2: " + objArray);


        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void insertData(String description, String name, double price, int unit, int position) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("description", description);
            obj.put("name", name);
            obj.put("price", price);
            obj.put("unit", unit);

            objArray.put(position, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
