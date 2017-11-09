package ru.vyaacheslav.suhov.imeit.NewsPa;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.vyaacheslav.suhov.imeit.R;


public class ArtilhariaAdapter extends RecyclerView.Adapter<ArtilhariaAdapter.ViewHolder> {

    private Context context;
    private List<Artilharia> artilhariaList;

    public ArtilhariaAdapter(Context context, List<Artilharia> artilhariaList){
        this.context = context;
        this.artilhariaList = artilhariaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_pa_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(artilhariaList.get(position));
    }

    @Override
    public int getItemCount() {
        return artilhariaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView ivClube;
        TextView tvNomeJogador;
        TextView tvPosicaoJogador;
        TextView tvGols;

        public ViewHolder(View itemView) {
            super(itemView);

            ivClube          = itemView.findViewById(R.id.iv_clube);
            tvNomeJogador    = itemView.findViewById(R.id.tv_nome_jogador);
            tvPosicaoJogador = itemView.findViewById(R.id.tv_posicao);
            tvGols           = itemView.findViewById(R.id.tv_gols);
        }

        public void setData(Artilharia artilharia){

            Picasso.with(context)
                    .load(artilharia.getImagemArtUrl());


            Picasso.with(context)
                    .load(artilharia.getImagemClubeUrl())
                    .into(ivClube);

            tvNomeJogador.setText(artilharia.getNomeJogador());
            tvPosicaoJogador.setText(artilharia.getPisicaoJogador());
            tvGols.setText(artilharia.getGolsJogador());
        }
    }

}