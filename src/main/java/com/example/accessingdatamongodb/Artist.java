package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Artist {

    @Id
    public String id;

    public String name;

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Artist[id=%s, name='%s']",
                id, name);
    }

}
