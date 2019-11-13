package com.example.aplikasifremilt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PemesananActivity extends AppCompatActivity {

    TextView nama,biaya,totbiaya;
    ImageView foto;
    Button btnPesan, btnBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        nama = findViewById(R.id.cars_name);
        biaya = findViewById(R.id.minuman_harga);
        foto = findViewById(R.id.cars_thumbnail);
        totbiaya = findViewById(R.id.biaya);
        btnPesan = findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PemesananActivity.this, MainActivity.class));
            }
        });
        btnBayar = findViewById(R.id.btnBayar);
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PemesananActivity.this, PembayaranActivity.class));
            }
        });

        String name = getIntent().getStringExtra("name");
        int gambar = getIntent().getIntExtra("image", 1);
        String harga = getIntent().getStringExtra("harga");
        String totalbiaya = getIntent().getStringExtra("harga");

        foto.setImageResource(gambar);
        nama.setText(name);
        biaya.setText(harga);
        totbiaya.setText(totalbiaya);
    }
}
