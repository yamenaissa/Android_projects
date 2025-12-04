package com.example.tp4_listes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MatiereActivity extends AppCompatActivity {


    AutoCompleteTextView matiere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matiere);
        matiere=findViewById(R.id.matiere);
        String matieres[] = {"Algoritmique", "Android","Programmation C", "Programmation OO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                matieres
        );
        matiere.setAdapter(adapter);

        matiere.setOnItemClickListener((parent, view, position, id) -> {
            String mat = (String) parent.getItemAtPosition(position);
            Toast.makeText(MatiereActivity.this, "Matière : " +mat, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.aml), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}