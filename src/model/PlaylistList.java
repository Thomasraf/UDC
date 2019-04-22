package model;

import java.util.ArrayList;

public class PlaylistList {


	private static ArrayList<Playlist> playlistList = new ArrayList<Playlist>();
	
	public void addEvent(Playlist playlist)
	{
		playlistList.add(playlist);
	}

	public static ArrayList<Playlist> getPlaylistList() {
		return playlistList;
	}

	public static void setPlaylistList(ArrayList<Playlist> playlistList) {
		PlaylistList.playlistList = playlistList;
	}
	
	public int getPlaylistSize() {
		return playlistList.size();
	}

	public int getIndex(Playlist p) {
		return playlistList.indexOf(p);
	}

	public void printSongs() {
		for (int i = 0; i<playlistList.size(); i++)
		{
				System.out.print(playlistList.get(i).playlistName);
				System.out.println("");
		}
	}
}
