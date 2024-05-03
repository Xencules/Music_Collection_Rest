package com.xencules.music.entity;

import jakarta.persistence.*;

@Entity
@Table(name="album")
public class Album {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="artist_name")
    private String artistName;

    @Column(name="album_name")
    private String albumName;

    @Column(name="song")
    private String song;

    // define constructors
    public Album() {

    }

    public Album(String artistName, String albumName, String song) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.song = song;
    }

    // define getter/seteter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }


    // define toString
    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
