package com.example.lab01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Zadanie7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadanie7);

        String[] tytuly = {"Laptop", "Telefon", "Słuchawki", "Monitor", "Klawiatura", "Mysz", "Drukarka"};
        String[] opisy = {
                "Laptop 15 cali, 16 GB RAM",
                "Smartfon z Androidem",
                "Słuchawki bezprzewodowe",
                "Monitor 24 cale Full HD",
                "Klawiatura mechaniczna",
                "Mysz optyczna USB",
                "Drukarka atramentowa"
        };

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ProduktAdapter(tytuly, opisy));
    }

    static class ProduktAdapter extends RecyclerView.Adapter<ProduktAdapter.VH> {

        private final String[] tytuly;
        private final String[] opisy;

        ProduktAdapter(String[] tytuly, String[] opisy) {
            this.tytuly = tytuly;
            this.opisy = opisy;
        }

        class VH extends RecyclerView.ViewHolder {
            TextView tytul;
            TextView opis;

            VH(View v) {
                super(v);
                tytul = v.findViewById(R.id.tytul);
                opis = v.findViewById(R.id.opis);
            }
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_produkt, parent, false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            final String nazwa = tytuly[position];
            holder.tytul.setText(nazwa);
            holder.opis.setText(opisy[position]);
            holder.itemView.setOnClickListener(v ->
                    Toast.makeText(v.getContext(), nazwa, Toast.LENGTH_SHORT).show());
        }

        @Override
        public int getItemCount() {
            return tytuly.length;
        }
    }
}
