package com.eskisehirgyk.gezginapplication;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

public class HomeListAdapter extends BaseAdapter {

    private final String TAG = this.getClass().getSimpleName();

    private List<HomeItemModel> homeItemModels;
    private Context context;

    public HomeListAdapter(List<HomeItemModel> homeItemModels, Context context) {
        this.homeItemModels = homeItemModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return homeItemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return homeItemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        View view = View.inflate(context, R.layout.home_item_layout, null);


        final ImageView imageView = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.titleTXT);
        TextView message = view.findViewById(R.id.messageTXT);

        final HomeItemModel homeItemModel = homeItemModels.get(position);

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        firebaseStorage.getReference(homeItemModel.getImageUrl()).getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Log.d(TAG, position + ". Image Download");
                        Glide.with(context).load(uri).into(imageView);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(TAG, "HATA " + homeItemModel.getImageUrl(), exception);
            }
        });

        //imageView.setImageResource(homeItemModel.getImage());
        title.setText(homeItemModel.getTitle());
        message.setText(homeItemModel.getMessage());
        return view;
    }
}
