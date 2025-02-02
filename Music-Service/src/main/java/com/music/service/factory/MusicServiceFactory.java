package com.music.service.factory;

import com.music.service.model.Album;
import org.json.simple.JSONObject;

public interface MusicServiceFactory {

    Album createAlbum(JSONObject data);

}
