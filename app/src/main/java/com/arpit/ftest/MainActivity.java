    package com.arpit.ftest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText mFullName , mEmail , mPassword , mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPhone = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.registerBtn);

        mAuth = FirebaseAuth.getInstance();

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser !=null){
            //Trans to next
        }
    }
    private void signup(){
        mAuth.createUserWithEmailAndPassword(String.valueOf(mEmail.getText()), String.valueOf(mPassword.getText())).addOnCompleteListener(this, task -> {
            if(task.isSuccessful()) {
                Toast.makeText(MainActivity.this,"You are registered",Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(MainActivity.this ,"you are notregistered" , Toast.LENGTH_LONG).show();
            }
        });

    }
}