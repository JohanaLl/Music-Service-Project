package com.music.service.model;

import java.util.List;

public record Song (
        String id,
        String name,
        String explicit,
        String playable,
        int popularity,
        Album album,
        List<Artist> artists
){ }
