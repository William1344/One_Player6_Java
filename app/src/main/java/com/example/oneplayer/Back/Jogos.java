package com.example.oneplayer.Back;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Jogos implements Serializable {

    private ArrayList<Player_Game> time_A, time_B, subs;
    private Player_Game jgd_cluth;
    private int plcA, plcB;
    private boolean b_5x5 = false;
    private Calendar data;


    public Jogos(ArrayList<Player_Game> tA, ArrayList<Player_Game> tB,
                 Player_Game c, int a, int b){
        data = Calendar.getInstance(TimeZone.getDefault());
        time_A = tA;
        time_B = tB;
        jgd_cluth = c;
        plcA = a;
        plcB = b;
    }

    public Jogos(ArrayList<Player_Game> tA, ArrayList<Player_Game> tB,
                 Player_Game c, int a, int b, ArrayList<Player_Game> s){
        data = Calendar.getInstance(TimeZone.getDefault());
        time_A = tA;
        time_B = tB;
        jgd_cluth = c;
        plcA = a;
        plcB = b;
        b_5x5 = true;
        subs = s;
    }

    public ArrayList<Player_Game> getTimeA() {
        return time_A;
    }
    public ArrayList<Player_Game> getTimeB() {
        return time_B;
    }
    public Player_Game getCluth() {return jgd_cluth;}
    public int getPlcA(){return plcA;}
    public int getPlcB(){return plcB;}
    public boolean getA_5x5(){return b_5x5;}

    public String getToString(){
        return String.format(" - "+ data.get(Calendar.HOUR_OF_DAY) + ":"+ data.get(Calendar.MINUTE) +"//" + data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR));
    }



}
