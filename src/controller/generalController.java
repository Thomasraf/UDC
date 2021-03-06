package controller;
import model.generalModel;

import java.util.ArrayList;

import model.Album;
import model.ArtistPlaylist;
import model.Playlist;
import model.Song;
import model.account;

public class generalController {
	private volatile static generalController instance = null;
	
	public static generalController getInstance() {
        if(instance == null) {
        	instance = new generalController();
        }
		return instance;
	}
	
	public void gettingAccountData(String username, String password,String type) { //SINGING UP
		account newAccount = new account(username, password);
		generalModel.getInstance().getAccountData(newAccount,type);
	}
	
	public void gettingRegisteredAccountData(String registeredUsername,String registeredPassword) { //LOGGING IN
		account registeredAccount = new account(registeredUsername, registeredPassword);
		generalModel.getInstance().checkingAccountData(registeredAccount);
	//	generalModel.getInstance().checkingArtistAccountData(registeredAccount);

	}
	
	public void gettingRegisteredArtistAccountData(String registeredUsername,String registeredPassword) { //LOGGING IN
		account registeredAccount = new account(registeredUsername, registeredPassword);
		generalModel.getInstance().checkingArtistAccountData(registeredAccount);
	}
	public void gettingUserPlaylist(String username, String playlistName, String favorite,String privacy,String description)
	{
		Playlist p = new Playlist(playlistName, username, favorite,privacy,description);
		generalModel.getInstance().getUserPlaylistData(p);
	}
	
	public void addArtistPlaylist(ArtistPlaylist ap)
	{
		generalModel.getInstance().addArtistPlaylist(ap);
	}

	public void addAlbum(Album a)
	{
		generalModel.getInstance().addAlbum(a);
	}
	
	public void addSong(Song s)
	{
		generalModel.getInstance().addSong(s);
	}
	
	public ArrayList<String> getAlbumsOfUser(String username)
	{
		return generalModel.getInstance().getAlbumsOfUser(username);
	}
/*	
	public int getIDWithUsername(String username)

	
/*	public int getIDWithUsername(String username)

	{
		int result = generalModel.getInstance().getIDForArtist(username);
		System.out.println(result);
		return result;
	} */

}
