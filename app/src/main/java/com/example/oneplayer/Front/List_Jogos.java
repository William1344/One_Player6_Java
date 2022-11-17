package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.oneplayer.Back.Jogos;
import com.example.oneplayer.Front.Adapter.StringAdapter;
import com.example.oneplayer.R;

import java.util.ArrayList;
import java.util.Objects;

public class List_Jogos extends AppCompatActivity {
    ArrayList<Jogos> games3x3 =  Main_Liga.liga.getList_jogos3x3(),
            games5x5 = Main_Liga.liga.getList_jogos5x5();
    ArrayList<String> jogos;
    ListView lV_jogos;
    CheckBox cb_3x3, cb_5x5;
    StringAdapter adapterS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_list_jogos);
        lV_jogos = findViewById(R.id.lV_jogos);
        cb_3x3 = findViewById(R.id.cb_3x3);
        cb_5x5 = findViewById(R.id.cb_5x5);

        cb_3x3.setOnClickListener(v -> {
            if(cb_3x3.isChecked()) {
                cb_5x5.setChecked(false);
                int x = 1;
                jogos = new ArrayList<>();
                for (Jogos j : games3x3) {
                    jogos.add(String.format("J" + x + " " + j.getToString()));
                    x++;
                }
                adapterS = new StringAdapter(jogos, this);
                lV_jogos.setAdapter(adapterS);
            }
        });

        cb_5x5.setOnClickListener(v -> {
            if(cb_5x5.isChecked()){
                cb_3x3.setChecked(false);
                int x = 1;
                jogos = new ArrayList<>();
                for (Jogos j : games5x5) {
                    jogos.add(String.format("J" + x + " " + j.getToString()));
                    x++;
                }
                adapterS = new StringAdapter(jogos, this);
                lV_jogos.setAdapter(adapterS);
            }
        });


        lV_jogos.setOnItemClickListener((parent, view, position, id) -> {
            if(cb_3x3.isChecked()){
                Intent intent = new Intent(this, ViewGame_3x3.class);
                intent.putExtra("game", games3x3.get(position));
                startActivity(intent);
                finish();
            } else if(cb_5x5.isChecked()){
                Intent intent1 = new Intent(this, ViewGame_5x5.class);
                intent1.putExtra("game", games5x5.get(position));
                startActivity(intent1);
                finish();
            }
        });
    }
}