package com.xencules.music.dao;

import com.xencules.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="albums")
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
