package com.music.service.factory;

import com.music.service.model.Album;
import com.music.service.model.Artist;
import com.music.service.model.SpotifyAlbum;
import com.music.service.model.SpotifyArtis;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    public Artist createArtist(JSONObject data) {
        return new SpotifyArtis(
                data.get("id").toString(),
                data.get("name").toString()
        );
    }
}
