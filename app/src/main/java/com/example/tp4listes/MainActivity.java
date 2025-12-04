package com.example.tp4listes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Resultat> lesResultats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        lesResultats.add(new Resultat("Ahmed", "Ben Ahmed", 15.5f, R.drawable.ok));
        lesResultats.add(new Resultat("Salah", "Ben Ahmed", 9f, R.drawable.ko));
        lesResultats.add(new Resultat("Fatima", "Ben Mohamed", 17f, R.drawable.ok));
        lesResultats.add(new Resultat("Aicha", "Ben Brahim", 12f, R.drawable.ok));
        lesResultats.add(new Resultat("Leila", "Aziza", 10f, R.drawable.ok));
        lesResultats.add(new Resultat("Khadija", "Khaled", 5.5f, R.drawable.ko));

        MyAdapter adapter = new MyAdapter(lesResultats);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}