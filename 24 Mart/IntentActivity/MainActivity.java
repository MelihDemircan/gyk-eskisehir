package com.eskisehirgyk.intentactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String parametre1 = "asdfghjkl";
    public static final String xdegeri = "xdegeri";
    public static final String ydegeri = "ydegeri";
    public static final String xdegeri2 = "xdegeri2";
    public static final String sonuc = "sonuc34";


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewSonuc);

        final Context context = this;

        final EditText editTextX = findViewById(R.id.edittextX);
        final EditText editTextY = findViewById(R.id.edittextY);

        Button button = findViewById(R.id.buttonDiger);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OtherMainActivity.class);
//                Intent intent = new Intent(context, OtherMainActivity.class);
//                Intent intent =  new Intent(MainActivity.this, OtherMainActivity.class);
//                intent.putExtra("key1", "stringValue");

                intent.putExtra(MainActivity.parametre1, "stringValue");
                intent.putExtra(MainActivity.xdegeri, editTextX.getText().toString());
                intent.putExtra(MainActivity.ydegeri, editTextY.getText().toString());
                intent.putExtra(MainActivity.xdegeri2, Integer.valueOf(editTextY.getText().toString()));

                //
                // startActivity(intent);

                startActivityForResult(intent, 123);
            }
        });

//        findViewById(R.id.buttonDiger).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Deneme", "Deneme");
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText(data.getStringExtra(MainActivity.sonuc));
    }
}
