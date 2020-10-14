package com.example.creandobotonesdinamicos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    Button borrar;
    EditText editText;
    Button[] arrayBotones;

    int[] botones;
    int CANTIDAD = 10;

    int dameColorAleatorio() {
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256));
        return color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        borrar = findViewById(R.id.buttonBorrar);
        layout = findViewById(R.id.layout);
        editText = findViewById(R.id.editTextNumber);
        //arrayBotones = new Button[CANTIDAD];
        botones = new int[CANTIDAD];
        for (int i = 0; i < CANTIDAD; i++) {
            Button b = new Button(this);
            arrayBotones[i] = b;
            b.setId(View.generateViewId());
            botones[i] = b.getId();
            b.setText("Botón");
            b.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setBackgroundColor(dameColorAleatorio());
            layout.addView(b);
            int finalI = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "Soy el botón: " + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = Integer.parseInt(editText.getText().toString());
               // arrayBotones[posicion].setVisibility(View.INVISIBLE);

                if (posicion >=0 && posicion < CANTIDAD){
                    Button b = findViewById(botones[posicion]);
                    b.setVisibility(View.INVISIBLE);
                }

                            }
        });


    }
}