package com.example.aplikasifremilt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    RecyclerView rv;
    FremiltAdapter adapter;
    FremiltData data;
    List<FremiltModel> fremiltModels = new ArrayList<>();
    Button btnBeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        adapter = new FremiltAdapter(this, fremiltModels);
        rv.setAdapter(adapter);
        data = new FremiltData(this,this);
        data.setData();

     /*   btnBeli = findViewById(R.id.btn_beli);
        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PemesananActivity.class));
            }
        });*/
    }

    public void onSuccess(List<FremiltModel> fremiltModels){
        this.fremiltModels.clear();
        this.fremiltModels.addAll(fremiltModels);
        this.adapter.notifyDataSetChanged();
    }
}
