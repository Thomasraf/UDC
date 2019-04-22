package model;

import java.util.ArrayList;

public class Album {
	private static ArrayList<Song> SongInAlbum = new ArrayList<Song>();
	String albumName;
	String username;
	
	public Album(String albumName, String username) {
		super();
		this.albumName = albumName;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}


	public static ArrayList<Song> getSongInAlbum() {
		return SongInAlbum;
	}


	public String getAlbumName() {
		return albumName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public void addSongToAlbum(Song song)
	{
		SongInAlbum.add(song);
	}

	public static void setSongList(ArrayList<Song> songList) {
		Album.SongInAlbum = songList;
	}
	
	public int getSongSize() {
		return SongInAlbum.size();
	}

	public int getIndex(Song s) {
		return SongInAlbum.indexOf(s);
	}
	
	public void printSongs() {
		for (int i = 0; i<SongInAlbum.size(); i++)
		{
				System.out.print(SongInAlbum.get(i).SongName);
				System.out.println("");
		}
	}

}
