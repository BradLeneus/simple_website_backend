package com.example.labo1.Model;

public class Serie {
    private int id;
    private String titre;
    private String genre;
    private int nbEpisodes;
    private float note;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getNbEpisodes() {
        return nbEpisodes;
    }

    public void setNbEpisodes(int nbEpisodes) {
        this.nbEpisodes = nbEpisodes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", genre='" + genre + '\'' +
                ", nbEpisodes='" + nbEpisodes + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
