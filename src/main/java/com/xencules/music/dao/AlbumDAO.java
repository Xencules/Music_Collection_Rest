package com.xencules.music.dao;

import com.xencules.music.entity.Album;

import java.util.List;

public interface AlbumDAO {
    List<Album> findAll();

    Album findById(int theId);

    Album save(Album theAlbum);

    void deleteById(int theId);
}
