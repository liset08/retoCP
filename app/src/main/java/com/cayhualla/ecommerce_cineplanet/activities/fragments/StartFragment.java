package com.cayhualla.ecommerce_cineplanet.activities.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cayhualla.ecommerce_cineplanet.R;
import com.cayhualla.ecommerce_cineplanet.activities.LoginActivity;
import com.cayhualla.ecommerce_cineplanet.adapters.ListCandyStoreAdapter;
import com.cayhualla.ecommerce_cineplanet.adapters.ListPremiersAdapter;
import com.cayhualla.ecommerce_cineplanet.model.CandyStore;
import com.cayhualla.ecommerce_cineplanet.model.Premiers;
import com.cayhualla.ecommerce_cineplanet.service.ApiService;
import com.cayhualla.ecommerce_cineplanet.service.ApiServiceGenerator;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StartFragment extends Fragment {

    private static String TAG = CandyStoreFragment.class.getSimpleName();
    private ApiService service = ApiServiceGenerator.createService(ApiService.class);
    private Context context;
    private RecyclerView rv_list_premiers;
    private ListPremiersAdapter adapter;

    public StartFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        rv_list_premiers = view.findViewById(R.id.rv_list_premiers);
        rv_list_premiers.setLayoutManager(new GridLayoutManager(context, 2));
        rv_list_premiers.setAdapter(new ListPremiersAdapter(context));
        adapter = (ListPremiersAdapter) rv_list_premiers.getAdapter();

        get_list_premiers();
        return view;
    }

    public void get_list_premiers() {

        Call<Premiers> call = service.list_premiers();
        call.enqueue(new Callback<Premiers>() {
            @Override
            public void onResponse(Call<Premiers> call, Response<Premiers> response) {
                try {
                    if (response.isSuccessful()) {
                        Premiers premiers = response.body();
                        adapter.setListPremiers(premiers.getPremieres());
                        adapter.notifyDataSetChanged();
                        Log.d(TAG, "Data candy store: ");
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }
                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                }
            }
            @Override
            public void onFailure(Call<Premiers> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }
}