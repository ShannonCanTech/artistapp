package com.example.artistapp.repository;

import com.example.artistapp.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
