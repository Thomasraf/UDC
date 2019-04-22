package controller;

import model.Song;

public class SongBuilder 
{
	int SongID;
	String UserName;
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	String Path;
	int Count;
	String Favorite;
	
	public SongBuilder setSongID(int songID) {
		SongID = songID;
		return this;
	}
	
	public SongBuilder setUserName(String username) {
		UserName = username;
		return this;
	}
	
	public SongBuilder setSongName(String songName) {
		SongName = songName;
		return this;
	}
	public SongBuilder setArtistName(String artistName) {
		ArtistName = artistName;
		return this;
	}
	public SongBuilder setAlbum(String album) {
		Album = album;
		return this;
	}
	public SongBuilder setGenre(String genre) {
		Genre = genre;
		return this;
	}
	public SongBuilder setYear(String year) {
		Year = year;
		return this; 	
	}
	public SongBuilder setPath(String path) {
		Path = path;
		return this;
	}

	public SongBuilder setCount(int Count) {
		this.Count = Count;
		return this;
	}
	public SongBuilder setFavorite(String Favorite) {
		this.Favorite = Favorite;
		return this;
	}
	
	public Song getSong()
	{
		return new Song(SongID, UserName, SongName, ArtistName, Album, Genre, Year, Path, Count,Favorite);
	}
	
	
	
}
