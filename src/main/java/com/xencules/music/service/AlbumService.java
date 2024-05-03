package com.xencules.music.service;

import com.xencules.music.entity.Album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll();

    Album findById(int theId);

    Album save(Album theAlbum);

    void deleteById(int theId);

}
