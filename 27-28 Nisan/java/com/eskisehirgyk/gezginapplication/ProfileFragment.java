package com.eskisehirgyk.gezginapplication;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private ImageView imageView;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imageView = view.findViewById(R.id.imageViewProfile);

        view.findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/powerfm");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                intent.setPackage("com.instagram.android");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.d("HATA", "Activity Yok", e);
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/powerfm")));
                }
            }
        });


        view.findViewById(R.id.imageViewProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddPhotoActivity.class));
            }
        });




        //File localFile = File.createTempFile("images", "jpg");


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        firebaseStorage.getReference("profilfotos/"+ FirebaseAuth.getInstance().getCurrentUser().getUid()).getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d("Geldi", "Resim");
                        Glide.with(getContext()).load(uri).into(imageView);

//                        imageView.setImageURI(uri);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d("Hata", "Resim");
            }
        });
    }
}
