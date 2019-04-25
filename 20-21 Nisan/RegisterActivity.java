package com.eskisehirgyk.gezginapplication;

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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private final String TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        final EditText editTextEmail = findViewById(R.id.emailTXT);
        final EditText editTextPass = findViewById(R.id.sifreTXT);
        final EditText editTextPassTek = findViewById(R.id.sifreTekrarTXT);


        findViewById(R.id.uyeOlBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextEmail.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Email Giriniz.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editTextPass.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Sifre Giriniz.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!editTextPass.getText().toString().trim().equals(editTextPassTek.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "Sifreler Uyusmuyor.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    mAuth.signOut();
                                    Toast.makeText(RegisterActivity.this, "Uyelik Olusturuldu.",
                                            Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "createUserWithEmail:hatali islem geldi");
                        if (e instanceof FirebaseAuthException) {
                            FirebaseAuthException exception = (FirebaseAuthException) e;
                            if (exception.getErrorCode().equals("ERROR_EMAIL_ALREADY_IN_USE")) {
                                Toast.makeText(getApplicationContext(), "Email Kullaniliyor" /*exception.getMessage()*/, Toast.LENGTH_LONG).show();
                            } else if (exception.getErrorCode().equals("ERROR_WEAK_PASSWORD")) {
                                Toast.makeText(getApplicationContext(), "Guclu Sifre Giriniz" /*exception.getMessage()*/, Toast.LENGTH_LONG).show();
                            } else if (exception.getErrorCode().equals("ERROR_INVALID_EMAIL")) {
                                Toast.makeText(getApplicationContext(), "Gecerli Email Giriniz" /*exception.getMessage()*/, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Hata Kullanici Olusturulamadi (Firebase)" /*exception.getMessage()*/, Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Hata Kullanici Olusturulamadi" /*exception.getMessage()*/, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }
}
