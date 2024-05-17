package com.example.listviewkullanimi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] sehirler={"Adana","Muş","Van","Kars","Kahramanmaraş","Gaziantep",
                                "Aydın","Batman","Isparta","Burdur","Hatay","Afyon",
                                "Bursa","Bolu","Denizli","Burdur","Manisa","Mardin"};
    private String[] sehirlerAciklama={"Açıklama","Açıklama","Açıklama","Açıklama"};
    private int[] sehirlerResim={R.drawable.adana,R.drawable.mus,R.drawable.van,R.drawable.kars};
    private Intent detailsIntent;
    static public Sehir sehir;
    private Bitmap secilenSehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.main_activity_listView);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,sehirler);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sehirler[position], Toast.LENGTH_SHORT).show();
                detailsIntent=new Intent(MainActivity.this,DetailsActivity.class);
                secilenSehir= BitmapFactory.decodeResource(getApplicationContext().getResources(),sehirlerResim[position]);
                sehir=new Sehir(sehirlerAciklama[position],sehirler[position],secilenSehir);
                startActivity(detailsIntent);
            }
        });
    }
}