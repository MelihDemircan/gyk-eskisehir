package com.eskisehirgyk.listviewactivity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyCustomAdapter extends BaseAdapter {

    Context contextx;
    List<String> list;
    List<String> list2;
    List<Map<String, String>> listMap;
    List<Person> listPerson;

    public MyCustomAdapter(Context context, List<String> list, List<String> list2, List<Map<String, String>> listMap,
                           List<Person> listPerson) {
        this.contextx = context;
        this.list = list;
        this.list2 = list2;
        this.listMap = listMap;
        this.listPerson = listPerson;
    }

    @Override
    public int getCount() {
        return listPerson.size();
    }

    @Override
    public Object getItem(int position) {
        return listPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //1. Yontem
        View view = View.inflate(contextx, R.layout.list_my_item, null);
        TextView textView = view.findViewById(R.id.item1);
//        textView.setText(list.get(position));
//        textView.setText(listMap.get(position).get("mapItem1"));
//         String a =  listMap.get(position).keySet().toArray(new String[listMap.get(position).keySet().size()])[0];
        textView.setText(listPerson.get(position).getItem1Value());

        TextView textView2 = view.findViewById(R.id.item2);
//        textView2.setText(list2.get(position));
//        textView2.setText(listMap.get(position).get("mapItem2"));
        textView2.setText(listPerson.get(position).getItemValue2());


        final ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(listPerson.get(position).getImage());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tiklandi", "" + position);
                imageView.setImageResource(android.R.drawable.btn_plus);
            }
        });
        return view;
    }
}