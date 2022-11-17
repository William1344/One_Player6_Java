package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.oneplayer.Front.Adapter.PlayerAdapter;
import com.example.oneplayer.R;

import java.util.Objects;

public class Membros extends AppCompatActivity {
    ListView listJogadores;
    PlayerAdapter adapter;
    CheckBox cb_apagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membros);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        load_interface();

        listJogadores.setOnItemClickListener((parent, view, position, id) -> {
            if(cb_apagar.isChecked()){
                Main_Liga.liga.getJogadores().remove(position);
                load_interface();
            }
        });
    }

    public void load_interface(){
        listJogadores = findViewById(R.id.listVmembros);
        adapter = new PlayerAdapter(Main_Liga.liga.getJogadores(),this);
        listJogadores.setAdapter(adapter);
        cb_apagar = findViewById(R.id.cB_apagar);
    }
}