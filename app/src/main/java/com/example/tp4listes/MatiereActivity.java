package com.example.tp4listes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MatiereActivity extends AppCompatActivity {
    AutoCompleteTextView matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matiere);

        matiere = findViewById(R.id.matiere);

        String[] matieres = {
                "Algoritmique", "Android", "Programmation C", "Programmation OO"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                matieres
        );

        matiere.setAdapter(adapter);

        matiere.setOnItemClickListener((parent, view, position, id) -> {
            String selected = (String) parent.getItemAtPosition(position);
            Toast.makeText(MatiereActivity.this, "Matière : " + selected, Toast.LENGTH_SHORT).show();
        });
    }
}