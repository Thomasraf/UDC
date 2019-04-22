package model;

import java.awt.*;
public class Song {
	
	int SongID;
	String UserName;
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	String Path;
	int count;
	String favorite;
	
	public Song(int songID, String username, String songName, String artistName, String album, String genre, String year, String path, int count, String favorite) {
		super();
		SongID = songID;
		UserName = username;
		SongName = songName;
		ArtistName = artistName;
		Album = album;
		Genre = genre;
		Year = year;
		Path = path;
		this.count = count;
		this.favorite = favorite;
	}
	
	public int getSongID()
	{
		return SongID;
	}
	
	public String getUserName()
	{
		return UserName;
	}

	public String getSongName()
	{
		return SongName;
	}
	
	public String getArtistName()
	{
		return ArtistName;
	}
	
	public String getAlbum()
	{
		return Album;
	}
	
	public String getGenre()
	{
		return Genre;
	}
	
	public String getYear()
	{
		return Year;
	}
	
	public String getPath()
	{
		return Path;
	}
	
	public int getCount() 
	{
		return count;
	}
	
	public String getFavorite() 
	{
		return favorite;
	}
	
	@Override
	public String toString() {
		return "Song [SongName=" + SongName + ", ArtistName=" + ArtistName + ", Album=" + Album + ", Genre=" + Genre
				+ ", Year=" + Year + ",Count=" + count + ",Favorite=" + favorite +"]";
	}
	
	
}
