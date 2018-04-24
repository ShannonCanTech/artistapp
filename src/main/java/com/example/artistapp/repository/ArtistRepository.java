package com.example.artistapp.repository;

import com.example.artistapp.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

}