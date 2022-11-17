package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oneplayer.Back.Player_Game;
import com.example.oneplayer.Front.Adapter.StringAdapter;
import com.example.oneplayer.R;

import java.util.ArrayList;
import java.util.Objects;

public class Substituto_View extends AppCompatActivity {
    private ListView lV_subsJg;
    private TextView tV_aviso;
    private StringAdapter adapterJS;
    private ArrayList<Player_Game> pg_timeA, pg_timeB, pg_subs;
    private ArrayList<String> s_subs = new ArrayList<>();
    private Player_Game pg;
    private int plcA, plcB, posit;
    private boolean bool_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substituto_view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        lV_subsJg = findViewById(R.id.lVsubs);
        tV_aviso = findViewById(R.id.tVsubs);
        Intent intent = getIntent();
        pg_timeA = (ArrayList<Player_Game>) intent.getSerializableExtra("timeA");
        pg_timeB = (ArrayList<Player_Game>) intent.getSerializableExtra("timeB");
        pg_subs = (ArrayList<Player_Game>) intent.getSerializableExtra("pg_subs");
        pg = (Player_Game) intent.getSerializableExtra("pg");
        posit = (int) intent.getSerializableExtra("posit");
        bool_time = (boolean) intent.getSerializableExtra("time");
        plcA = (int) intent.getSerializableExtra("plcA");
        plcB = (int) intent.getSerializableExtra("plcB");
        for(Player_Game p : pg_subs)
            s_subs.add(p.getTag());

        tV_aviso.setText(String.format("Subs: " + pg.getTag()));
        adapterJS = new StringAdapter(s_subs,this);
        lV_subsJg.setAdapter(adapterJS);
        tV_aviso.setOnClickListener(v -> { // caso não queira mais substituir ninguem
            Intent intent1 = new Intent(Substituto_View.this, LoadGame_5x5.class);
            intent1.putExtra("timeA", pg_timeA);
            intent1.putExtra("timeB", pg_timeB);
            intent1.putExtra("pg_subs", pg_subs);
            intent1.putExtra("plcA", plcA);
            intent1.putExtra("plcB", plcB);
            intent1.putExtra("bool_cor", true);
            intent1.putExtra("bool_subs", true);
            startActivity(intent1);
            finish();
        });

        lV_subsJg.setOnItemClickListener((parent, view, position, id) ->{
            Intent intent2 = new Intent(Substituto_View.this, LoadGame_5x5.class);
            pg_subs.get(position).setJogou();
            if(bool_time){ // substituir time A
                pg_timeA.set(posit, pg_subs.get(position));
                pg_subs.set(position, pg);
            } else{ // substituir time B
                pg_timeB.set(posit, pg_subs.get(position));
                pg_subs.set(position, pg);
            }
            intent2.putExtra("timeA", pg_timeA);
            intent2.putExtra("timeB", pg_timeB);
            intent2.putExtra("pg_subs", pg_subs);
            intent2.putExtra("plcA", plcA);
            intent2.putExtra("plcB", plcB);
            intent2.putExtra("bool_cor", true);
            intent2.putExtra("bool_subs", true);
            startActivity(intent2);
            finish();
        });
    }
}