package model;

import java.util.ArrayList;

public class RecentlyPlayedList {
private static ArrayList<RecentlyPlayed> songList = new ArrayList<RecentlyPlayed>();
	
	public void addSong(RecentlyPlayed song)
	{
		songList.add(song);
	}

	public static ArrayList<RecentlyPlayed> getSongList() {
		return songList;
	}

	public static void setSongList(ArrayList<RecentlyPlayed> songList) {
		RecentlyPlayedList.songList = songList;
	}
	
	public int getSongSize() {
		return songList.size();
	}
	
	public int getSongListSize() {
		return songList.size();
	}

	public int getIndex(Song s) {
		return songList.indexOf(s);
	}

	public void printSongs() {
		for (int i = 0; i<songList.size(); i++)
		{
				System.out.print(songList.get(i).SongName);
				System.out.println("");
		}
	}
}
