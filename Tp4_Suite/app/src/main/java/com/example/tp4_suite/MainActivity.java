package com.example.tp4_suite;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lesResultats.add(new Resultat("Ahmed","Ben Ahmed" , (float) 15.5,R.drawable.ok));
        lesResultats.add(new Resultat("Salah","Ben Ahmed" , (float) 9,R.drawable.not_ok));
        lesResultats.add(new Resultat("Fatima","Ben Mohamed" , (float) 17,R.drawable.ok));
        lesResultats.add(new Resultat("Aicha","Ben Brahim" , (float) 12,R.drawable.ok));
        lesResultats.add(new Resultat("Leila","Aziza" , (float) 10,R.drawable.ok));
        lesResultats.add(new Resultat("Khadija","Khaled" , (float) 5.5,R.drawable.not_ok));

        recyclerView = findViewById(R.id.recyclerView);

        MyAdapter adapter = new MyAdapter(lesResultats);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}