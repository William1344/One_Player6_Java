package com.example.oneplayer.Front.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.oneplayer.R;

import java.util.ArrayList;

public class StringAdapter extends BaseAdapter {
    private final ArrayList<String> nomes;
    private final Activity act;
    private ArrayList<String> subs = new ArrayList<>();

    public StringAdapter(ArrayList<String> pL, Activity ac) {
        nomes = pL;
        act = ac;
    }

    public void setSubs(ArrayList<String> a){
        subs = a;
    }

    @Override
    public int getCount() {return nomes.size();}

    @Override
    public Object getItem(int position) {return nomes.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vw = act.getLayoutInflater().inflate(R.layout.newgame_list,parent, false);
        TextView name = vw.findViewById(R.id.tVNomePl);
        if(!subs.isEmpty())
            for(String s : subs)
               if(nomes.get(position).compareTo(s) == 0)
                   name.setBackgroundColor(Color.BLUE);
        name.setText(nomes.get(position));
        return vw;
    }
}
