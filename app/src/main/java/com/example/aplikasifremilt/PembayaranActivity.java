package com.example.aplikasifremilt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PembayaranActivity extends AppCompatActivity {

    Button b_hitung, b_cetaknota;
    TextView tv_pembayaran, tv_harga, tv_kembalian;
    EditText et_pembayaran, et_harga,et_hasil;
    double angka1, angka2, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        b_hitung = (Button) findViewById(R.id.bhitung);
        b_cetaknota = (Button) findViewById(R.id.bcetak);
        tv_pembayaran = (TextView) findViewById(R.id.tvbayar);
        tv_harga = (TextView) findViewById(R.id.tvharga);
        tv_kembalian = (TextView) findViewById(R.id.tvkembalian);
        et_hasil = (EditText) findViewById(R.id.tvhasil);
        et_pembayaran = (EditText) findViewById(R.id.etbayar);
        et_harga = (EditText) findViewById(R.id.etharga);

        b_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1 = Double.parseDouble(et_pembayaran.getText().toString());
                angka2 = Double.parseDouble(et_harga.getText().toString());
                hasil = angka1 - angka2;
                et_hasil.setText(Double.toString(hasil));


            }
        });

    }
}
