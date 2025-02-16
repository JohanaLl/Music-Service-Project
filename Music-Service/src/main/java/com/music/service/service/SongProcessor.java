package com.music.service.service;

import com.music.service.factory.SpotifyServiceFactory;
import com.music.service.model.Artist;
import com.music.service.model.Song;
import com.music.service.strategy.SpotifyPlaylistProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SongProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);

    public void processSongs() {

        // Configuramos el servicio para Spotify
        var factory = new SpotifyServiceFactory();
        var processor = new SpotifyPlaylistProcessor(factory);
        var service = new MusicService(processor);

        try {
            service.processSong().forEach(song -> {
                var artists = song.artists().stream()
                        .map(Artist::name)
                        .collect(Collectors.joining());

                String logMessage = String.format("""
                    Song Details:
                    ID: %s
                    Name: %s
                    Artist(s): %s
                    Album: %s
                    """,
                    song.id(),
                    song.name(),
                    artists,
                    song.album().name());

                LOGGER.info(logMessage);
            });
        } catch (Exception e) {
            LOGGER.error("Error processing songs", e);
        }
    }
}
