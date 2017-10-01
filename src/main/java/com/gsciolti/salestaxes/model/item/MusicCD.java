package com.gsciolti.salestaxes.model.item;

import com.gsciolti.salestaxes.model.CurrencyValue;

import java.util.List;

public class MusicCD extends TaxedItem {

    private String author;

    private List<Track> tracks;

    public MusicCD(String name, CurrencyValue price, String author, List<Track> tracks) {
        super(name, price);
        setAuthor(author);
        setTracks(tracks);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return String.format("%smusic CD: \"%s\"", isImported()? "imported ": "", getName());
    }
}
