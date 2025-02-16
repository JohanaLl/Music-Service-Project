package com.music.service.factory;

import com.music.service.model.Album;
import com.music.service.model.Artist;
import com.music.service.model.Song;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface MusicServiceFactory {

    Album createAlbum(JsonNode data);

    List<Artist> createArtist(JsonNode data);

    Song createSong(JsonNode data, Album album, List<Artist> artists);
}
