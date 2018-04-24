package com.example.artistapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String songTitle;
    @NotEmpty
    private String releaseYear;
    @NotEmpty
    private String leadArtist;

    @NotNull
    private boolean songDone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLeadArtist() {
        return leadArtist;
    }

    public void setLeadArtist(String leadArtist) {
        this.leadArtist = leadArtist;
    }

    public boolean isSongDone() {
        return songDone;
    }

    public void setSongDone(boolean songDone) {
        this.songDone = songDone;
    }
}
