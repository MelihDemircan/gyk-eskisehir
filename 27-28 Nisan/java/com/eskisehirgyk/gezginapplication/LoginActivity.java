package com.eskisehirgyk.gezginapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();



        if(mAuth.getCurrentUser() != null){
            Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        final EditText editTextEmail = findViewById(R.id.emailTXT);
        final EditText editTextPass = findViewById(R.id.sifreTXT);

        findViewById(R.id.girisBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextEmail.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email Giriniz.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editTextPass.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Sifre Giriniz.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // updateUI(user);
                                    Toast.makeText(LoginActivity.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
                                    startActivity(intent);
                                    finish();

                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        if (e instanceof FirebaseAuthInvalidCredentialsException){
                            Toast.makeText(LoginActivity.this, "Gecersiz Email veya Sifre.",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "Gecersiz Giris.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        findViewById(R.id.uyeOlBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }


}
