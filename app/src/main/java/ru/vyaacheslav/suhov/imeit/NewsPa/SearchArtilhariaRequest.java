package ru.vyaacheslav.suhov.imeit.NewsPa;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 28/02/2017.
 */

public class SearchArtilhariaRequest extends AsyncTask<Void, Void, List<Artilharia>> {

    private WeakReference<FragmentN> activity;

    public SearchArtilhariaRequest(FragmentN activity){
        this.activity = new WeakReference<>(activity);
    }

    @Override
    protected List<Artilharia> doInBackground(Void... voids) {
        List<Artilharia> artilharias = new ArrayList<>();

        try {
            Document html = Jsoup.connect("http://globoesporte.globo.com/sp/futebol/campeonato-paulista/").get();

            Elements golsArt       = html.select("span.artilheiro-gols");
            Elements imgArtilharia = html.select("img.artilheiro-foto");
            Elements imgClube      = html.select("img.artilheiro-escudo");
            Elements nomeArt       = html.select("p.artilheiro-nome");

            for (int i = 0; i < golsArt.size(); i++) {
                Artilharia artilharia = new Artilharia();
                artilharia.setImagemArtUrl(imgArtilharia.get(i).attr("src"));
                artilharia.setImagemClubeUrl(imgClube.get(i).attr("src"));
                artilharia.setNomeJogador(nomeArt.get(i).text());
                artilharia.setGolsJogador(golsArt.get(i).text());
                artilharias.add(artilharia);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return artilharias;
    }

    @Override
    protected void onPostExecute(List<Artilharia> artilhariaList) {
        super.onPostExecute(artilhariaList);

        if (activity.get() != null) {
            activity.get().updateLista(artilhariaList);
        }
    }
}