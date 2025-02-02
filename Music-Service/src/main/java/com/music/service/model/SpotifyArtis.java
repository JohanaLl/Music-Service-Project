package com.music.service.model;

import java.util.LinkedList;

public class SpotifyArtis implements Artist{

    private final String id;
    private final String name;

    public SpotifyArtis(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

}
