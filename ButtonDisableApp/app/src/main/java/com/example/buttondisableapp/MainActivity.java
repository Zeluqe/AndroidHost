package com.example.buttondisableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonDisable;
    private Button buttonEnable;
    private TextView licznik; // Tekst licznika kliknięć
    private int liczbaKlikniec = 0; // Licznik kliknięć

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja przycisków i tekstu licznika
        buttonDisable = findViewById(R.id.buttonDisable);
        buttonEnable = findViewById(R.id.buttonEnable);
        licznik = findViewById(R.id.licznik);

        // Ustawienie nasłuchiwania dla dużego przycisku (dezaktywacja po kliknięciu)
        buttonDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Zwiększanie licznika po każdym kliknięciu
                liczbaKlikniec++;

                // Dezaktywacja dużego przycisku
                buttonDisable.setEnabled(false);

                // Zaktualizowanie tekstu licznika
                licznik.setText("Liczba kliknięć: " + liczbaKlikniec);

                // Wyświetlenie powiadomienia Toast
                Toast.makeText(MainActivity.this, "Duży przycisk został wyłączony", Toast.LENGTH_SHORT).show();
            }
        });

        // Ustawienie nasłuchiwania dla mniejszego przycisku (aktywacja dużego przycisku po kliknięciu)
        buttonEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ponowne włączenie dużego przycisku
                buttonDisable.setEnabled(true);

                // Wyświetlenie powiadomienia Toast
                Toast.makeText(MainActivity.this, "Duży przycisk został aktywowany", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
