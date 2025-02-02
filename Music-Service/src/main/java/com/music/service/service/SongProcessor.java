package com.music.service.service;

import com.music.service.factory.MusicServiceFactory;
import com.music.service.factory.SpotifyServiceFactory;
import com.music.service.model.Album;
import com.music.service.strategy.PlaylistProcessor;
import com.music.service.strategy.SpotifyPlaylistProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SongProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);

    public void processSongs() {

        // Configuramos el servicio para Spotify
        MusicServiceFactory factory = new SpotifyServiceFactory();
        PlaylistProcessor processor = new SpotifyPlaylistProcessor(factory);
        MusicService service = new MusicService(processor);

        List<Album> albums = service.processAlbums();

        for (Album album: albums) {
            LOGGER.info(" - {} - {} - {} - {} - {}", album.getId(), album.getName(),
                    album.getReleaseDate(), album.getTotalTrack(), album.getType());
        }
    }
}
