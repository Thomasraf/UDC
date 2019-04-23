package model;

import java.util.ArrayList;

public class AlbumList {
	
private static ArrayList<Album> albumList = new ArrayList<Album>();
	
	public void addEvent(Album album)
	{
		albumList.add(album);
	}

	public static ArrayList<Album> getAlbumList() {
		return albumList;
	}

	public static void setAlbumList(ArrayList<Album> albumList) {
		AlbumList.albumList = albumList;
	}
	
	public int getPlaylistSize() {
		return albumList.size();
	}

	public int getIndex(Album a) {
		return albumList.indexOf(a);
	}
	

	public void printSongs() {
		for (int i = 0; i<albumList.size(); i++)
		{
				System.out.print(albumList.get(i).albumName);
				System.out.println("");
		}
	}

}