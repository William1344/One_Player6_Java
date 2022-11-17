package com.example.oneplayer.Front.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oneplayer.Back.Player;
import com.example.oneplayer.R;


import java.util.ArrayList;

public class PlayerAdapter extends BaseAdapter{
    private final ArrayList<Player> playerList;
    private final Activity act;

    public PlayerAdapter(ArrayList<Player> pL, Activity ac) {
        playerList = pL;
        act = ac;
    }

    @Override
    public int getCount() {return playerList.size();}

    @Override
    public Object getItem(int position) {return playerList.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vw;
        vw = getListGame(position, parent); // 2 list do new Game
        return vw;
    }

    public View getListGame(int position,  ViewGroup parent){
        View vw = act.getLayoutInflater().inflate(R.layout.newgame_list,parent, false);
        Player pl = playerList.get(position);
        TextView name = vw.findViewById(R.id.tVNomePl);
        name.setText(pl.getTag());
        return vw;
    }


}