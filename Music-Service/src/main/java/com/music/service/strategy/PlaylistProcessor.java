package com.music.service.strategy;

import com.music.service.model.Song;
import org.json.simple.JSONObject;

import java.util.List;

public interface PlaylistProcessor {

    List<Song> processSong(JSONObject data);

}
