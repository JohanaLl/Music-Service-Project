package com.music.service.model;

import java.util.List;

public class SpotifySong implements Song {

    private final String id;
    private final String name;
    private final String explicit;
    private final String playable;
    private final String popularity;
    private List<Artist> artists;
    private Album album;

    public SpotifySong(String id, String name, String explicit, String playable, String popularity) {
        this.id = id;
        this.name = name;
        this.explicit = explicit;
        this.playable = playable;
        this.popularity = popularity;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getExplicit() {
        return explicit;
    }

    @Override
    public String getPlayable() {
        return playable;
    }

    @Override
    public String getPopularity() {
        return popularity;
    }

    @Override
    public List<Artist> getArtists() {
        return artists;
    }

    @Override
    public Album getAlbum() {
        return album;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
