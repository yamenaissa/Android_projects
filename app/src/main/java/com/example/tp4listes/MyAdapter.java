package com.example.tp4listes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Resultat> resultatList;

    public MyAdapter(List<Resultat> resultatList) {
        this.resultatList = resultatList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom, prenom;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom);
            prenom = itemView.findViewById(R.id.prenom);
            image = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(v -> {
                Context context = itemView.getContext();
                float moyenne = Float.parseFloat(nom.getTag().toString());
                String msg = moyenne >= 10 ? "Réussi avec " + moyenne : "Échec avec " + moyenne;
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Resultat r = resultatList.get(position);
        holder.nom.setText(r.getNom());
        holder.nom.setTag(r.getMoyenne());
        holder.prenom.setText(r.getPrenom());
        holder.image.setImageResource(r.getImage());
    }

    @Override
    public int getItemCount() {
        return resultatList.size();
    }
}