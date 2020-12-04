package ru.itis.repositories;

import ru.itis.models.Video;

import java.util.ArrayList;
import java.util.Optional;

public class VideosRepositoryImpl implements VideosRepository {
    @Override
    public void save(Video entity) {

    }

    @Override
    public void update(Video entity) {

    }

    @Override
    public void delete(Video entity) {

    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Video> findAll() {
        return null;
    }
}
