package controller;

import java.util.ArrayList; 

import model.Album;
import model.Song;

public class AlbumBuilder {

	ArrayList<Song> SongInAlbum = new ArrayList<Song>();
	String albumName;
	String username;
	String path;
	
	
	public AlbumBuilder setSongs(ArrayList<Song> SongInAlbum) {
		this.SongInAlbum = SongInAlbum;
		return this;
	}
	public AlbumBuilder setAlbumName(String albumName) {
		this.albumName = albumName;
		return this;
	}
	
	public AlbumBuilder setUsername(String username){
		this.username = username;
		return this;
	}
	
	public AlbumBuilder setPath(String path)
	{
		this.path = path;
		return this;
	}
	
	public Album getAlbum()
	{
		return new Album(albumName, username, path);
	}
	
}
