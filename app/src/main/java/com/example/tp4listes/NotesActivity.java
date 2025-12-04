package com.example.tp4listes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {
    ListView simpleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        simpleListView = findViewById(R.id.simpleListView);
        String[] notes = getResources().getStringArray(R.array.notes);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                notes
        );

        simpleListView.setAdapter(arrayAdapter);

        simpleListView.setOnItemClickListener((adapterView, view, i, l) -> {
            String noteStr = (String) adapterView.getItemAtPosition(i);
            float note = Float.parseFloat(noteStr);
            String message = note > 10 ? "Réussi" : "Échoué..";
            Toast.makeText(NotesActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}