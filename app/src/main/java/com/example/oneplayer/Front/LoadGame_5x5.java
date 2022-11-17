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

public class LoadGame_5x5 extends AppCompatActivity {
    ArrayList<String> nomes_timeA, nomes_timeB, nome_subst;
    ArrayList<Player_Game> pg_timeA = new ArrayList<>(), pg_timeB = new ArrayList<>(),
                            pg_subs = new ArrayList<>();
    ArrayList<Player> jogadores;
    Player_Game jgdr;
    Jogos game;
    private String NAME = "liga_militao";
    private File file;
    private boolean estado = false; // true = decrementa // false = incrementa
    private boolean estado_fim = false;
    private boolean bool_subs = false;
    private boolean bool_correndo = false;

    int plcA = 0, plcB = 0;

    TextView tv_PlcA, tv_PlcB, tv_Jgdr1A, tv_Jgdr1B, tv_Jgdr2A, tv_Jgdr2B, tv_Jgdr3A, tv_Jgdr3B,
            tv_Jgdr4A, tv_Jgdr4B, tv_Jgdr5A, tv_Jgdr5B, tv_2Pts_1A, tv_2Pts_1B, tv_2Pts_2A,
            tv_2Pts_2B, tv_2Pts_3A, tv_2Pts_3B, tv_2Pts_4A, tv_2Pts_4B, tv_2Pts_5A, tv_2Pts_5B,
            tv_3Pts_1A, tv_3Pts_1B, tv_3Pts_2A, tv_3Pts_2B, tv_3Pts_3A, tv_3Pts_3B, tv_3Pts_4A,
            tv_3Pts_4B, tv_3Pts_5A, tv_3Pts_5B, tv_Reb_1A, tv_Reb_1B, tv_Reb_2A, tv_Reb_2B,
            tv_Reb_3A, tv_Reb_3B, tv_Reb_4A, tv_Reb_4B, tv_Reb_5A, tv_Reb_5B, tv_Ast_1A, tv_Ast_1B,
            tv_Ast_2A, tv_Ast_2B, tv_Ast_3A, tv_Ast_3B, tv_Ast_4A, tv_Ast_4B, tv_Ast_5A, tv_Ast_5B,
            tv_Blk_1A, tv_Blk_1B, tv_Blk_2A, tv_Blk_2B, tv_Blk_3A, tv_Blk_3B, tv_Blk_4A, tv_Blk_4B,
            tv_Blk_5A, tv_Blk_5B, tv_VS, tv_Placar;
    Button end_Game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_load_game5x5);
        Objects.requireNonNull(getSupportActionBar()).hide();
        Intent intent = getIntent();
        setIds();
        bool_subs = (boolean) intent.getSerializableExtra("bool_subs");
        bool_correndo = (boolean) intent.getSerializableExtra("bool_cor");
        file = getFileStreamPath(NAME);
        if(bool_correndo){ // jogo já está em andamento e ocorreu uma substituição
            pg_timeA = (ArrayList<Player_Game>) intent.getSerializableExtra("timeA");
            pg_timeB = (ArrayList<Player_Game>) intent.getSerializableExtra("timeB");
            pg_subs = (ArrayList<Player_Game>) intent.getSerializableExtra("pg_subs");
            plcA = (int) intent.getSerializableExtra("plcA");
            plcB = (int) intent.getSerializableExtra("plcB");
        } else{ // novo jogo -> New_Game
            if(bool_subs) nome_subst = intent.getStringArrayListExtra("array_subs");
            nomes_timeA = intent.getStringArrayListExtra("timeA");
            nomes_timeB = intent.getStringArrayListExtra("timeB");
            jogadores = Main_Liga.liga.getJogadores();
            loadTimes();

        }
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
        // incrementa ou decrementa 2pts dos jogadores
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
        tv_2Pts_4A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(3).remC_2pts();
                plcA--;plcA--;
            }
            else {
                pg_timeA.get(3).setC_2pts();
                plcA++;plcA++;
                jgdr = pg_timeA.get(3);
            }
            loadInterface();
        });
        tv_2Pts_4B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(3).remC_2pts();
                plcB--;plcB--;
            }
            else {
                pg_timeB.get(3).setC_2pts();
                plcB++;plcB++;
                jgdr = pg_timeB.get(3);
            }
            loadInterface();
        });
        tv_2Pts_5A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(4).remC_2pts();
                plcA--;plcA--;
            }
            else {
                pg_timeA.get(4).setC_2pts();
                plcA++;plcA++;
                jgdr = pg_timeA.get(4);
            }
            loadInterface();
        });
        tv_2Pts_5B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(4).remC_2pts();
                plcB--;plcB--;
            }
            else {
                pg_timeB.get(4).setC_2pts();
                plcB++;plcB++;
                jgdr = pg_timeB.get(4);
            }
            loadInterface();
        });
        // incrementa ou decrementa 3pts dos jogadores
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
        tv_3Pts_4A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(3).remC_3pts();
                plcA--;plcA--;plcA--;
            }
            else {
                pg_timeA.get(3).setC_3pts();
                plcA++;plcA++;plcA++;
                jgdr = pg_timeA.get(3);
            }
            loadInterface();
        });
        tv_3Pts_4B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(3).remC_3pts();
                plcB--;plcB--;plcB--;
            }
            else {
                pg_timeB.get(3).setC_3pts();
                plcB++;plcB++;plcB++;
                jgdr = pg_timeB.get(3);
            }
            loadInterface();
        });
        tv_3Pts_5A.setOnClickListener(v -> {
            if(estado){
                pg_timeA.get(4).remC_3pts();
                plcA--;plcA--;plcA--;
            }
            else {
                pg_timeA.get(4).setC_3pts();
                plcA++;plcA++;plcA++;
                jgdr = pg_timeA.get(4);
            }
            loadInterface();
        });
        tv_3Pts_5B.setOnClickListener(v -> {
            if(estado){
                pg_timeB.get(4).remC_3pts();
                plcB--;plcB--;plcB--;
            }
            else {
                pg_timeB.get(4).setC_3pts();
                plcB++;plcB++;plcB++;
                jgdr = pg_timeB.get(4);
            }
            loadInterface();
        });
        // incrementa ou decrementa Assistencias dos jogadores
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
        tv_Ast_4A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(3).remAsst();
            else pg_timeA.get(3).setAsst();
            loadInterface();
        });
        tv_Ast_4B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(3).remAsst();
            else pg_timeB.get(3).setAsst();
            loadInterface();
        });
        tv_Ast_5A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(4).remAsst();
            else pg_timeA.get(4).setAsst();
            loadInterface();
        });
        tv_Ast_5B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(4).remAsst();
            else pg_timeB.get(4).setAsst();
            loadInterface();
        });
        // incrementa ou decrementa Rebotes dos jogadores
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
        tv_Reb_4A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(3).remRebts();
            else pg_timeA.get(3).setRebts();
            loadInterface();
        });
        tv_Reb_4B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(3).remRebts();
            else pg_timeB.get(3).setRebts();
            loadInterface();
        });
        tv_Reb_5A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(4).remRebts();
            else pg_timeA.get(4).setRebts();
            loadInterface();
        });
        tv_Reb_5B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(4).remRebts();
            else pg_timeB.get(4).setRebts();
            loadInterface();
        });
        // incrementa ou decrementa Block dos jogadores
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
        tv_Blk_4A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(3).remBlock();
            else pg_timeA.get(3).setBlock();
            loadInterface();
        });
        tv_Blk_4B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(3).remBlock();
            else pg_timeB.get(3).setBlock();
            loadInterface();
        });
        tv_Blk_5A.setOnClickListener(v -> {
            if(estado) pg_timeA.get(4).remBlock();
            else pg_timeA.get(4).setBlock();
            loadInterface();
        });
        tv_Blk_5B.setOnClickListener(v -> {
            if(estado) pg_timeB.get(4).remBlock();
            else pg_timeB.get(4).setBlock();
            loadInterface();
        });
        // realiza as substituições conforme o jogador selecionado
        tv_Jgdr1A.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeA.get(0));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("posit", 0);
                intent1.putExtra("time", true); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr2A.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeA.get(1));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 1);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", true); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr3A.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeA.get(2));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 2);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", true); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr4A.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeA.get(3));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 3);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", true); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr5A.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeA.get(4));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 4);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", true); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr1B.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeB.get(0));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 0);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", false); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr2B.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeB.get(1));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 1);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", false); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr3B.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeB.get(2));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 2);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", false); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr4B.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeB.get(3));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 3);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", false); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });
        tv_Jgdr5B.setOnClickListener(v -> {
            if(bool_subs) {
                Intent intent1 = new Intent(LoadGame_5x5.this, Substituto_View.class);
                intent1.putExtra("pg", pg_timeB.get(4));
                intent1.putExtra("timeA", pg_timeA);
                intent1.putExtra("timeB", pg_timeB);
                intent1.putExtra("pg_subs", pg_subs);
                intent1.putExtra("posit", 4);
                intent1.putExtra("plcA", plcA);
                intent1.putExtra("plcB", plcB);
                intent1.putExtra("time", false); // timeA = true // timeB = false
                startActivity(intent1);
                finish();
            }
        });


        // finaliza o jogo.
        end_Game.setOnClickListener(v -> {
            if(!estado){ // finalização em duas etapas
                tv_Placar.setText("Finalizar Jogo?");
                tv_Placar.setBackgroundColor(Color.RED);
                estado = true;
            }else{ // confirma a finalização
                // seta os jogadores vencedores
                if(plcA > plcB) for(Player_Game pg : pg_timeA) pg.setDecisao();
                else for(Player_Game pg : pg_timeB) pg.setDecisao();

                // finaliza o jogo para salva-lolo
                game = new Jogos(pg_timeA, pg_timeB, jgdr, plcA, plcB);
                Main_Liga.liga.add_Jogo5x5(game);
                for(Player_Game pg : pg_timeA){ // incrementa o jogo no perfil dos usuários do time A
                    for(Player p : Main_Liga.liga.getJogadores()){
                        if(pg.getTag().compareTo(p.getTag()) == 0){
                            p.getScores(1).setGame(pg.get2Pts(),pg.get3Pts(),pg.getRebts(),
                                    pg.getAsst(),pg.getBlock(),pg.getDecid(),pg.getCluth());
                            break;
                        }
                    }
                }
                for(Player_Game pg : pg_timeB){// incrementa o jogo no perfil dos usuários do time B
                    for(Player p : Main_Liga.liga.getJogadores()){
                        if(pg.getTag().compareTo(p.getTag()) == 0){
                            p.getScores(1).setGame(pg.get2Pts(),pg.get3Pts(),pg.getRebts(),
                                    pg.getAsst(),pg.getBlock(),pg.getDecid(),pg.getCluth());
                            break;
                        }
                    }
                }
                // caso tenha substitutos na lista incrementa o jogo no perfil dos usuários que entraram em jogo
                if(bool_subs){
                    for(Player_Game pg : pg_subs){
                        if(pg.getJogou()){ // verifica se entrou em quadra
                            for(Player p : Main_Liga.liga.getJogadores()){
                                if(pg.getTag().compareTo(p.getTag()) == 0){
                                    p.getScores(1).setGame(pg.get2Pts(),pg.get3Pts(),pg.getRebts(),
                                            pg.getAsst(),pg.getBlock(),pg.getDecid(),pg.getCluth());
                                    break;
                                }
                            }
                        }
                    }
                }

                try { // salva os dados da liga na memória persistente
                    FileOutputStream getR = new FileOutputStream(file);
                    ObjectOutputStream write = new ObjectOutputStream(getR);
                    write.writeObject(Main_Liga.liga);
                    getR.close();
                    write.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                // finaliza a tarefa e vai para View Game
                Intent intent1 = new Intent(LoadGame_5x5.this, ViewGame_5x5.class);
                intent1.putExtra("game", game);
                startActivity(intent1);
                finish();
            }

        });
        // cancela o fim do jogo em duas etapas de confirmações
        tv_Placar.setOnClickListener(v -> {
            if(estado_fim){
                tv_Placar.setText("Placar");
                estado_fim = false;
                tv_Placar.setBackgroundColor(Color.BLACK);
            }
        });
        // atualiza interface.
        loadInterface();
    }
    // em caso de um novo jogo, realiza a montagem dos times com objeto Player_Game
    private void loadTimes() {
        for(String a : nomes_timeA){ //cria time A
            Player_Game jgd = new Player_Game(a);
            jgd.setJogou();
            pg_timeA.add(jgd);
        }
        for(String a : nomes_timeB){ //cria time B
            Player_Game jgd = new Player_Game(a);
            jgd.setJogou();
            pg_timeB.add(jgd);
        }
        if(bool_subs){ //cria substitutos se tiver substitutos
            for(String a : nome_subst){
                Player_Game jgd = new Player_Game(a);
                pg_subs.add(jgd);
            }
        }
    }
    // função para atualizar a interface
    private void loadInterface() {
        tv_PlcA.setText("  " + plcA + "  ");
        tv_PlcB.setText("  " + plcB + "  ");
        tv_Jgdr1A.setText(pg_timeA.get(0).getTag());
        tv_Jgdr1B.setText(pg_timeB.get(0).getTag());
        tv_Jgdr2A.setText(pg_timeA.get(1).getTag());
        tv_Jgdr2B.setText(pg_timeB.get(1).getTag());
        tv_Jgdr3A.setText(pg_timeA.get(2).getTag());
        tv_Jgdr3B.setText(pg_timeB.get(2).getTag());
        tv_Jgdr4A.setText(pg_timeA.get(3).getTag());
        tv_Jgdr4B.setText(pg_timeB.get(3).getTag());
        tv_Jgdr5A.setText(pg_timeA.get(4).getTag());
        tv_Jgdr5B.setText(pg_timeB.get(4).getTag());

        tv_2Pts_1A.setText(String.format("" + pg_timeA.get(0).get2Pts()));
        tv_2Pts_1B.setText(String.format("" + pg_timeB.get(0).get2Pts()));
        tv_2Pts_2A.setText(String.format("" + pg_timeA.get(1).get2Pts()));
        tv_2Pts_2B.setText(String.format("" + pg_timeB.get(1).get2Pts()));
        tv_2Pts_3A.setText(String.format("" + pg_timeA.get(2).get2Pts()));
        tv_2Pts_3B.setText(String.format("" + pg_timeB.get(2).get2Pts()));
        tv_2Pts_4A.setText(String.format("" + pg_timeA.get(3).get2Pts()));
        tv_2Pts_4B.setText(String.format("" + pg_timeB.get(3).get2Pts()));
        tv_2Pts_5A.setText(String.format("" + pg_timeA.get(4).get2Pts()));
        tv_2Pts_5B.setText(String.format("" + pg_timeB.get(4).get2Pts()));

        tv_3Pts_1A.setText(String.format("" + pg_timeA.get(0).get3Pts()));
        tv_3Pts_1B.setText(String.format("" + pg_timeB.get(0).get3Pts()));
        tv_3Pts_2A.setText(String.format("" + pg_timeA.get(1).get3Pts()));
        tv_3Pts_2B.setText(String.format("" + pg_timeB.get(1).get3Pts()));
        tv_3Pts_3A.setText(String.format("" + pg_timeA.get(2).get3Pts()));
        tv_3Pts_3B.setText(String.format("" + pg_timeB.get(2).get3Pts()));
        tv_3Pts_4A.setText(String.format("" + pg_timeA.get(3).get3Pts()));
        tv_3Pts_4B.setText(String.format("" + pg_timeB.get(3).get3Pts()));
        tv_3Pts_5A.setText(String.format("" + pg_timeA.get(4).get3Pts()));
        tv_3Pts_5B.setText(String.format("" + pg_timeB.get(4).get3Pts()));

        tv_Reb_1A.setText(String.format("" + pg_timeA.get(0).getRebts()));
        tv_Reb_1B.setText(String.format("" + pg_timeB.get(0).getRebts()));
        tv_Reb_2A.setText(String.format("" + pg_timeA.get(1).getRebts()));
        tv_Reb_2B.setText(String.format("" + pg_timeB.get(1).getRebts()));
        tv_Reb_3A.setText(String.format("" + pg_timeA.get(2).getRebts()));
        tv_Reb_3B.setText(String.format("" + pg_timeB.get(2).getRebts()));
        tv_Reb_4A.setText(String.format("" + pg_timeA.get(3).getRebts()));
        tv_Reb_4B.setText(String.format("" + pg_timeB.get(3).getRebts()));
        tv_Reb_5A.setText(String.format("" + pg_timeA.get(4).getRebts()));
        tv_Reb_5B.setText(String.format("" + pg_timeB.get(4).getRebts()));

        tv_Ast_1A.setText(String.format("" + pg_timeA.get(0).getAsst()));
        tv_Ast_1B.setText(String.format("" + pg_timeB.get(0).getAsst()));
        tv_Ast_2A.setText(String.format("" + pg_timeA.get(1).getAsst()));
        tv_Ast_2B.setText(String.format("" + pg_timeB.get(1).getAsst()));
        tv_Ast_3A.setText(String.format("" + pg_timeA.get(2).getAsst()));
        tv_Ast_3B.setText(String.format("" + pg_timeB.get(2).getAsst()));
        tv_Ast_4A.setText(String.format("" + pg_timeA.get(3).getAsst()));
        tv_Ast_4B.setText(String.format("" + pg_timeB.get(3).getAsst()));
        tv_Ast_5A.setText(String.format("" + pg_timeA.get(4).getAsst()));
        tv_Ast_5B.setText(String.format("" + pg_timeB.get(4).getAsst()));

        tv_Blk_1A.setText(String.format("" + pg_timeA.get(0).getBlock()));
        tv_Blk_1B.setText(String.format("" + pg_timeB.get(0).getBlock()));
        tv_Blk_2A.setText(String.format("" + pg_timeA.get(1).getBlock()));
        tv_Blk_2B.setText(String.format("" + pg_timeB.get(1).getBlock()));
        tv_Blk_3A.setText(String.format("" + pg_timeA.get(2).getBlock()));
        tv_Blk_3B.setText(String.format("" + pg_timeB.get(2).getBlock()));
        tv_Blk_4A.setText(String.format("" + pg_timeA.get(3).getBlock()));
        tv_Blk_4B.setText(String.format("" + pg_timeB.get(3).getBlock()));
        tv_Blk_5A.setText(String.format("" + pg_timeA.get(4).getBlock()));
        tv_Blk_5B.setText(String.format("" + pg_timeB.get(4).getBlock()));
    }
    // seta os IDs do xml
    private void setIds() {
        tv_PlcA = findViewById(R.id.tV_placA);
        tv_PlcB  = findViewById(R.id.tV_placB);

        tv_Jgdr1A = findViewById(R.id.tVJog1A);
        tv_Jgdr1B = findViewById(R.id.tVJog1B);
        tv_Jgdr2A = findViewById(R.id.tVJog2A);
        tv_Jgdr2B = findViewById(R.id.tVJog2B);
        tv_Jgdr3A = findViewById(R.id.tVJog3A);
        tv_Jgdr3B = findViewById(R.id.tVJog3B);
        tv_Jgdr4A = findViewById(R.id.tVJog4A);
        tv_Jgdr4B = findViewById(R.id.tVJog4B);
        tv_Jgdr5A = findViewById(R.id.tVJog5A);
        tv_Jgdr5B = findViewById(R.id.tVJog5B);

        tv_2Pts_1A = findViewById(R.id.tV2Pts1A);
        tv_2Pts_1B = findViewById(R.id.tV2Pts1B);
        tv_2Pts_2A = findViewById(R.id.tV2Pts2A);
        tv_2Pts_2B = findViewById(R.id.tV2Pts2B);
        tv_2Pts_3A = findViewById(R.id.tV2Pts3A);
        tv_2Pts_3B = findViewById(R.id.tV2Pts3B);
        tv_2Pts_4A = findViewById(R.id.tV2Pts4A);
        tv_2Pts_4B = findViewById(R.id.tV2Pts4B);
        tv_2Pts_5A = findViewById(R.id.tV2Pts5A);
        tv_2Pts_5B = findViewById(R.id.tV2Pts5B);

        tv_3Pts_1A = findViewById(R.id.tV3Pts1A);
        tv_3Pts_1B = findViewById(R.id.tV3Pts1B);
        tv_3Pts_2A = findViewById(R.id.tV3Pts2A);
        tv_3Pts_2B = findViewById(R.id.tV3Pts2B);
        tv_3Pts_3A = findViewById(R.id.tV3Pts3A);
        tv_3Pts_3B = findViewById(R.id.tV3Pts3B);
        tv_3Pts_4A = findViewById(R.id.tV3Pts4A);
        tv_3Pts_4B = findViewById(R.id.tV3Pts4B);
        tv_3Pts_5A = findViewById(R.id.tV3Pts5A);
        tv_3Pts_5B = findViewById(R.id.tV3Pts5B);

        tv_Reb_1A = findViewById(R.id.tVReb1A);
        tv_Reb_1B = findViewById(R.id.tVReb1B);
        tv_Reb_2A = findViewById(R.id.tVReb2A);
        tv_Reb_2B = findViewById(R.id.tVReb2B);
        tv_Reb_3A = findViewById(R.id.tVReb3A);
        tv_Reb_3B = findViewById(R.id.tVReb3B);
        tv_Reb_4A = findViewById(R.id.tVReb4A);
        tv_Reb_4B = findViewById(R.id.tVReb4B);
        tv_Reb_5A = findViewById(R.id.tVReb5A);
        tv_Reb_5B = findViewById(R.id.tVReb5B);

        tv_Ast_1A = findViewById(R.id.tVAst1A);
        tv_Ast_1B = findViewById(R.id.tVAst1B);
        tv_Ast_2A = findViewById(R.id.tVAst2A);
        tv_Ast_2B = findViewById(R.id.tVAst2B);
        tv_Ast_3A = findViewById(R.id.tVAst3A);
        tv_Ast_3B = findViewById(R.id.tVAst3B);
        tv_Ast_4A = findViewById(R.id.tVAst4A);
        tv_Ast_4B = findViewById(R.id.tVAst4B);
        tv_Ast_5A = findViewById(R.id.tVAst5A);
        tv_Ast_5B = findViewById(R.id.tVAst5B);

        tv_Blk_1A = findViewById(R.id.tVBlk1A);
        tv_Blk_1B = findViewById(R.id.tVBlk1B);
        tv_Blk_2A = findViewById(R.id.tVBlk2A);
        tv_Blk_2B = findViewById(R.id.tVBlk2B);
        tv_Blk_3A = findViewById(R.id.tVBlk3A);
        tv_Blk_3B = findViewById(R.id.tVBlk3B);
        tv_Blk_4A = findViewById(R.id.tVBlk4A);
        tv_Blk_4B = findViewById(R.id.tVBlk4B);
        tv_Blk_5A = findViewById(R.id.tVBlk5A);
        tv_Blk_5B = findViewById(R.id.tVBlk5B);

        tv_VS = findViewById(R.id.tV_VS);
        end_Game = findViewById(R.id.b_end_game);
        tv_Placar = findViewById(R.id.tV_Placar);
    }
}