package com.example.databasetp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    List <Offre> offres;
    Context context;
    DAO dao;

    public CustomAdapter(List<Offre> offres, Context context){
        this.offres=offres;
        this.context=context;
        dao=new DAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@Nullable ViewHolder holder , int position){

        Offre offre =offres.get(position);
        holder.idText.setText(String.valueOf(offre.id));
        holder.descText.setText(String.valueOf(offre.description));
        holder.posteText.setText(String.valueOf(offre.poste));

        holder.editbtn.setOnClickListener(v->{
            Intent intent=new Intent(context, UpdateActivity.class);
            intent.putExtra("id",offre.id);
            context.startActivity(intent);


        });
        holder.suppbtn.setOnClickListener(v->{
            dao.deleteOffre(offre.id);
            offres.remove(position);              // remove from list
            notifyItemRemoved(position);          // notify adapter
            notifyItemRangeChanged(position, offres.size()); // keep positions consistent
        });
        holder.itemView.setOnClickListener(v->{
            Intent intent=new Intent(context, UpdateActivity.class);
            intent.putExtra("id",offre.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount(){return offres.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView idText, descText, posteText;
        Button suppbtn,editbtn;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            idText=itemView.findViewById(R.id.tvId);
            descText=itemView.findViewById(R.id.tvDescription);

            posteText=itemView.findViewById(R.id.tvPoste);
            suppbtn=itemView.findViewById(R.id.btSupp);
            editbtn=itemView.findViewById(R.id.btEdit);
        }
    }
}
