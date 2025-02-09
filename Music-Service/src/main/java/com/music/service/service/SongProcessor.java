package com.music.service.service;

import com.music.service.factory.MusicServiceFactory;
import com.music.service.factory.SpotifyServiceFactory;
import com.music.service.model.Artist;
import com.music.service.model.Song;
import com.music.service.strategy.PlaylistProcessor;
import com.music.service.strategy.SpotifyPlaylistProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SongProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SongProcessor.class);

    public void processSongs() {

        // Configuramos el servicio para Spotify
        MusicServiceFactory factory = new SpotifyServiceFactory();
        PlaylistProcessor processor = new SpotifyPlaylistProcessor(factory);
        MusicService service = new MusicService(processor);

        List<Song> songs = service.processSong();

        for (Song song: songs) {
            //Artistas
            List<String> artistNames = song.getArtists().stream()
                            .map(Artist::getName)
                            .collect(Collectors.toList());
            String artists = String.join(", ", artistNames);

            LOGGER.info(" - Id: {} - Canción: {} - Artista(s): {} - Album: {}",
                    song.getId(),
                    song.getName(),
                    artists,
                    song.getAlbum().getName());
        }
    }
}
