package controller;

import model.ArtistSong;

public class ArtistSongBuilder {
	int songid;
	String name;
	int artistid;
	int genreid;
	int albumid;
	String path;
	
	public void setID(int id)
	{
		this.songid = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setArtistID(int id)
	{
		this.artistid = id;
	}
	
	public void setGenreID(int id)
	{
		this.genreid = id;
	}
	
	public void setAlbumID(int id)
	{
		this.albumid = id;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public ArtistSong getSong()
	{
		return new ArtistSong(songid, name, artistid, genreid, albumid, path);
	}
}
