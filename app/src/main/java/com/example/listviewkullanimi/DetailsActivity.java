package com.example.listviewkullanimi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView sehirIsmi,sehirAciklama;
    private ImageView sehirResmi;
    private String sAciklama,sIsim;
    private Bitmap secilenSehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        sehirIsmi=findViewById(R.id.details_activity_textViewSehirIsmi);
        sehirAciklama=findViewById(R.id.details_activity_textViewDetay);
        sehirResmi=findViewById(R.id.details_activity_imageViewSehirResmi);


        sIsim=MainActivity.sehir.getIsim();
        sAciklama=MainActivity.sehir.getAciklama();
        secilenSehir=MainActivity.sehir.getResim();

        if (!TextUtils.isEmpty(sIsim) && !TextUtils.isEmpty(sAciklama)){
           sehirIsmi.setText(sIsim);
           sehirAciklama.setText(sAciklama);
           sehirResmi.setImageBitmap(secilenSehir);
        }
    }
}