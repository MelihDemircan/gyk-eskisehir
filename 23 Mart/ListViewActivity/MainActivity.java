package com.eskisehirgyk.listviewactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        //1. Yontem array
//        String[] stringArray = new String[3];
//        stringArray[0] = "1. Deger";
//        stringArray[1] = "2. Deger";
//
//        String[] stringArray = {"1. Deger", "2. Deger", "3. Deger"};
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , android.R.layout.simple_list_item_1
//                , android.R.id.text1
//                , stringArray);
//
//        listView.setAdapter(arrayAdapter);

        //2. Yontem getResources
//        String[] stringArray = getResources()
//                .getStringArray(R.array.stringarray);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , android.R.layout.simple_list_item_1
//                , android.R.id.text2
//                , stringArray);
//
//        listView.setAdapter(arrayAdapter);


        //3. Yontem List
//        List<String> list = new ArrayList<>();
//        list.add("1. Deger");
//        list.add("2. Deger");
//        list.add("3. Deger");

//        List<String> list2 = Arrays
//                .asList("1. Deger", "2. Deger", "3. Deger");
//
//
//        List<String> list3 = new ArrayList<>(Arrays
//                .asList("1. Deger", "2. Deger", "3. Deger"));
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , android.R.layout.simple_list_item_1
//                , android.R.id.text1
//                , list);
//
//        listView.setAdapter(arrayAdapter);


        //4. Yontem Cast getResources
//        String[] array = getResources().getStringArray(R.array.stringarray);
//        List<String> list = Arrays.asList(array);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , android.R.layout.simple_list_item_1
//                , android.R.id.text1
//                , list);
//
//        listView.setAdapter(arrayAdapter);


        // 5. Yontem Other android layout

//        List<String> list = new ArrayList<>();
//        list.add("1. Deger");
//        list.add("2. Deger");
//        list.add("3. Deger");
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , android.R.layout.browser_link_context_header
//                , android.R.id.title
//                , list);
//
//        listView.setAdapter(arrayAdapter);


        //6. Yontem Kendi Layoutumuz

//        List<String> list = new ArrayList<>();
//        list.add("1. Deger");
//        list.add("2. Deger");
//        list.add("3. Deger");
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext()
//                , R.layout.list_my_item
//                , R.id.item1
//                , list);
//
//        listView.setAdapter(arrayAdapter);


        //7. Yontem
//        List<Map<String, String>> listMap = new ArrayList<>();
//
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("mapItem1", "1. Deger");
//        map1.put("mapItem2", "1. DegerYan");
//        listMap.add(map1);
//
//        Map<String, String> map2 = new HashMap<>();
//        map2.put("mapItem1", "2. Deger");
//        map2.put("mapItem2", "2. DegerYan");
//        listMap.add(map2);
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext()
//                ,listMap
//                ,R.layout.list_my_item
//                ,new String[]{"mapItem1","mapItem2"}
//                /*,map1.keySet().toArray(new String[map1.keySet().size()])*/
//                ,new int[]{R.id.item2,R.id.item1}
//                );
//        listView.setAdapter(simpleAdapter);


        //8. Yontem Simple Adapter

//        List<Map<String, String>> listMap = new ArrayList<>();
//
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("mapItem1", "1. Deger");
//        map1.put("mapItem2", String.valueOf(android.R.drawable.btn_star));
//        listMap.add(map1);
//
//        Map<String, String> map2 = new HashMap<>();
//        map2.put("mapItem1", "2. Deger");
//        map2.put("mapItem2", String.valueOf(R.mipmap.ic_launcher_round));
//        listMap.add(map2);
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext()
//                ,listMap
//                ,R.layout.list_my_item
//                ,new String[]{"mapItem1","mapItem2"}
//                /*,map1.keySet().toArray(new String[map1.keySet().size()])*/
//                ,new int[]{R.id.item1,R.id.imageView}
//        );
//        listView.setAdapter(simpleAdapter);


        //9. Yontem Adapter Custom

        List<String> list = new ArrayList<>();
        list.add("1. Deger");
        list.add("2. Deger");
        list.add("3. Deger");
        list.add("4. Deger");

        List<String> list2 = new ArrayList<>();
        list2.add("1. DegerYan");
        list2.add("2. DegerYan");
        list2.add("3. DegerYan");

        List<Map<String, String>> listMap = new ArrayList<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("mapItem1", "1. Deger");
        map1.put("mapItem2", "1. DegerYan");
        listMap.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("mapItem1", "2. Deger");
        map2.put("mapItem2", "2. DegerYan");
        listMap.add(map2);


        final List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("1. Deger","1. DegerYan", R.mipmap.ic_launcher_round));
        listPerson.add(new Person("2. Deger","2. DegerYan", android.R.drawable.btn_star));
        listPerson.add(new Person("3. Deger","3. DegerYan", android.R.drawable.btn_star));
        listPerson.add(new Person("4. Deger","4. DegerYan", android.R.drawable.btn_star));
        listPerson.add(new Person("5. Deger","5. DegerYan", android.R.drawable.btn_star));
        listPerson.add(new Person("6. Deger","6. DegerYan", android.R.drawable.btn_star));

        final MyCustomAdapter myCustomAdapter = new MyCustomAdapter(getApplicationContext(),list,list2, listMap,listPerson);
        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.d("Tiklandi",String.valueOf(position));
                //Log.d("Tiklandi", "" + position);

            }
        });

        Button button = findViewById(R.id.buttonEkle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPerson.add(new Person("X. Deger","X. DegerYan", android.R.drawable.btn_star));
                myCustomAdapter.notifyDataSetChanged();
            }
        });

    }
}
