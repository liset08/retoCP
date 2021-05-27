package com.cayhualla.ecommerce_cineplanet.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cayhualla.ecommerce_cineplanet.R;
import com.cayhualla.ecommerce_cineplanet.activities.fragments.CandyStoreFragment;
import com.cayhualla.ecommerce_cineplanet.activities.fragments.StartFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private Dialog ald_message_welcome;
    private String st_email, st_name;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        st_email = sharedPreferences.getString("st_email", "");
        st_name = sharedPreferences.getString("st_name", "");

        bottomNavigationView = findViewById(R.id.bn_main);

        //Validar datos enviados del Login Activity
        Bundle parameters = this.getIntent().getExtras();
        if (parameters != null) {
            boolean state = getIntent().getExtras().getBoolean("state", false);
            if (state) {
                showMessageWelcome();
            }
            showFragment(new StartFragment());
        }else {
            showFragment(new CandyStoreFragment());

        }




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.nb_home) {
                    showFragment(new StartFragment());
                }
                if (menuItem.getItemId() == R.id.nb_dulceria) {
                    showFragment(new CandyStoreFragment());
                }
                if (menuItem.getItemId() == R.id.nb_login) {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplication(), LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commitAllowingStateLoss();
    }



    private void showMessageWelcome() {
        ald_message_welcome = new Dialog(this);
        ald_message_welcome.setContentView(R.layout.dialog_message_welcome);
        Button btn_dlg_ace_usr = ald_message_welcome.findViewById(R.id.btn_dlg_ace_usr);
        TextView txt_dlg_welcome = ald_message_welcome.findViewById(R.id.txt_dlg_welcome);

        txt_dlg_welcome.setText("Bienvenido(a) " +st_name+ ", su correo registrado es " +st_email);
        btn_dlg_ace_usr.setOnClickListener(v -> {
            ald_message_welcome.dismiss();
            showFragment(new CandyStoreFragment());

        });
        ald_message_welcome.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ald_message_welcome.show();
    }
}