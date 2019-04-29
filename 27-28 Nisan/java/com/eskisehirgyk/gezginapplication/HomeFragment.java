package com.eskisehirgyk.gezginapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private final String TAG = this.getClass().getSimpleName();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


//        FirebaseDatabase.getInstance().getReference("gezdigim").child("0").setValue(new HomeItemModel(R.drawable.foto1, "Trabzon", "Karadeniz'in incisi olarak tabir edilen, eşsiz doğasıyla nefes kesen bir şehir Trabzon.","1"));
//        FirebaseDatabase.getInstance().getReference("gezdigim").child("1").setValue(new HomeItemModel(R.drawable.foto2, "Mardin", "Dicle ve Fırat nehirleri arasında yer alan Mardin Güneydoğu Anadolu Bölgesi'nin en çok merak edilen şehirlerinden biridir.","1"));
//        FirebaseDatabase.getInstance().getReference("gezdigim").child("2").setValue(new HomeItemModel(R.drawable.foto1, "Izmir", "ürkiye'nin batısında, Ege Denizi'nin kıyısında yer alan Ege'nin İncisi İzmir, Türkiye'nin 3'üncü büyük kentidir.","1"));
//        FirebaseDatabase.getInstance().getReference("gezdigim").child("3").setValue(new HomeItemModel(R.drawable.foto1, "Istanbul", "Avrupa ve Asya'yı birbirine bağlayan, çok sayıda medeniyetin izlerini taşıyan istanbul","1"));

        final List<HomeItemModel> homeItemModels = new ArrayList<>();
        final HomeListAdapter homeListAdapter = new HomeListAdapter(homeItemModels, getContext());


        ListView listView = view.findViewById(R.id.listview);

//        homeItemModels.add(new HomeItemModel(R.drawable.foto1, "Trabzon", "Karadeniz'in incisi olarak tabir edilen, eşsiz doğasıyla nefes kesen bir şehir Trabzon."));
//        homeItemModels.add(new HomeItemModel(R.drawable.foto2, "Mardin", "Dicle ve Fırat nehirleri arasında yer alan Mardin Güneydoğu Anadolu Bölgesi'nin en çok merak edilen şehirlerinden biridir."));
//        homeItemModels.add(new HomeItemModel(R.drawable.foto3, "Izmir", "ürkiye'nin batısında, Ege Denizi'nin kıyısında yer alan Ege'nin İncisi İzmir, Türkiye'nin 3'üncü büyük kentidir."));
//        homeItemModels.add(new HomeItemModel(R.drawable.foto4, "Istanbul", "Avrupa ve Asya'yı birbirine bağlayan, çok sayıda medeniyetin izlerini taşıyan istanbul"));


        listView.setAdapter(homeListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(homeItemModels.get(position).getTitle());
                builder.setMessage(homeItemModels.get(position).getMessage());
                builder.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });


        FirebaseDatabase.getInstance().getReference("gezdigim").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                homeItemModels.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HomeItemModel homeItemModel = ds.getValue(HomeItemModel.class);
                    homeItemModels.add(homeItemModel);
                }
                homeListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        return view;
    }

}
