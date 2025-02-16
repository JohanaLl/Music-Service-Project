package com.music.service.factory;

import com.music.service.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class SpotifyServiceFactory implements MusicServiceFactory {

    @Override
    public Album createAlbum(JsonNode data) {
        return new Album(
                data.get("id").asText(),
                data.get("name").asText(),
                data.get("release_date").asText(),
                data.get("total_tracks").asInt(),
                data.get("album_type").asText()
        );
    }

    @Override
    public List<Artist> createArtist(JsonNode data) {
        List<Artist> artists = new ArrayList<>();
        var artist = new Artist(
                data.get("id").asText(),
                data.get("name").asText());
        artists.add(artist);
        return artists;
    }

    @Override
    public Song createSong(JsonNode data, Album album, List<Artist> artists) {
        return new Song(
                data.get("id").asText(),
                data.get("name").asText(),
                data.get("explicit").asText(),
                data.get("is_playable").asText(),
                data.get("popularity").asInt(),
                album,
                artists
        );
    }
}
