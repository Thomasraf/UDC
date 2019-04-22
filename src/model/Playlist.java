package model;


import java.util.ArrayList;

import view.AddSong;

public class Playlist {
	private static ArrayList<Song> SongInPlaylist = new ArrayList<Song>();
	String playlistName;
	String username;
	String favorite;
	String privacy;
	String path;
	String description;

	public Playlist(String playlistName, String username, String favorite,String privacy, String path,String description) {
		super();
		this.playlistName = playlistName;
		this.username = username;
		this.favorite = favorite;
		this.privacy = privacy;
		this.path = path;
		this.description = description;
	}


	public String getUsername() {
		return username;
	}


	public static ArrayList<Song> getSongInPlaylist() {
		return SongInPlaylist;
	}


	public String getPlaylistName() {
		return playlistName;
	}

	public String getFavorite() {
		return favorite;
	}
	
	public String getPrivacy() {
		return privacy;
	}
	public String getPath() {
		return path;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public void addSongToPlaylist(Song song)
	{
		SongInPlaylist.add(song);
	}

	public static void setSongList(ArrayList<Song> songList) {
		Playlist.SongInPlaylist = songList;
	}
	
	public int getSongSize() {
		return SongInPlaylist.size();
	}

	public int getIndex(Song s) {
		return SongInPlaylist.indexOf(s);
	}

	public void printSongs() {
		for (int i = 0; i<SongInPlaylist.size(); i++)
		{
				System.out.print(SongInPlaylist.get(i).SongName);
				System.out.println("");
		}

	}
	
	
}
