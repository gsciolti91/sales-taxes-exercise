package com.gsciolti.salestaxes.model.item;

import javax.xml.datatype.Duration;

public class Track {

    private String name;

    private String author;

    private Duration duration;


    public Track(String name, String author, Duration duration) {
        setName(name);
        setAuthor(author);
        setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
