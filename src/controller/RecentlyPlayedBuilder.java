package controller;

import model.RecentlyPlayed;

public class RecentlyPlayedBuilder {

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
	
	public RecentlyPlayedBuilder setSongID(int songID) {
		SongID = songID;
		return this;
	}
	
	public RecentlyPlayedBuilder setUserName(String username) {
		UserName = username;
		return this;
	}
	
	public RecentlyPlayedBuilder setSongName(String songName) {
		SongName = songName;
		return this;
	}
	public RecentlyPlayedBuilder setArtistName(String artistName) {
		ArtistName = artistName;
		return this;
	}
	public RecentlyPlayedBuilder setAlbum(String album) {
		Album = album;
		return this;
	}
	public RecentlyPlayedBuilder setGenre(String genre) {
		Genre = genre;
		return this;
	}
	public RecentlyPlayedBuilder setYear(String year) {
		Year = year;
		return this; 	
	}
	public RecentlyPlayedBuilder setPath(String path) {
		Path = path;
		return this;
	}

	public RecentlyPlayedBuilder setCount(int Count) {
		this.Count = Count;
		return this;
	}
	public RecentlyPlayedBuilder setFavorite(String Favorite) {
		this.Favorite = Favorite;
		return this;
	}
	
	public RecentlyPlayed getSong()
	{
		return new RecentlyPlayed(SongID, UserName, SongName, ArtistName, Album, Genre, Year, Path, Count,Favorite);
	}
	
}
