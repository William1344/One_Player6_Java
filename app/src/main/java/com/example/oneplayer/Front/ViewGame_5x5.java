package com.example.oneplayer.Front;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.oneplayer.Back.Jogos;
import com.example.oneplayer.Back.Player_Game;
import com.example.oneplayer.R;

import java.util.ArrayList;
import java.util.Objects;

public class ViewGame_5x5 extends AppCompatActivity {
    ArrayList<Player_Game> pg_timeA, pg_timeB;
    Player_Game jgdr;
    Jogos game;
    int plcA, plcB;

    TextView tv_PlcA, tv_PlcB, tv_Jgdr1A, tv_Jgdr1B, tv_Jgdr2A, tv_Jgdr2B, tv_Jgdr3A, tv_Jgdr3B,
            tv_Jgdr4A, tv_Jgdr4B, tv_Jgdr5A, tv_Jgdr5B, tv_2Pts_1A, tv_2Pts_1B, tv_2Pts_2A,
            tv_2Pts_2B, tv_2Pts_3A, tv_2Pts_3B, tv_2Pts_4A, tv_2Pts_4B, tv_2Pts_5A, tv_2Pts_5B,
            tv_3Pts_1A, tv_3Pts_1B, tv_3Pts_2A, tv_3Pts_2B, tv_3Pts_3A, tv_3Pts_3B, tv_3Pts_4A,
            tv_3Pts_4B, tv_3Pts_5A, tv_3Pts_5B, tv_Reb_1A, tv_Reb_1B, tv_Reb_2A, tv_Reb_2B,
            tv_Reb_3A, tv_Reb_3B, tv_Reb_4A, tv_Reb_4B, tv_Reb_5A, tv_Reb_5B, tv_Ast_1A, tv_Ast_1B,
            tv_Ast_2A, tv_Ast_2B, tv_Ast_3A, tv_Ast_3B, tv_Ast_4A, tv_Ast_4B, tv_Ast_5A, tv_Ast_5B,
            tv_Blk_1A, tv_Blk_1B, tv_Blk_2A, tv_Blk_2B, tv_Blk_3A, tv_Blk_3B, tv_Blk_4A, tv_Blk_4B,
            tv_Blk_5A, tv_Blk_5B, tv_VS, tv_Placar;
    Button end_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_game5x5);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setIds();
        Intent intent = getIntent();
        game = (Jogos)intent.getSerializableExtra("game");
        pg_timeA = game.getTimeA();
        pg_timeB = game.getTimeB();
        plcA = game.getPlcA();
        plcB = game.getPlcB();

        end_view.setOnClickListener(v -> {
            Intent intent1 = new Intent(ViewGame_5x5.this, Main_Liga.class);
            startActivity(intent1);
            finish();
        });
        loadInterface();
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
        end_view = findViewById(R.id.b_end_game);
        tv_Placar = findViewById(R.id.tV_Placar);

    }
}