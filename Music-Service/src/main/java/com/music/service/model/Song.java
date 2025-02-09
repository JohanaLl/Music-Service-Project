package com.music.service.model;

import java.util.List;

public interface Song {

    public String getId();
    public String getName();
    public String getExplicit();
    public String getPlayable();
    public String getPopularity();
    public List<Artist> getArtists();
    public Album getAlbum();
    public void setArtists(List<Artist> artists);
    public void setAlbum(Album album);
}
