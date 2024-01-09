package com.example.accessingdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ArtistRepository extends MongoRepository<Artist, String> {

    Artist findByName(String Name);

    List<Artist> findAllByName(String Name);

}
