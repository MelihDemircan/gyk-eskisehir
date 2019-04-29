package com.eskisehirgyk.gezginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final EditText editText = findViewById(R.id.editText);

        //Not Ekle
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseReference reference =  database.getReference("notlarım2").child("child").child("not");
                ///reference.setValue("dfgh");
                DatabaseReference reference = database.getReference("notlarım2").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                String key = reference.push().getKey();
                reference.child(key).child("not").setValue(editText.getText().toString());
            }
        });

        //Geri Don
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

}
