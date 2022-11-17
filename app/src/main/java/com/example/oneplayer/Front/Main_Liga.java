package com.example.oneplayer.Front;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oneplayer.Back.*;
import com.example.oneplayer.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class Main_Liga extends AppCompatActivity {
    private Button ranking, novo_jogo, jogos, add_membros, membros, salvar, importt;
    private TextView aviso1;
    public static Liga liga = new Liga("Bagé");
    private String NAME = "liga_militao";
    private File file;
    private int CREATE_FILE = 1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // tela cheia
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        // remove barra do app.
        Objects.requireNonNull(getSupportActionBar()).hide();
        setIds();
        //código para a permissão
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE },1000);
        }

        //para ler ou em caso de vazio, gerar e gravar o arq.
        try{ // tenta ler o objeto!
            FileInputStream getRaiz = new FileInputStream(file);
            ObjectInputStream read = new ObjectInputStream(getRaiz);
            liga = (Liga) read.readObject();
            getRaiz.close();
            read.close();
        }catch (Exception e){
            try { //tenta escrever
                FileOutputStream getR = new FileOutputStream(file);
                ObjectOutputStream write = new ObjectOutputStream(getR);
                write.writeObject(liga);
                getR.close();
                write.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        add_membros.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Liga.this, Add_Jogador.class);
            startActivity(intent);
            finish();
        });

        ranking.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Liga.this, Ranking.class);
            startActivity(intent);
        });
        novo_jogo.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Liga.this, New_Game.class);
            startActivity(intent);
        });
        jogos.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Liga.this, List_Jogos.class);
            startActivity(intent);
        });

        membros.setOnClickListener(v -> {
            Intent intent = new Intent(Main_Liga.this, Membros.class);
            startActivity(intent);
        });

        salvar.setOnClickListener(v -> {
            salvar();
        });

        importt.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("application/obj");
            // Optionally, specify a URI for the file that should appear in the
            // system file picker when it loads.
            startActivityForResult(intent, 1);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permissão Concedida!", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(this, "Permissão Não Concedida!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
    private void salvar() {
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Liga.pdf");
        if(folder.exists())
            folder.mkdir();
        File arquivo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), "/liga/" + "liga_militao");
        try { //tenta escrever
            FileOutputStream salvar = new FileOutputStream(folder);
            ObjectOutputStream write = new ObjectOutputStream(salvar);
            write.writeObject(liga);
            salvar.close();
            write.close();
            Toast.makeText(this, "Arquivo Salvo", Toast.LENGTH_SHORT).show();
            aviso1.setText("Foi");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            Toast.makeText(this, "Arquivo NAO Salvo", Toast.LENGTH_SHORT).show();

        } catch (IOException ioException) {
            Toast.makeText(this, "Arquivo NAO Salvo", Toast.LENGTH_SHORT).show();

            ioException.printStackTrace();
        }
    }

    private void setIds() {
        ranking = findViewById(R.id.ranking);
        novo_jogo = findViewById(R.id.campeonato);
        jogos = findViewById(R.id.jogos);
        add_membros = findViewById(R.id.add_jogador);
        membros = findViewById(R.id.membros);
        salvar = findViewById(R.id.salvar);
        importt = findViewById(R.id.importt);
        aviso1 = findViewById(R.id.textAviso1);

        file = getFileStreamPath(NAME);
        file.setWritable(true,true);
    }
}
