package com.music.service.strategy;

import com.music.service.model.Album;
import com.music.service.model.Artist;
import org.json.simple.JSONObject;

import java.util.List;

public interface PlaylistProcessor {

    List<Album> processAlbums(JSONObject data);
    List<Artist> processArtist(JSONObject data);

}
