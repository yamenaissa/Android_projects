package com.example.tp4_listes;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotesActivity extends AppCompatActivity {
    ListView simpleListView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
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
            String note1 = (String) adapterView.getItemAtPosition(i);
            float note2 = Float.parseFloat(note1);
            String message = note2 > 10 ? "Réussi avec la moyenne "+note1 : "Échoué..";
            Toast.makeText(NotesActivity.this, message, Toast.LENGTH_SHORT).show();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.a), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}