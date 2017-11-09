package ru.vyaacheslav.suhov.imeit.NewsPa;
import android.os.Parcel;
import android.os.Parcelable;



public class Artilharia implements Parcelable{

    public static final String ART_KEY = "art_key";
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
    private String imagemArtUrl;
    private String imagemClubeUrl;
    private String nomeJogador;
    private String posicaoJogador;
    private String golsJogador;

    public Artilharia(){}

    protected Artilharia(Parcel in) {
        this.imagemArtUrl   = in.readString();
        this.nomeJogador    = in.readString();
        this.posicaoJogador = in.readString();
        this.golsJogador    = in.readString();
    }

    public String getImagemArtUrl() {
        return imagemArtUrl;
    }

    public void setImagemArtUrl(String imagemArtUrl) {
        this.imagemArtUrl = imagemArtUrl;
    }

    public String getImagemClubeUrl() {
        return imagemClubeUrl;
    }

    public void setImagemClubeUrl(String imagemClubeUrl) {
        this.imagemClubeUrl = imagemClubeUrl;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public String getPisicaoJogador() {
        return posicaoJogador;
    }

    public void setPisicaoJogador(String pisicaoJogador) {
        this.posicaoJogador = pisicaoJogador;
    }

    public String getGolsJogador() {
        return golsJogador;
    }

    public void setGolsJogador(String golsJogador) {
        this.golsJogador = golsJogador;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagemArtUrl);
        dest.writeString(this.imagemClubeUrl);
        dest.writeString(this.nomeJogador);
        dest.writeString(this.posicaoJogador);
        dest.writeString(this.golsJogador);
    }
}