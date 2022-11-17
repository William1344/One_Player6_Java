package com.example.oneplayer.Front;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.oneplayer.Back.Player;
import com.example.oneplayer.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class Add_Jogador extends AppCompatActivity {
    Button b_add;
    boolean estado_nome = false;
    TextInputEditText ted_tag;
    String name;
    private String NAME = "liga_militao";
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jogador);
        Objects.requireNonNull(getSupportActionBar()).hide();
        b_add = findViewById(R.id.add);
        ted_tag = findViewById(R.id.tagPlay1);
        file = getFileStreamPath(NAME);

        ted_tag.setOnClickListener(v -> {
            ted_tag.setText(" ");
        });
        b_add.setOnClickListener(v -> {
            name = String.valueOf(ted_tag.getText());
            if(name.isEmpty()) ted_tag.setText("Informe um apelido");
            else {
                for(Player a : Main_Liga.liga.getJogadores()){
                    if(name.compareTo(a.getTag()) == 0){
                        ted_tag.setText("Apelido existente");
                        estado_nome = true;
                        break;
                    }
                }
                if(!estado_nome){
                    Main_Liga.liga.add_Player(name);
                    try { //tenta escrever
                        FileOutputStream getR = new FileOutputStream(file);
                        ObjectOutputStream write = new ObjectOutputStream(getR);
                        write.writeObject(Main_Liga.liga);
                        getR.close();
                        write.close();
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    Intent intent = new Intent(Add_Jogador.this, Main_Liga.class);
                    startActivity(intent);
                    finish();
                }
                else estado_nome = false;

            }
        });

    }
}