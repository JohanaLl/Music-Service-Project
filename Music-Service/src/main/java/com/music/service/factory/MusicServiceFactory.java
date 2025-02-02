package com.music.service.factory;

import com.music.service.model.Album;
import com.music.service.model.Artist;
import org.json.simple.JSONObject;

public interface MusicServiceFactory {

    Album createAlbum(JSONObject data);

    Artist createArtist(JSONObject data);
}
