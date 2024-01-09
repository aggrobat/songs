package com.example.accessingdatamongodb;
// Repository for Song class
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {

    Song findByTitle(String title);

    List<Song> findAllByTitle(String title);

    List<Song> findByArtist(Artist artist);

    List<Song> findAllByArtist(Artist artist);

}