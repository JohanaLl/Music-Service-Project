package com.music.service.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.music.service.model.Song;
import com.music.service.strategy.PlaylistProcessor;
import com.music.service.utils.ExampleFileUtils;
import com.music.service.utils.PropertyFactory;

import java.io.File;
import java.util.List;

public class MusicService {

    private final PlaylistProcessor processor;

    public MusicService(PlaylistProcessor processor) {
        this.processor = processor;
    }

    public List<Song> processSong() {
        //lee el playlist
        JsonNode items = readJSON();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode playListData = mapper.createObjectNode();
        playListData.set("items", items);

        return processor.processSong(playListData);
    }

    public JsonNode readJSON() {
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        final File inputSource = ExampleFileUtils.getFileFromResources(playlistFileName);
        final JsonNode playlist = ExampleFileUtils.getJsonFromFile(inputSource);

        return playlist.get("items");
    }
}
