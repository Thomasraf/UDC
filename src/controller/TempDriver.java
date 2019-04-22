package controller;
import model.Song;

public class TempDriver {
	public static void main (String[] args)
	{
		Song song = new SongBuilder()
				.setSongName("Song")
				.setArtistName("Artist")
				.setAlbum("Album")
				.setGenre("Genre")
				.setYear("year")
				.getSong();
		
		System.out.print(song);
		
		
	}
}
