package com.music.service.strategy;

import com.music.service.factory.MusicServiceFactory;
import com.music.service.model.Album;
import com.music.service.model.Artist;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpotifyPlaylistProcessor implements PlaylistProcessor {

    private final MusicServiceFactory factory;

    public SpotifyPlaylistProcessor(MusicServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Album> processAlbums(JSONObject data) {
        List<Album> albums = new ArrayList<>();
        JSONArray items = (JSONArray) data.get("album");

        for (Object item : items) {
            JSONObject albumData = (JSONObject) item;
            Album album = factory.createAlbum(albumData);
            albums.add(album);
        }

        return albums;
    }

    @Override
    public List<Artist> processArtist(JSONObject data) {
        List<Artist> artists = new ArrayList<>();
        JSONArray items = (JSONArray) data.get("artists");

        for (Object item: items) {
            JSONObject artistData = (JSONObject) item;
            Artist artist = factory.createArtist(artistData);
            artists.add(artist);
        }
        return Collections.emptyList();
    }
}
