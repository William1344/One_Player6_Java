package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oneplayer.Back.Player;
import com.example.oneplayer.Front.Adapter.RankingAdapter;
import com.example.oneplayer.R;

import java.util.ArrayList;
import java.util.Objects;

public class Ranking extends AppCompatActivity {
    private ArrayList<Player> list_Org, aux;
    private Player pp;
    private CheckBox cb_3x3, cb_5x5, cb_total, cb_jgs, cb_fg, cb_3pts;
    private RankingAdapter adapterR;
    private ListView lV_ranking;
    private TextView tV_memT, tV_jgsT, tV_ptsT;
    private int t_pts = 0, t_jgs = 0, t_mem = 0;
    private int modo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ranking);
        Objects.requireNonNull(getSupportActionBar()).hide();
        list_Org = Main_Liga.liga.getJogadores();
        setIDs();
        order_alfab();
        cb_3x3.setChecked(true);
        cb_3x3.setOnClickListener(v -> {
            if(cb_3x3.isChecked()){
                cb_5x5.setChecked(false);
                cb_total.setChecked(false);
                modo = 0;
                loadInterface();
            }
        });

        cb_5x5.setOnClickListener(v -> {
            if(cb_5x5.isChecked()) {
                cb_3x3.setChecked(false);
                cb_total.setChecked(false);
                modo = 1;
                loadInterface();
            }
        });

        cb_total.setOnClickListener(v -> {
            if(cb_total.isChecked()) {
                cb_3x3.setChecked(false);
                cb_5x5.setChecked(false);
                modo = 2;
                loadInterface();
            }
        });

        cb_jgs.setOnClickListener(v -> {
            if(cb_jgs.isChecked()){
                cb_3pts.setChecked(false);
                cb_fg.setChecked(false);
                list_Org = Main_Liga.liga.getJogadores();
                // ordena em ordem decrescente pelo nº de jogos
                for(int x = 0 ; x < Main_Liga.liga.getJogadores().size() ; x++){
                    for(int y = x+1 ; y < Main_Liga.liga.getJogadores().size() ; y++){
                        if(list_Org.get(x).getScores(modo).getJogos() < list_Org.get(y).getScores(modo).getJogos()){
                            pp = list_Org.get(x);
                            list_Org.set(x, list_Org.get(y));
                            list_Org.set(y, pp);
                        }
                    }
                }
                loadInterface();
            }
        });
        cb_fg.setOnClickListener(v -> {
            if(cb_fg.isChecked()){
                cb_jgs.setChecked(false);
                cb_3pts.setChecked(false);
                list_Org = Main_Liga.liga.getJogadores();
                // ordena em ordem decrescente pelo nº de jogos
                for(int x = 0 ; x < Main_Liga.liga.getJogadores().size() ; x++){
                    for(int y = x+1 ; y < Main_Liga.liga.getJogadores().size() ; y++){
                        if(list_Org.get(x).getScores(modo).getFG() < list_Org.get(y).getScores(modo).getFG()){
                            pp = list_Org.get(x);
                            list_Org.set(x, list_Org.get(y));
                            list_Org.set(y, pp);
                        }
                    }
                }
                loadInterface();
            }
        });
        cb_3pts.setOnClickListener(v -> {
            if(cb_3pts.isChecked()){
                cb_jgs.setChecked(false);
                cb_fg.setChecked(false);
                list_Org = Main_Liga.liga.getJogadores();
                // ordena em ordem decrescente pelo nº de jogos
                for(int x = 0 ; x < Main_Liga.liga.getJogadores().size() ; x++){
                    for(int y = x+1 ; y < Main_Liga.liga.getJogadores().size() ; y++){
                        if(list_Org.get(x).getScores(modo).getA_3pts() < list_Org.get(y).getScores(modo).getA_3pts()){
                            pp = list_Org.get(x);
                            list_Org.set(x, list_Org.get(y));
                            list_Org.set(y, pp);
                        }
                    }
                }
                loadInterface();
            }
        });
        loadInterface();

    }

    private void order_alfab() {
        for(int x = 0 ; x < Main_Liga.liga.getJogadores().size() ; x++){
            for(int y = x+1 ; y < Main_Liga.liga.getJogadores().size() ; y++){
                if(list_Org.get(x).getTag().compareTo(list_Org.get(y).getTag()) > 0){
                    pp = list_Org.get(x);
                    list_Org.set(x, list_Org.get(y));
                    list_Org.set(y, pp);
                }
            }
        }
    }

    private void loadInterface(){
        t_jgs = 0; t_mem = 0; t_pts = 0;
        calcularSomatorio();
        adapterR = new RankingAdapter(this, list_Org, modo);
        lV_ranking.setAdapter(adapterR);
        tV_ptsT.setText(String.format("Pts: " + t_pts));
        tV_jgsT.setText(String.format("Jgs: " + t_jgs));
        tV_memT.setText(String.format("Mem: " + t_mem));

    }

    private void calcularSomatorio() {
        t_jgs = Main_Liga.liga.getTotal_Jogos();
        t_mem = list_Org.size();
        for(Player p : list_Org)
            t_pts = t_pts + p.getScores(modo).getTotal_pts();
    }

    private void setIDs() {
        cb_3x3 = findViewById(R.id.cB_3x3);
        cb_5x5 = findViewById(R.id.cB_5x5);
        cb_total = findViewById(R.id.cB_total);
        cb_jgs = findViewById(R.id.cB_jgs);
        cb_fg = findViewById(R.id.cB_FG);
        cb_3pts = findViewById(R.id.cB_3Pts);
        lV_ranking = findViewById(R.id.lV_ranking);
        tV_jgsT = findViewById(R.id.tV_jogos);
        tV_memT = findViewById(R.id.tV_membros);
        tV_ptsT = findViewById(R.id.tV_pts);

    }
}