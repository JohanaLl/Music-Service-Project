package com.music.service.service;

import com.music.service.factory.SpotifyServiceFactory;
import com.music.service.model.Album;
import com.music.service.strategy.PlaylistProcessor;
import com.music.service.utils.ExampleFileUtils;
import com.music.service.utils.PropertyFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class MusicService {

    private final PlaylistProcessor processor;

    public MusicService(PlaylistProcessor processor) {
        this.processor = processor;
    }

    public List<Album> processAlbums() {
        final LinkedList<Album> spotifyAlbumList = new LinkedList<>();

        JSONArray items = readJSON();

        for (Object item : items) {
            JSONObject songJSON = (JSONObject) item;
            JSONObject trackJSON = (JSONObject) songJSON.get("track");
            JSONObject albumJSON = (JSONObject) trackJSON.get("album");

            SpotifyServiceFactory album = new SpotifyServiceFactory();
            Album album1 = album.createAlbum(albumJSON);
            spotifyAlbumList.add(album1);
        }

        return spotifyAlbumList;
    }

    public JSONArray readJSON() {
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        final File inputSource = ExampleFileUtils.getFileFromResources(playlistFileName);
        final JSONObject playlist = ExampleFileUtils.getJsonFromFile(inputSource);

        return (JSONArray) playlist.get("items");
    }
}
