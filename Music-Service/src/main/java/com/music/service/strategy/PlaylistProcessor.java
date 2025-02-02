package com.music.service.strategy;

import com.music.service.model.Album;
import org.json.simple.JSONObject;

import java.util.List;

public interface PlaylistProcessor {
    List<Album> processAlbums(JSONObject data);
}
