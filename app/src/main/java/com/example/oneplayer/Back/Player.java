package com.example.oneplayer.Back;

import java.io.Serializable;

public class Player implements Serializable {
    private String tag; // nome do jogador
    private int id;
    private Scores_Player jogos3x3, jogos5x5, total;

    public Player(String apelido,int i) {
        tag = apelido;
        id = i;
        jogos3x3 = new Scores_Player();
        jogos5x5 = new Scores_Player();
        total = new Scores_Player();
    }

    public String getTag(){return tag;}
    public Scores_Player getScores(int m) {
        if(m == 0){
            return jogos3x3;
        } else if(m == 1){
            return jogos5x5;
        } else {
            somaScores();
            return total;
        }
    }
    public void somaScores(){
        int jj = jogos3x3.getJogos() + jogos5x5.getJogos();
        int vv = jogos3x3.getVit() + jogos5x5.getVit();

        total = new Scores_Player( jj, vv, (float)(vv*100)/jj, jogos3x3.getCluth(),
                jogos3x3.getTotal_pts() + jogos5x5.getTotal_pts(), jogos3x3.getA_2pts() + jogos5x5.getA_2pts(), jogos3x3.getA_3pts() + jogos5x5.getA_3pts(),
                jogos3x3.getRebt() + jogos5x5.getRebt(), jogos3x3.getAsst() + jogos5x5.getAsst(),
                jogos3x3.getBlock() + jogos5x5.getBlock(),
                (float)(jogos3x3.getTotal_pts() + jogos5x5.getTotal_pts())/jj,
                (float)(jogos3x3.getA_2pts() + jogos5x5.getA_2pts())/jj,
                (float)(jogos3x3.getA_3pts() + jogos5x5.getA_3pts())/jj,
                (float)(jogos3x3.getRebt() + jogos5x5.getRebt())/jj,
                (float)(jogos3x3.getAsst() + jogos5x5.getAsst())/jj,
                (float)(jogos3x3.getBlock() + jogos5x5.getBlock())/jj);
    }
}
