package com.xencules.music.dao;

import com.xencules.music.entity.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumDAOJpaImpl implements AlbumDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public AlbumDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Album> findAll() {

        // create a query
        TypedQuery<Album> theQuery = entityManager.createQuery("from Album", Album.class);

        // execute query and get result list
        List<Album> albums = theQuery.getResultList();

        // return the results
        return albums;
    }

    @Override
    public Album findById(int theId) {

        // get Album
        Album theAlbum = entityManager.find(Album.class, theId);

        // return Album
        return theAlbum;
    }

    @Override
    public Album save(Album theAlbum) {

        // save Album
        Album dbAlbum = entityManager.merge(theAlbum);

        // return the dbAlbum
        return dbAlbum;
    }

    @Override
    public void deleteById(int theId) {

        // find Album by id
        Album theAlbum = entityManager.find(Album.class, theId);

        // remove Album
        entityManager.remove(theAlbum);
    }
}
