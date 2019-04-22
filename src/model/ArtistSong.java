package model;

public class ArtistSong {
	private int songid;
	private String name;
	private int artistid;
	private int genreid;
	private int albumid;
	private String path;
	
	public ArtistSong(int songid, String name, int artistid, int genreid, int albumid, String path)
	{
		this.songid = songid;
		this.name = name;
		this.artistid = artistid;
		this.albumid = albumid;
		this.genreid = genreid;
		this.path = path;
	}
	
	public int getID()
	{
		return songid;
	}
	
	public void setID(int id)
	{
		this.songid = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getArtistID()
	{
		return artistid;
	}
	
	public void setArtistID(int id)
	{
		this.artistid = id;
	}
	
	public int getAlbumID()
	{
		return albumid;
	}
	
	public void setAlbumID(int id)
	{
		albumid = id;
	}
	
	public int getGenreID()
	{
		return genreid;
	}
	
	public void setGenreID(int id)
	{
		genreid = id;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
}
