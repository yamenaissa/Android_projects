package com.example.databasetp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    EditText posteInput, descInput;
    Button saveBtn;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        posteInput=findViewById(R.id.etPoste);
        descInput=findViewById(R.id.etDescription);
        saveBtn=findViewById(R.id.btnSave);
        dao=new DAO(this);

        saveBtn.setOnClickListener(v->{
            dao.addOffre(new Offre(posteInput.getText().toString(), descInput.getText().toString()));
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}