package com.music.service.service;
import com.music.service.model.Song;
import com.music.service.strategy.PlaylistProcessor;
import com.music.service.utils.ExampleFileUtils;
import com.music.service.utils.PropertyFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public class MusicService {

    private final PlaylistProcessor processor;

    public MusicService(PlaylistProcessor processor) {
        this.processor = processor;
    }

    public List<Song> processSong() {
        //lee el playlist
        JSONArray items = readJSON();

        JSONObject playListData = new JSONObject();
        playListData.put("items", items);

        return processor.processSong(playListData);
    }

    public JSONArray readJSON() {
        final String playlistFileName = PropertyFactory.getProperties().getProperty("refactorpractice.playlist.filename");
        final File inputSource = ExampleFileUtils.getFileFromResources(playlistFileName);
        final JSONObject playlist = ExampleFileUtils.getJsonFromFile(inputSource);

        return (JSONArray) playlist.get("items");
    }
}
