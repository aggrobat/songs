package com.example.accessingdatamongodb;
// New class Song with id, title, artist; artist is a reference to an Artist object.

import org.springframework.data.annotation.Id;

public class Song {

    @Id
    public String id;

    public String title;

    public Artist artist;

    public Song() {}

    public Song(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format(
                "Song[id=%s, title='%s', artist='%s']",
                id, title, artist);
    }

}