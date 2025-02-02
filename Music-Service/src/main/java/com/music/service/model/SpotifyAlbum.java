package com.music.service.model;

public class SpotifyAlbum implements Album {

    private final String id;
    private final String name;
    private final String releaseDate;
    private final int totalTrack;
    private final String type;

    public SpotifyAlbum(String id, String name, String releaseDate, int totalTrack, String type) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.totalTrack = totalTrack;
        this.type = type;
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
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public int getTotalTrack() {
        return totalTrack;
    }

    @Override
    public String getType() {
        return type;
    }
}
