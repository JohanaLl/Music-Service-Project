package com.music.service.factory;

import com.music.service.model.Album;
import com.music.service.model.SpotifyAlbum;
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
}
