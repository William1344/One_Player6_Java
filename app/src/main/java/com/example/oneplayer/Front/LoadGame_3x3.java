package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.oneplayer.Back.Jogos;
import com.example.oneplayer.Back.Player;
import com.example.oneplayer.Back.Player_Game;
import com.example.oneplayer.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;

public class LoadGame_3x3 extends AppCompatActivity {
    ArrayList<String> nomes_timeA, nomes_timeB, nome_subst;
    ArrayList<Player_Game> pg_timeA = new ArrayList<>(), pg_timeB = new ArrayList<>();
    ArrayList<Player> jogadores;
    Player_Game jgdr;
    Jogos game;
    private String NAME = "liga_militao";
    private File file;
    private boolean estado = false; // true = decrementa // false = incrementa
    private boolean estado_fim = false;
    private boolean bool_subs;
    int plcA = 0, plcB = 0;

    TextView tv_PlcA, tv_PlcB, tv_Jgdr1A, tv_Jgdr1B, tv_Jgdr2A, tv_Jgdr2B, tv_Jgdr3A, tv_Jgdr3B,
            tv_2Pts_1A, tv_2Pts_1B, tv_2Pts_2A, tv_2Pts_2B, tv_2Pts_3A, tv_2Pts_3B, tv_3Pts_1A,
            tv_3Pts_1B, tv_3Pts_2A, tv_3Pts_2B, tv_3Pts_3A, tv_3Pts_3B, tv_Reb_1A, tv_Reb_1B,
            tv_Reb_2A, tv_Reb_2B, tv_Reb_3A, tv_Reb_3B, tv_Ast_1A, tv_Ast_1B, tv_Ast_2A, tv_Ast_2B,
            tv_Ast_3A, tv_Ast_3B, tv_Blk_1A, tv_Blk_1B, tv_Blk_2A, tv_Blk_2B, tv_Blk_3A, tv_Blk_3B,
            tv_VS, tv_Placar;
    Button end_Game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_load_game);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Intent intent = getIntent();
        nomes_timeA = intent.getStringArrayListExtra("timeA");
        nomes_timeB = intent.getStringArrayListExtra("timeB");
        jogadores = Main_Liga.liga.getJogadores();
        file = getFileStreamPath(NAME);
        setIds();
        loadTimes();
        tv_VS.setOnClickListener(v -> {
            if(estado){
                estado = false;
                tv_VS.setBackgroundColor(Color.BLACK);

            } else {
                estado = true;
                tv_VS.setBackgroundColor(Color.GREEN);
            }
            loadInterface();
        });
        tv_2Pts_1A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(0).remC_2pts();
                plcA--;plcA--;
            }
            else {
                pg_timeA.get(0).setC_2pts();
                plcA++;plcA++;
                jgdr = pg_timeA.get(0);
            }            
            loadInterface();
        });
        tv_2Pts_1B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(0).remC_2pts();
                plcB--;plcB--;
            }
            else {
                pg_timeB.get(0).setC_2pts();
                plcB++;plcB++;
                jgdr = pg_timeB.get(0);
            }            
            loadInterface();
        });
        tv_2Pts_2A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(1).remC_2pts();
                plcA--;plcA--;
            }
            else {
                pg_timeA.get(1).setC_2pts();
                plcA++;plcA++;
                jgdr = pg_timeA.get(1);
            }            
            loadInterface();
        });
        tv_2Pts_2B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(1).remC_2pts();
                plcB--;plcB--;
            }
            else {
                pg_timeB.get(1).setC_2pts();
                plcB++;plcB++;
                jgdr = pg_timeB.get(1);
            }            
            loadInterface();
        });
        tv_2Pts_3A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(2).remC_2pts();
                plcA--;plcA--;
            }
            else {
                pg_timeA.get(2).setC_2pts();
                plcA++;plcA++;
                jgdr = pg_timeA.get(2);
            }            
            loadInterface();
        });
        tv_2Pts_3B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(2).remC_2pts();
                plcB--;plcB--;
            }
            else {
                pg_timeB.get(2).setC_2pts();
                plcB++;plcB++;
                jgdr = pg_timeB.get(2);
            }            
            loadInterface();
        });

        tv_3Pts_1A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(0).remC_3pts();
                plcA--;plcA--;plcA--;
            }
            else {
                pg_timeA.get(0).setC_3pts();
                plcA++;plcA++;plcA++;
                jgdr = pg_timeA.get(0);
            }            
            loadInterface();
        });
        tv_3Pts_1B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(0).remC_3pts();
                plcB--;plcB--;plcB--;
            }
            else {
                pg_timeB.get(0).setC_3pts();
                plcB++;plcB++;plcB++;
                jgdr = pg_timeB.get(0);
            }            
            loadInterface();
        });
        tv_3Pts_2A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(1).remC_3pts();
                plcA--;plcA--;plcA--;
            }
            else {
                pg_timeA.get(1).setC_3pts();
                plcA++;plcA++;plcA++;
                jgdr = pg_timeA.get(1);
            }            
            loadInterface();
        });
        tv_3Pts_2B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(1).remC_3pts();
                plcB--;plcB--;plcB--;
            }
            else {
                pg_timeB.get(1).setC_3pts();
                plcB++;plcB++;plcB++;
                jgdr = pg_timeB.get(1);
            }            
            loadInterface();
        });
        tv_3Pts_3A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(2).remC_3pts();
                plcA--;plcA--;plcA--;
            }
            else {
                pg_timeA.get(2).setC_3pts();
                plcA++;plcA++;plcA++;
                jgdr = pg_timeA.get(2);
            }            
            loadInterface();
        });
        tv_3Pts_3B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(2).remC_3pts();
                plcB--;plcB--;plcB--;
            }
            else {
                pg_timeB.get(2).setC_3pts();
                plcB++;plcB++;plcB++;
                jgdr = pg_timeB.get(2);
            }            
            loadInterface();
        });

        tv_Ast_1A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(0).remAsst();
            else pg_timeA.get(0).setAsst();
            loadInterface();              
        });
        tv_Ast_1B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(0).remAsst();
            else pg_timeB.get(0).setAsst();
            loadInterface();
        });
        tv_Ast_2A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(1).remAsst();
            else pg_timeA.get(1).setAsst();
            loadInterface(); 
        });
        tv_Ast_2B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(1).remAsst();
            else pg_timeB.get(1).setAsst();
            loadInterface();
        });
        tv_Ast_3A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(2).remAsst();
            else pg_timeA.get(2).setAsst();
            loadInterface();           
        });
        tv_Ast_3B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(2).remAsst();
            else pg_timeB.get(2).setAsst();
            loadInterface();         
        });

        tv_Reb_1A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(0).remRebts();
            else pg_timeA.get(0).setRebts();
            loadInterface();         
        });
        tv_Reb_1B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(0).remRebts();
            else pg_timeB.get(0).setRebts();
            loadInterface();        
        });
        tv_Reb_2A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(1).remRebts();
            else pg_timeA.get(1).setRebts();
            loadInterface();        
        });
        tv_Reb_2B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(1).remRebts();
            else pg_timeB.get(1).setRebts();
            loadInterface();           
        });
        tv_Reb_3A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(2).remRebts();
            else pg_timeA.get(2).setRebts();
            loadInterface();           
        });
        tv_Reb_3B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(2).remRebts();
            else pg_timeB.get(2).setRebts();
            loadInterface();            
        });

        tv_Blk_1A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(0).remBlock();
            else pg_timeA.get(0).setBlock();
            loadInterface();            
        });
        tv_Blk_1B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(0).remBlock();
            else pg_timeB.get(0).setBlock();
            loadInterface();          
        });
        tv_Blk_2A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(1).remBlock();
            else pg_timeA.get(1).setBlock();
            loadInterface();           
        });
        tv_Blk_2B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(1).remBlock();
            else pg_timeB.get(1).setBlock();
            loadInterface();          
        });
        tv_Blk_3A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(2).remBlock();
            else pg_timeA.get(2).setBlock();
            loadInterface();          
        });
        tv_Blk_3B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(2).remBlock();
            else pg_timeB.get(2).setBlock();
            loadInterface();            
        });

        end_Game.setOnClickListener(v -> {
            if(!estado){
                tv_Placar.setText("Finalizar Jogo?");
                tv_Placar.setBackgroundColor(Color.RED);
                estado = true;
            }else{
                if(plcA > plcB) {
                    for(Player_Game pg : pg_timeA) {
                        pg.setDecisao();
                        if(pg.getTag().compareTo(jgdr.getTag()) == 0) pg.setC_cluth(true);
                    }
                }
                else{
                    for(Player_Game pg : pg_timeB) {
                        pg.setDecisao();
                        if(pg.getTag().compareTo(jgdr.getTag()) == 0) pg.setC_cluth(true);
                    }
                }
                game = new Jogos(pg_timeA, pg_timeB, jgdr, plcA, plcB);
                Main_Liga.liga.add_Jogo3x3(game);
                for(Player_Game pg : pg_timeA){
                    for(Player p : Main_Liga.liga.getJogadores()){
                        if(pg.getTag().compareTo(p.getTag()) == 0){
                            p.getScores(0).setGame(pg.get2Pts(),pg.get3Pts(),pg.getRebts(),
                                    pg.getAsst(),pg.getBlock(),pg.getDecid(),pg.getCluth());
                        }
                    }
                }
                for(Player_Game pg : pg_timeB){
                    for(Player p : Main_Liga.liga.getJogadores()){
                        if(pg.getTag().compareTo(p.getTag()) == 0){
                            p.getScores(0).setGame(pg.get2Pts(),pg.get3Pts(),pg.getRebts(),
                                    pg.getAsst(),pg.getBlock(),pg.getDecid(),pg.getCluth());
                        }
                    }
                }

                try {
                    FileOutputStream getR = new FileOutputStream(file);
                    ObjectOutputStream write = new ObjectOutputStream(getR);
                    write.writeObject(Main_Liga.liga);
                    getR.close();
                    write.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                Intent intent1 = new Intent(LoadGame_3x3.this, ViewGame_3x3.class);
                intent1.putExtra("game", game);
                startActivity(intent1);
                finish();
            }
            
        });

        tv_Placar.setOnClickListener(v -> {
            if(estado_fim){
                tv_Placar.setText("Placar");
                estado_fim = false;
                tv_Placar.setBackgroundColor(Color.BLACK);
            }
        });
        loadInterface();
    }

    private void loadTimes() {
        for(String a : nomes_timeA){
            Player_Game jgd = new Player_Game(a);
            pg_timeA.add(jgd);
        }
        for(String a : nomes_timeB){
            Player_Game jgd = new Player_Game(a);
            pg_timeB.add(jgd);
        }
    }

    private void loadInterface() {
        tv_PlcA.setText("  " + plcA + "  ");
        tv_PlcB.setText("  " + plcB + "  ");
        tv_Jgdr1A.setText(pg_timeA.get(0).getTag());
        tv_Jgdr1B.setText(pg_timeB.get(0).getTag());
        tv_Jgdr2A.setText(pg_timeA.get(1).getTag());
        tv_Jgdr2B.setText(pg_timeB.get(1).getTag());
        tv_Jgdr3A.setText(pg_timeA.get(2).getTag());
        tv_Jgdr3B.setText(pg_timeB.get(2).getTag());
        tv_2Pts_1A.setText(String.format("" + pg_timeA.get(0).get2Pts()));
        tv_2Pts_1B.setText(String.format("" + pg_timeB.get(0).get2Pts()));
        tv_2Pts_2A.setText(String.format("" + pg_timeA.get(1).get2Pts()));
        tv_2Pts_2B.setText(String.format("" + pg_timeB.get(1).get2Pts()));
        tv_2Pts_3A.setText(String.format("" + pg_timeA.get(2).get2Pts()));
        tv_2Pts_3B.setText(String.format("" + pg_timeB.get(2).get2Pts()));
        tv_3Pts_1A.setText(String.format("" + pg_timeA.get(0).get3Pts()));
        tv_3Pts_1B.setText(String.format("" + pg_timeB.get(0).get3Pts()));
        tv_3Pts_2A.setText(String.format("" + pg_timeA.get(1).get3Pts()));
        tv_3Pts_2B.setText(String.format("" + pg_timeB.get(1).get3Pts()));
        tv_3Pts_3A.setText(String.format("" + pg_timeA.get(2).get3Pts()));
        tv_3Pts_3B.setText(String.format("" + pg_timeB.get(2).get3Pts()));
        tv_Reb_1A.setText(String.format("" + pg_timeA.get(0).getRebts()));
        tv_Reb_1B.setText(String.format("" + pg_timeB.get(0).getRebts()));
        tv_Reb_2A.setText(String.format("" + pg_timeA.get(1).getRebts()));
        tv_Reb_2B.setText(String.format("" + pg_timeB.get(1).getRebts()));
        tv_Reb_3A.setText(String.format("" + pg_timeA.get(2).getRebts()));
        tv_Reb_3B.setText(String.format("" + pg_timeB.get(2).getRebts()));
        tv_Ast_1A.setText(String.format("" + pg_timeA.get(0).getAsst()));
        tv_Ast_1B.setText(String.format("" + pg_timeB.get(0).getAsst()));
        tv_Ast_2A.setText(String.format("" + pg_timeA.get(1).getAsst()));
        tv_Ast_2B.setText(String.format("" + pg_timeB.get(1).getAsst()));
        tv_Ast_3A.setText(String.format("" + pg_timeA.get(2).getAsst()));
        tv_Ast_3B.setText(String.format("" + pg_timeB.get(2).getAsst()));
        tv_Blk_1A.setText(String.format("" + pg_timeA.get(0).getBlock()));
        tv_Blk_1B.setText(String.format("" + pg_timeB.get(0).getBlock()));
        tv_Blk_2A.setText(String.format("" + pg_timeA.get(1).getBlock()));
        tv_Blk_2B.setText(String.format("" + pg_timeB.get(1).getBlock()));
        tv_Blk_3A.setText(String.format("" + pg_timeA.get(2).getBlock()));
        tv_Blk_3B.setText("" + pg_timeB.get(2).getBlock());
    }

    private void setIds() {
        tv_PlcA = findViewById(R.id.tV_placA);
        tv_PlcB  = findViewById(R.id.tV_placB);
        tv_Jgdr1A = findViewById(R.id.tVJog1A);
        tv_Jgdr1B = findViewById(R.id.tVJog1B);
        tv_Jgdr2A = findViewById(R.id.tVJog2A);
        tv_Jgdr2B = findViewById(R.id.tVJog2B);
        tv_Jgdr3A = findViewById(R.id.tVJog3A);
        tv_Jgdr3B = findViewById(R.id.tVJog3B);
        tv_2Pts_1A = findViewById(R.id.tV2Pts1A);
        tv_2Pts_1B = findViewById(R.id.tV2Pts1B);
        tv_2Pts_2A = findViewById(R.id.tV2Pts2A);
        tv_2Pts_2B = findViewById(R.id.tV2Pts2B);
        tv_2Pts_3A = findViewById(R.id.tV2Pts3A);
        tv_2Pts_3B = findViewById(R.id.tV2Pts3B);
        tv_3Pts_1A = findViewById(R.id.tV3Pts1A);
        tv_3Pts_1B = findViewById(R.id.tV3Pts1B);
        tv_3Pts_2A = findViewById(R.id.tV3Pts2A);
        tv_3Pts_2B = findViewById(R.id.tV3Pts2B);
        tv_3Pts_3A = findViewById(R.id.tV3Pts3A);
        tv_3Pts_3B = findViewById(R.id.tV3Pts3B);
        tv_Reb_1A = findViewById(R.id.tVReb1A);
        tv_Reb_1B = findViewById(R.id.tVReb1B);
        tv_Reb_2A = findViewById(R.id.tVReb2A);
        tv_Reb_2B = findViewById(R.id.tVReb2B);
        tv_Reb_3A = findViewById(R.id.tVReb3A);
        tv_Reb_3B = findViewById(R.id.tVReb3B);
        tv_Ast_1A = findViewById(R.id.tVAst1A);
        tv_Ast_1B = findViewById(R.id.tVAst1B);
        tv_Ast_2A = findViewById(R.id.tVAst2A);
        tv_Ast_2B = findViewById(R.id.tVAst2B);
        tv_Ast_3A = findViewById(R.id.tVAst3A);
        tv_Ast_3B = findViewById(R.id.tVAst3B);
        tv_Blk_1A = findViewById(R.id.tVBlk1A);
        tv_Blk_1B = findViewById(R.id.tVBlk1B);
        tv_Blk_2A = findViewById(R.id.tVBlk2A);
        tv_Blk_2B = findViewById(R.id.tVBlk2B);
        tv_Blk_3A = findViewById(R.id.tVBlk3A);
        tv_Blk_3B = findViewById(R.id.tVBlk3B);
        tv_VS = findViewById(R.id.tV_VS);
        end_Game = findViewById(R.id.b_end_game);
        tv_Placar = findViewById(R.id.tV_Placar);
    }
}
