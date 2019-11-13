package com.example.aplikasifremilt;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aplikasifremilt.FremiltModel;
import com.example.aplikasifremilt.R;

import java.util.ArrayList;
import java.util.List;

public class FremiltAdapter extends RecyclerView.Adapter<FremiltAdapter.ViewHolder> {
    Context context;
    Dialog myDialog;
    List<FremiltModel> fremiltModels = new ArrayList<>();

    public FremiltAdapter(Context context, List<FremiltModel> fremiltModels) {
        this.context = context;
        this.fremiltModels = fremiltModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_minuman, viewGroup, false); // menghubungkan ke layout
        ViewHolder holder = new ViewHolder(view); // deklarasi class ViewHolder di baris 46
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.onBind(fremiltModels.get(i));
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.detail_item);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_title_id = (TextView) myDialog.findViewById(R.id.dialog_title_id);
                ImageView dialog_image_id = (ImageView) myDialog.findViewById(R.id.dialog_image_id);
                TextView dialog_harga = (TextView) myDialog.findViewById(R.id.dialog_harga);
                dialog_title_id.setText(fremiltModels.get(viewHolder.getAdapterPosition()).getNamaTempat());
                dialog_image_id.setImageResource(fremiltModels.get(viewHolder.getAdapterPosition()).getFotoTempat());
                dialog_harga.setText(fremiltModels.get(viewHolder.getAdapterPosition()).getHarga());
                TextView total = (TextView) myDialog.findViewById(R.id.etTotal);
                Button btnBeli = (Button) myDialog.findViewById(R.id.btnBeli);
                btnBeli.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, PemesananActivity.class);
                            intent.putExtra("image", fremiltModels.get(i).getFotoTempat());
                            intent.putExtra("name", fremiltModels.get(i).getNamaTempat());
                            intent.putExtra("harga", fremiltModels.get(i).getHarga());
                        context.startActivity(intent);
                    }
                });

                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fremiltModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama;
        TextView tvHarga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.cars_thumbnail);
            tvNama = itemView.findViewById(R.id.cars_name);
            tvHarga = itemView.findViewById(R.id.minuman_harga);
        }

        public void onBind(final FremiltModel destinasi) {
            tvNama.setText(destinasi.getNamaTempat());
            ivFoto.setImageResource(destinasi.getFotoTempat());
            tvHarga.setText(destinasi.getHarga());
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context, destinasi.getNamaTempat(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
