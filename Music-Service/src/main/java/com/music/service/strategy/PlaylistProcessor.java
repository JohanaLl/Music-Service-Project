package com.music.service.strategy;

import com.fasterxml.jackson.databind.JsonNode;
import com.music.service.model.Song;

import java.util.List;

public interface PlaylistProcessor {

    List<Song> processSong(JsonNode data);

}
