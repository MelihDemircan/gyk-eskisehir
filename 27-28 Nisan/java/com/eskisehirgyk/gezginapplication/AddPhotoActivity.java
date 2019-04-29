package com.eskisehirgyk.gezginapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.UploadTask;

public class AddPhotoActivity extends AppCompatActivity {

    private ImageView imageView;
    private Uri filedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        imageView = findViewById(R.id.imageViewProfile);

        findViewById(R.id.buttonSec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 21);
            }
        });


        final FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        findViewById(R.id.buttonKaydet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseStorage.getReference("profilfotos/"+ FirebaseAuth.getInstance().getCurrentUser().getUid()).putFile(filedata).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Log.d("asd", "asd");
                        onBackPressed();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("asd", "asd");

                    }
                });
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 21 && resultCode == RESULT_OK) {
            Log.d("asd", "asd");
            filedata = data.getData();
            Glide.with(getApplicationContext()).load(data.getData()).into(imageView);
        }

    }
}
