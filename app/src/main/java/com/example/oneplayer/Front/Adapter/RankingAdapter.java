package com.example.oneplayer.Front.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oneplayer.Back.Player;
import com.example.oneplayer.Front.Main_Liga;
import com.example.oneplayer.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RankingAdapter extends BaseAdapter{

    ArrayList<Player> playerList;
    Player pl;
    Activity act;
    int modo = 0;
    TextView tv_nome, tv_jgs, tv_vit, tv_fg, tv_clt, tv_TP, tv_2pts, tv_3pts,
            tv_reb, tv_ast, tv_blk, tv_TPG, tv_2PG, tv_3PG, tv_RPG, tv_APG,
            tv_BPG;

    public RankingAdapter(Activity ac, ArrayList<Player> list, int m){
        playerList = list;
        act = ac;
        modo = m;
    }


    @Override
    public int getCount() {return playerList.size();}

    @Override
    public Object getItem(int position) {return playerList.get(position);}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vw = act.getLayoutInflater().inflate(R.layout.ranking_list,parent, false);
        pl = playerList.get(position);
        tv_nome = vw.findViewById(R.id.tV_jogador);
        tv_jgs = vw.findViewById(R.id.tV_jgs);
        tv_vit = vw.findViewById(R.id.tV_vit);
        tv_fg = vw.findViewById(R.id.tV_FG);
        tv_clt = vw.findViewById(R.id.tV_clt);
        tv_TP = vw.findViewById(R.id.tV_TP);
        tv_2pts = vw.findViewById(R.id.tV_2Pts);
        tv_3pts = vw.findViewById(R.id.tV_3Pts);
        tv_reb = vw.findViewById(R.id.tV_Reb);
        tv_ast = vw.findViewById(R.id.tV_Ast);
        tv_blk = vw.findViewById(R.id.tV_Blk);
        tv_TPG = vw.findViewById(R.id.tV_TPG);
        tv_2PG = vw.findViewById(R.id.tV_2PG);
        tv_3PG = vw.findViewById(R.id.tV_3PG);
        tv_RPG = vw.findViewById(R.id.tV_RPG);
        tv_APG = vw.findViewById(R.id.tV_APG);
        tv_BPG = vw.findViewById(R.id.tV_BPG);
        loadInterface();
        return vw;
    }

    private void loadInterface() {
        DecimalFormat df = new DecimalFormat("0.0");
        tv_nome.setText(pl.getTag());
        tv_jgs.setText(String.format(""+ pl.getScores(modo).getJogos()));
        tv_vit.setText(String.format(""+ pl.getScores(modo).getVit()));
        tv_fg.setText(df.format(pl.getScores(modo).getFG()));
        tv_clt.setText(String.format(""+pl.getScores(modo).getCluth()));
        tv_TP.setText(String.format(""+ pl.getScores(modo).getTotal_pts()));
        tv_2pts.setText(String.format(""+ pl.getScores(modo).getA_2pts()));
        tv_3pts.setText( String.format(""+ pl.getScores(modo).getA_3pts()));
        tv_reb.setText(String.format(""+ pl.getScores(modo).getRebt()));
        tv_ast.setText(String.format(""+ pl.getScores(modo).getAsst()));
        tv_blk.setText(String.format(""+ pl.getScores(modo).getBlock()));
        tv_TPG.setText( df.format(pl.getScores(modo).getTotal_PPG()));
        tv_2PG.setText( df.format(pl.getScores(modo).getA_2PG()));
        tv_3PG.setText( df.format(pl.getScores(modo).getA_3PG()));
        tv_RPG.setText( df.format(pl.getScores(modo).getA_RPG()));
        tv_APG.setText( df.format(pl.getScores(modo).getA_APG()));
        tv_BPG.setText( df.format(pl.getScores(modo).getA_BPG()));
    }
}
