package model;

public class ArtistPlaylist {
	private String name;
	private String username;
	private String description;
	private String path;
	
	public ArtistPlaylist(String name, String username, String description, String path)
	{
		this.name = name;
		this.username = username;
		this.description = description;
		this.path = path;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String desc)
	{
		this.description = desc;
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
