package com.example.oneplayer.Back;

import java.io.Serializable;

public class Player_Game  implements Serializable {
    private  String tag;
    private  int num_jgd;
    private  int c_2pts = 0; // total 2 pts
    private  int c_3pts = 0; // total 3 pts
    private  int rebts = 0; // rebotes
    private  int asst = 0; // assistencias
    private  int block = 0; // tocos
    private  boolean decisao = false;
    private  boolean c_cluth = false;
    private  boolean jogou = false;

    public Player_Game(String name){
        tag = name;
    }

    public void setTag(String s){
        tag = s;
    }

    public void setC_2pts(){c_2pts++;}
    public void setC_3pts(){c_3pts++;}
    public void setRebts(){rebts++;}
    public void setAsst(){asst++;}
    public void setBlock(){block++;}
    public void setJogou(){jogou = true;}

    public void remC_2pts(){c_2pts--;}
    public void remC_3pts(){c_3pts--;}
    public void remRebts(){rebts--;}
    public void remAsst(){asst--;}
    public void remBlock(){block--;}

    public void setC_cluth(boolean v){c_cluth = v;}
    public void setDecisao(){decisao = true;}

    public int get2Pts(){return c_2pts;}
    public int get3Pts(){return c_3pts;}
    public int getRebts(){return rebts;}
    public int getAsst(){return asst;}
    public int getBlock(){return block;}
    public boolean getCluth(){return c_cluth;}
    public boolean getDecid(){return decisao;}
    public boolean getJogou(){return jogou;}

    public String getTag(){return tag;}
    public int getNum(){return num_jgd;}
}
