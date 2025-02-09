package com.music.service.factory;

import com.music.service.model.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SpotifyServiceFactory implements MusicServiceFactory {

    @Override
    public Album createAlbum(JSONObject data) {
        return new SpotifyAlbum(
                data.get("id").toString(),
                data.get("name").toString(),
                data.get("release_date").toString(),
                Integer.parseInt(data.get("total_tracks").toString()),
                data.get("album_type").toString()
        );
    }

    @Override
    public List<Artist> createArtist(JSONObject data) {
        List<Artist> artists = new ArrayList<>();
        SpotifyArtis artist = new SpotifyArtis(
                data.get("id").toString(),
                data.get("name").toString());
        artists.add(artist);
        return artists;
    }

    @Override
    public Song createSong(JSONObject data) {
        return new SpotifySong(
                data.get("id").toString(),
                data.get("name").toString(),
                data.get("explicit").toString(),
                data.get("is_playable").toString(),
                data.get("popularity").toString()
        );
    }
}
