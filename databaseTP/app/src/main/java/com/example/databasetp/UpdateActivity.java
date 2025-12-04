package com.example.databasetp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateActivity extends AppCompatActivity {

    EditText posteInput, descInput;
    Button updateBtn,deleteBtn;
    DAO dao;
    int offreid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);

        posteInput = findViewById(R.id.etUpdatePoste);
        descInput=findViewById(R.id.etUpdateDescription);
        updateBtn=findViewById(R.id.btnUpdate);

        dao=new DAO(this);

        offreid=getIntent().getIntExtra("id",-1);

        updateBtn.setOnClickListener(v ->{
            dao.updateOffre(offreid, posteInput.getText().toString(), descInput.getText().toString());
            finish();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}