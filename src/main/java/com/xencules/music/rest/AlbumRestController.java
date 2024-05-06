package com.xencules.music.rest;

import com.xencules.music.entity.Album;
import com.xencules.music.exception.MusicNotFoundException;
import com.xencules.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumRestController {
    private AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService theAlbumService) {
        albumService = theAlbumService;
    }

    // expose "/albums" and return a list of Albums
    @GetMapping("/albums")
    public List<Album> findAll() {
        return albumService.findAll();
    }

    // add mapping for GET /albums/{albumId}

    @GetMapping("/albums/{albumId}")
    public Album getAlbum(@PathVariable int albumId) {

        Album theAlbum = albumService.findById(albumId);

        if (theAlbum == null) {
            throw new MusicNotFoundException("Album id not found - " + albumId);
        }

        return theAlbum;
    }

    // add mapping for POST /albums - add new Album

    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album theAlbum) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theAlbum.setId(0);

        Album dbAlbum = albumService.save(theAlbum);

        return dbAlbum;
    }

    // add mapping for PUT /albums - update existing album

    @PutMapping("/albums")
    public Album updateAlbum(@RequestBody Album theAlbum) {

        Album dbAlbum = albumService.save(theAlbum);

        return dbAlbum;
    }

    // add mapping for DELETE /albums/{albumId} - delete Album

    @DeleteMapping("/albums/{albumId}")
    public String deleteAlbum(@PathVariable int albumId) {

        Album tempAlbum = albumService.findById(albumId);

        // throw exception if null

        if (tempAlbum == null) {
            throw new MusicNotFoundException("Album id not found - " + albumId);
        }

        albumService.deleteById(albumId);

        return "Deleted Album id - " + albumId;
    }
}
