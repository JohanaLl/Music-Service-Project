package com.music.service.factory;

import com.music.service.model.Album;
import com.music.service.model.Artist;
import com.music.service.model.Song;
import org.json.simple.JSONObject;

import java.util.List;

public interface MusicServiceFactory {

    Album createAlbum(JSONObject data);

    List<Artist> createArtist(JSONObject data);

    Song createSong(JSONObject data);
}
