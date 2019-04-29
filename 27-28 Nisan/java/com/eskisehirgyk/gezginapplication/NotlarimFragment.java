package com.eskisehirgyk.gezginapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotlarimFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public NotlarimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notlarim, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

         final ListView listView = view.findViewById(R.id.listview);


        final List<String> list = new ArrayList<>();
        
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1, android.R.id.text1, list){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
              View view = super.getView(position, convertView, parent);
              view.findViewById(android.R.id.text1).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Log.d("deger","tiklandi");
                  }
              });
              TextView textView = view.findViewById(android.R.id.text1);
                textView.setText(textView.getText().toString() + " Deger");
              return view;
            }
        };

        listView.setAdapter(arrayAdapter);

        database.getReference("notlarım2").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //((ArrayList) dataSnapshot.getValue()).get(2);
                list.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    DataSnapshot snap = ds.child("not");
                    String string = snap.getValue(String.class);
                    Log.d(TAG, "Value is: ");
                    list.add(string);
                }
                arrayAdapter.notifyDataSetChanged();
                Log.d(TAG, "Value is: ");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        view.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddNoteActivity.class));
            }
        });

        return view;
    }

}
