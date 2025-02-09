package com.music.service.strategy;

import com.music.service.factory.MusicServiceFactory;
import com.music.service.model.Album;
import com.music.service.model.Artist;
import com.music.service.model.Song;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SpotifyPlaylistProcessor implements PlaylistProcessor {

    //Factory que crea los objetos
    private final MusicServiceFactory factory;

    public SpotifyPlaylistProcessor(MusicServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Song> processSong(JSONObject data) {
        List<Song> songs = new ArrayList<>();
        JSONArray items = (JSONArray) data.get("items");

        for (Object item: items) {
            JSONObject songJson = (JSONObject) item;
            JSONObject trackJson = (JSONObject) songJson.get("track");
            JSONObject albumJson = (JSONObject) trackJson.get("album");
            JSONArray artistsJson = (JSONArray) trackJson.get("artists");

            //Create Album
            Album album = factory.createAlbum(albumJson);

            //Create Artists list
            List<Artist> artists = new ArrayList<>();
            for (Object artist: artistsJson) {
                JSONObject artistJson = (JSONObject) artist;
                artists.addAll(factory.createArtist(artistJson));
            }

            //Create Song
            Song song = factory.createSong(trackJson);
            song.setAlbum(album);
            song.setArtists(artists);
            songs.add(song);
        }
        return songs;
    }
}
