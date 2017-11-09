package ru.vyaacheslav.suhov.imeit.NewsPa;

import android.os.Parcel;
import android.os.Parcelable;

public class Artilharia implements Parcelable{

    public static final Creator<Artilharia> CREATOR = new Creator<Artilharia>() {
        @Override
        public Artilharia createFromParcel(Parcel in) {
            return new Artilharia(in);
        }

        @Override
        public Artilharia[] newArray(int size) {
            return new Artilharia[size];
        }
    };
    static final String ART_KEY = "art_key";
    private String imagemArtUrl;
    private String nomeJogador;
    private String posicaoJogador;
    private String golsJogador;

     Artilharia(){}

    private Artilharia(Parcel in) {
        this.imagemArtUrl   = in.readString();
        this.nomeJogador    = in.readString();
        this.posicaoJogador = in.readString();
        this.golsJogador    = in.readString();
    }

    String getImagemArtUrl() {
        return imagemArtUrl;
    }

     void setImagemArtUrl(String imagemArtUrl) {
        this.imagemArtUrl = imagemArtUrl;
    }


     String getNomeJogador() {
        return nomeJogador;
    }

     void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

     String getPisicaoJogador() {
        return posicaoJogador;
    }

     String getGolsJogador() {
        return golsJogador;
    }

     void setGolsJogador(String golsJogador) {
        this.golsJogador = golsJogador;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagemArtUrl);
        dest.writeString(this.nomeJogador);
        dest.writeString(this.posicaoJogador);
        dest.writeString(this.golsJogador);
    }
}