package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oneplayer.Front.Adapter.PlayerAdapter;
import com.example.oneplayer.Back.Liga;
import com.example.oneplayer.Back.Player;
import com.example.oneplayer.Front.Adapter.StringAdapter;
import com.example.oneplayer.R;

import java.util.ArrayList;
import java.util.Objects;

public class New_Game extends AppCompatActivity {
    private ArrayList<String> s_players;
    private ArrayList<String> s_timeA , s_timeB, subs;
    private Liga liga;
    private Player jgdr;
    private Button a_3x3, a_5x5, play;
    private ListView listV_jogadores, listV_timeA, listV_timeB;
    private TextView aviso;
    private int modo; // 3x3 = 1 // 5x5 = 2 // apagado = 0
    private boolean bool = false;
    private boolean estado, bool_subst = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.new_game);
        Objects.requireNonNull(getSupportActionBar()).hide();
        liga = Main_Liga.liga;
        setIDs();
        loadInterface();
        a_3x3.setOnClickListener(v ->{
            if(modo == 3) aviso.setText("Modo de jogo");
            if(modo == 1) {
                a_3x3.setBackgroundColor(Color.GREEN);
                modo = 0;
            }
            else {
                modo = 1;
                a_3x3.setBackgroundColor(Color.RED);
                a_5x5.setBackgroundColor(Color.GREEN);
            }
        });

        a_5x5.setOnClickListener(v ->{
            if(modo == 3) aviso.setText("Modo");
            if(modo == 2) {
                modo = 0;
                a_5x5.setBackgroundColor(Color.GREEN);
            }
            else {
                a_5x5.setBackgroundColor(Color.RED);
                a_3x3.setBackgroundColor(Color.GREEN);
                modo = 2;
            }
        });

        //montar os times
        listV_jogadores.setOnItemClickListener((parent, view, position, id) -> {
            if(modo == 1){  // modo 3x3
                if(s_timeA.size() < 3){ // timeA
                    s_timeA.add(s_players.get(position));
                    s_players.remove(position);
                    aviso.setText("Modo de jogo");
                    estado = false;
                }
                else if(s_timeB.size() < 3){ // timeB
                    s_timeB.add(s_players.get(position));
                    s_players.remove(position);
                    aviso.setText("Modo de jogo");
                    estado = false;
                    if(s_timeA.size() == 3 && s_timeB.size() == 3){
                        estado = true;
                        aviso.setText("Times completos");
                    }
                }
            }
            else if(modo == 2){ // modo 5x5
                if(s_timeA.size() < 5) { // timeA
                    s_timeA.add(s_players.get(position));
                    s_players.remove(position);
                    aviso.setText("Modo de jogo");
                    estado = false;
                }
                else if(s_timeB.size() < 5){ // timeB
                    s_timeB.add(s_players.get(position));
                    s_players.remove(position);
                    aviso.setText("Modo de jogo");
                    estado = false;
                    if(s_timeA.size() == 5 && s_timeB.size() == 5 && !estado) {
                        estado = true;
                        aviso.setText("Reservas?");
                    }
                }else {
                    if(subs.isEmpty()) {
                        subs.add(s_players.get(position));
                        bool_subst = true;
                    }
                    else {
                        for(String a : subs) {
                            if (s_players.get(position).compareTo(a) == 0) {
                                subs.remove(a);
                                bool = true;
                                if (subs.isEmpty()) bool_subst = false;
                            }
                        }
                        if(bool) bool = false;
                        else  subs.add(s_players.get(position));
                    }
                }
            }
            loadInterface();
        });

        listV_timeA.setOnItemClickListener((parent, view, position, id) -> {
            s_players.add(s_timeA.get(position));
            s_timeA.remove(position);
            loadInterface();
        });
        listV_timeB.setOnItemClickListener((parent, view, position, id) -> {
            s_players.add(s_timeB.get(position));
            s_timeB.remove(position);
            loadInterface();
        });
        // botão que inicializar o jogo -> Load_Game
        play.setOnClickListener(v ->{
            if(estado && modo == 1) { //modo 3x3, e time completo.
                Intent intent = new Intent(New_Game.this, LoadGame_3x3.class);
                intent.putExtra("timeA", s_timeA);
                intent.putExtra("timeB", s_timeB);
                startActivity(intent);
                finish();
            } else if(estado && modo == 2){ //modo 5x5, e time completo.
                Intent intent = new Intent(New_Game.this, LoadGame_5x5.class);
                intent.putExtra("timeA", s_timeA);
                intent.putExtra("timeB", s_timeB);
                intent.putExtra("bool_subs", bool_subst);
                intent.putExtra("array_subs", subs);
                intent.putExtra("bool_cor", false);
                startActivity(intent);
                finish();
            }
        });


    }


    private void loadInterface(){
        StringAdapter adapterJ = new StringAdapter(s_players, this);
        if(!subs.isEmpty()) adapterJ.setSubs(subs);
        listV_jogadores.setAdapter(adapterJ);
        StringAdapter adapterA = new StringAdapter(s_timeA,this);
        listV_timeA.setAdapter(adapterA);
        StringAdapter adapterB = new StringAdapter(s_timeB,this);
        listV_timeB.setAdapter(adapterB);
    }

    private void setIDs(){
        a_3x3 = findViewById(R.id.a_3x3);
        a_5x5 = findViewById(R.id.a_5x5);
        play = findViewById(R.id.start_game);
        listV_jogadores = findViewById(R.id.listV_jogadores);
        listV_timeA = findViewById(R.id.listV_timeA);
        listV_timeB = findViewById(R.id.listV_timeB);
        modo = 0;
        a_3x3.setBackgroundColor(Color.GREEN);
        a_5x5.setBackgroundColor(Color.GREEN);
        aviso = findViewById(R.id.textView);
        s_players = new ArrayList<>();
        s_timeA = new ArrayList<>();
        s_timeB = new ArrayList<>();
        subs = new ArrayList<>();
        for(Player a : Main_Liga.liga.getJogadores())
            s_players.add(a.getTag());

    }
}