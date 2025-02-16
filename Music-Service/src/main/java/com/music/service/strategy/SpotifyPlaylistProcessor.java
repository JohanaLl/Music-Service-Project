package com.music.service.strategy;

import com.music.service.factory.MusicServiceFactory;
import com.music.service.model.Song;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class SpotifyPlaylistProcessor implements PlaylistProcessor {

    //Factory que crea los objetos
    private final MusicServiceFactory factory;

    public SpotifyPlaylistProcessor(MusicServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Song> processSong(JsonNode data) {
        return Optional.ofNullable(data.get("items"))
                .map(items -> StreamSupport.stream(items.spliterator(), false)
                        .map(this::processTrack)
                        .toList())
                .orElse(List.of());
    }

    private Song processTrack(JsonNode songJson) {
        var trackJson = songJson.get("track");
        var albumJson = trackJson.get("album");
        var artistsJson = trackJson.get("artists");

        //Create Album
        var album = factory.createAlbum(albumJson);

        //Create Artists list
        var artists = StreamSupport.stream(artistsJson.spliterator(), false)
                .flatMap(artist -> factory.createArtist(artist).stream())
                .toList();

        return  factory.createSong(trackJson, album, artists);
    }
}
