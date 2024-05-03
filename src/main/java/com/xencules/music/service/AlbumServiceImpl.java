package com.xencules.music.service;

import com.xencules.music.dao.AlbumDAO;
import com.xencules.music.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumDAO albumDAO;

    @Autowired
    public AlbumServiceImpl(AlbumDAO theAlbumDAO) {
        albumDAO = theAlbumDAO;
    }

    @Override
    public List<Album> findAll() {
        return albumDAO.findAll();
    }

    @Override
    public Album findById(int theId) {
        return albumDAO.findById(theId);
    }

    @Transactional
    @Override
    public Album save(Album theAlbum) {
        return albumDAO.save(theAlbum);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        albumDAO.deleteById(theId);
    }
}





