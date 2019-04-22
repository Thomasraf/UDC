package controller;

import model.ArtistPlaylist;

public class ArtistPlaylistBuilder {
	String name;
	String username;
	String description;
	String path;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setUsername(String name)
	{
		this.username = name;
	}
	
	public void setDescription(String desc)
	{
		this.description = desc;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public ArtistPlaylist getPlaylist()
	{
		return new ArtistPlaylist(name, username, description, path);
	}
}
