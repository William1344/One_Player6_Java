package com.example.oneplayer.Back;

import java.io.Serializable;
import java.util.ArrayList;

public class Liga implements Serializable {
    private String name;
    private int cont;
    ArrayList<Player> jogadores;
    ArrayList<Jogos> list_jogos3x3, list_jogos5x5;


    public Liga(String a) {
        cont = 1;
        name = a;
        jogadores = new ArrayList<>();
        list_jogos3x3 = new ArrayList<>();
        list_jogos5x5 = new ArrayList<>();
        addJgdr_testes();
    }

    public void add_Player(String tg){
        Player jgd = new Player(tg, cont);
        jogadores.add(jgd);
        cont++;
    }
    public void add_Jogo3x3(Jogos j){list_jogos3x3.add(j); }
    public void add_Jogo5x5(Jogos j){list_jogos5x5.add(j); }

    public void rem_Player(String tg){
        for(Player a : jogadores) if(a.getTag().compareTo(tg) == 0) jogadores.remove(a);
    }

    public ArrayList<Player> getJogadores(){return jogadores;}
    public ArrayList<Jogos> getList_jogos3x3() {return list_jogos3x3;}
    public ArrayList<Jogos> getList_jogos5x5() {return list_jogos5x5;}
    public int getTotal_Jogos(){return (list_jogos3x3.size() + list_jogos5x5.size());}

    public void addJgdr_testes(){
        add_Player("WillianS");
        add_Player("Mario");
        add_Player("Guilherme");
        add_Player("Rodolfo");
        add_Player("Toddy");
        add_Player("Ze buceta");
        add_Player("Adalberto");
        add_Player("Vitor");
        add_Player("Saraiva");
        add_Player("WillianS");
        add_Player("Loko");
        add_Player("Renan");
        add_Player("Dimy");
    }
}
