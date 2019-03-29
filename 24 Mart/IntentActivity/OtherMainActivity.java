package com.eskisehirgyk.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_main);

        Intent intent = getIntent();

//        String stringExtra = intent.getStringExtra("key1");
//

//        String stringExtra = intent.getStringExtra(MainActivity.parametre1);


        TextView textView = findViewById(R.id.tvSonuc);
//        textView.setText(stringExtra);

        //textView.setText(getIntent().getStringExtra(MainActivity.parametre1));


        String x = intent.getStringExtra(MainActivity.xdegeri);
        String y = intent.getStringExtra(MainActivity.ydegeri);

//        int z = intent.getIntExtra(MainActivity.ydegeri, 0);
        final int t = Integer.parseInt(y);
//        int k = (int) y;
        final int r = Integer.valueOf(x);
//        int p = intent.getIntExtra(MainActivity.xdegeri2, 0);
//

        textView.setText((t + r) + "");

        Button button = findViewById(R.id.buttonYolla);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra(MainActivity.sonuc, String.valueOf(t + r));
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });

    }
}
