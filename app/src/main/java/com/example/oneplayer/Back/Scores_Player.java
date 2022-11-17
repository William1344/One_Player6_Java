package com.example.oneplayer.Back;

import java.io.Serializable;

public class Scores_Player  implements Serializable {
    private  int jogos; // jogos
    private  int vit; // vitórias
    private  int cluth; // derrotas
    private  float a_FG; // % de vitórias
    private  int total_pts; // total pts
    private  int a_2pts; // total 2 pts
    private  int a_3pts; // total 3 pts
    private  int rebt; // rebotes
    private  int asst; // assistencias
    private  int block; // tocos
    private  float total_PPG; // nº de jogos / total_pts
    private  float a_2PG; // nº de jogos / 2pts
    private  float a_3PG; // nº de jogos / 3pts
    private  float a_RPG; // nº de jogos / rebts
    private  float a_APG; // nº de jogos / ast
    private  float a_BPG; // nº de jogos / blk

    public Scores_Player(int jg, int v, float fg, int clth, int tp, int b_2p, int b_3p,
                         int rbt, int ast, int b, float tPPG, float b_2PG, float b_3PG, float b_RPG, float b_APG, float b_BPG){
        jogos = jg;
        vit = v;
        a_FG = fg;
        cluth = clth;
        total_pts = tp;
        a_2pts = b_2p;
        a_3pts = b_3p;
        rebt = rbt;
        asst = ast;
        block = b;
        total_PPG = tPPG;
        a_2PG = b_2PG;
        a_3PG = b_3PG;
        a_RPG = b_RPG;
        a_APG = b_APG;
        a_BPG = b_BPG;
    }

    public Scores_Player(){
        jogos = 0;
        vit = 0;
        a_FG = 0;
        cluth = 0;
        total_pts = 0;
        a_2pts = 0;
        a_3pts = 0;
        rebt = 0;
        asst = 0;
        block = 0;
        total_PPG = 0;
        a_2PG = 0;
        a_3PG = 0;
        a_RPG = 0;
        a_APG = 0;
        a_BPG = 0;
    }

    public void setGame(int b_2pts, int b_3pts, int b_reb, int b_ast, int b_block, boolean ganhou, boolean clt){
        jogos++;
        if(ganhou) vit++;
        if(clt) cluth++;
        int points = (b_2pts * 2) + (b_3pts * 3);
        total_pts += points;
        a_2pts += b_2pts;
        a_3pts += b_3pts;
        rebt += b_reb;
        asst += b_ast;
        block += b_block;
        calcStatis();
    }

    public void calcStatis(){
        a_FG = (float)(vit * 100)/jogos;
        total_PPG = (float)total_pts/jogos;
        a_2PG = (float)a_2pts/jogos;
        a_3PG = (float)a_3pts/jogos;
        a_RPG = (float)rebt/jogos;
        a_APG = (float)asst/jogos;
        a_BPG = (float)block/jogos;
    }

    public int getJogos(){return jogos;}
    public int getVit(){return vit;}
    public float getFG(){return a_FG;}
    public int getCluth(){return cluth;}
    public int getTotal_pts(){return total_pts;}
    public int getA_2pts(){return a_2pts;}
    public int getA_3pts(){return a_3pts;}
    public int getRebt(){return rebt;}
    public int getAsst(){return asst;}
    public int getBlock(){return block;}
    public float getTotal_PPG(){return total_PPG;}
    public float getA_2PG(){return a_2PG;}
    public float getA_3PG(){return a_3PG;}
    public float getA_RPG(){return a_RPG;}
    public float getA_APG(){return a_APG;}
    public float getA_BPG(){return a_BPG;}



}
