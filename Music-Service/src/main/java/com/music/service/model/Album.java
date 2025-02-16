package com.music.service.model;

public record Album (
        String id,
        String name,
        String releaseDate,
        int totalTrack,
        String type
){ }
