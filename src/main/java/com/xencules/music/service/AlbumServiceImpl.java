package com.xencules.music.service;

import com.xencules.music.dao.AlbumRepository;
import com.xencules.music.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository theAlbumRepository) {
        albumRepository = theAlbumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(int theId) {
        Optional<Album> result = albumRepository.findById(theId);

        Album theAlbum = null;

        if (result.isPresent()) {
            theAlbum = result.get();
        }
        else {
            // we didn't find the ALBUM
            throw new RuntimeException("Did not find album id - " + theId);
        }

        return theAlbum;
    }

    @Override
    public Album save(Album theAlbum) {
        return albumRepository.save(theAlbum);
    }

    @Override
    public void deleteById(int theId) {
        albumRepository.deleteById(theId);
    }
}
