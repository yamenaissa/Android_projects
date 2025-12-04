package com.example.noteti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText mloginemail, mloginpassword;
    RelativeLayout mlogin, mgotosignup;
    TextView mgotoforgotpassword;
    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarofmainactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            mloginemail = findViewById(R.id.loginemail);
            mloginpassword = findViewById(R.id.loginpassword);
            mlogin = findViewById(R.id.login);
            mgotoforgotpassword = findViewById(R.id.gotoforgotpassword);
            mgotosignup = findViewById(R.id.gotosignup);
            mprogressbarofmainactivity=findViewById(R.id.progressbarofmainactivity);

            firebaseAuth = FirebaseAuth.getInstance();
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

            if (firebaseUser != null) {
                finish();
                startActivity(new Intent(MainActivity.this, notesactivity.class));
                return;
            }

            mgotosignup.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            });

            mgotoforgotpassword.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, forgotpassword.class);
                startActivity(intent);
            });

            mlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mail = mloginemail.getText().toString().trim();
                    String password = mloginpassword.getText().toString().trim();

                    if (mail.isEmpty() || password.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "All Fields Are Required", Toast.LENGTH_SHORT).show();
                    } else {
                        mprogressbarofmainactivity.setVisibility(View.VISIBLE);
                        firebaseAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    checkmailverification();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Account does not exist", Toast.LENGTH_SHORT).show();
                                    mprogressbarofmainactivity.setVisibility(View.INVISIBLE);
                                }
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void checkmailverification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null && firebaseUser.isEmailVerified()) {
            Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(MainActivity.this, notesactivity.class));
        } else {
            mprogressbarofmainactivity.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Verify your mail first", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}