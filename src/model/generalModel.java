package model;

import java.util.ArrayList;


import controller.SongBuilder;
import view.ArtistLoggingInView;
import view.LoggingInView;
import view.SigningUpView;
//import view.ArtistLoggingInView;

public class generalModel {

	private volatile static generalModel modelInstance = null;
	
	public static generalModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new generalModel();
        }
		return modelInstance;
	
	}
	

	public void getSongData(Song s,String songName)

	{
		int SongID = Database.getInstance().addingSong(s);
		Database.getInstance().writeSongBLOB(SongID, s.getPath(),songName);
	}
	

	
	public void getPlaylistData(Playlist p)
	{
		Database.getInstance().addingPlaylist(p);
		Database.getInstance().writePlaylistData(p.getPlaylistName(),p.getDescription());
	}
	
	public void getAccountData(account x,String type) { //SIGNING UP
		if(Database.getInstance().addingAccount(x,type) == false) {
			SigningUpView.getInstance().signingSuccessful();
		}
		else{
			SigningUpView.getInstance().signingFailed();
		
		}
	}
	
	public void checkingAccountData(account w) { //LOGGING IN
		if(Database.getInstance().loggingAccount(w) == true) {
			LoggingInView.getInstance().entranceAllowed();
		}
		else {
			LoggingInView.getInstance().entranceDenied();
		}
	}
	

	public void checkingArtistAccountData(account w) { //LOGGING IN
		if(Database.getInstance().loggingArtistAccount(w) == true) {
			ArtistLoggingInView.getInstance().entranceAllowed();
		}
		else {
			ArtistLoggingInView.getInstance().entranceDenied();
		}
	}
	



	public void getUserPlaylistData(Playlist p)
	{
		Database.getInstance().addingUserPlaylist(p);
	}
	
	public void addArtistPlaylist(ArtistPlaylist ap)
	{
		Database.getInstance().addArtistPlaylist(ap);
	}
	
	public void addAlbum(Album a)
	{
		Database.getInstance().addAlbum(a);
	}
	
	public void addSong(Song s)
	{
		Database.getInstance().addSong(s);
	}
	
	public ArrayList<Song> gettingSongs(String t) {
		return Database.getInstance().getSongs(t);
	}
	
	public ArrayList<Song> getSearchSongs(String searchText) {
		return Database.getInstance().getSearchSongs(searchText);
	}
	
	
	
	public void addSearchSongs(String songName,String username){
		Database.getInstance().addSearchSongs(songName,username);
	}
	
	public void addSearchPlaylists(String playlistName,String username){
		Database.getInstance().addSearchPlaylists(playlistName,username);
	}
	
	public void addListenerSongs(String songName,String username){
		Database.getInstance().addListenerSong(songName,username);
	}
	
	public void addListenerPlaylists(String playlistName,String username){
		Database.getInstance().addListenerPlaylist(playlistName,username);
	}
	
	public void addListenerFollow(String listenerName,String username) {
		Database.getInstance().addListenerFollow(listenerName,username);
	}
	
	public ArrayList<Playlist> getSearchPlaylist(String searchText){
		return Database.getInstance().getSearchPlaylist(searchText);
	}
	
	public ArrayList<account> gettingFollowersList(String searchText) {
		return Database.getInstance().getSearchAccount(searchText);
	}
	
	
	public ArrayList<Playlist> gettingPlaylists(String t){
		return Database.getInstance().getPlaylist(t);
	}
	
	public void readSongData(int SongID) {
		Database.getInstance().readBLOB(SongID);
	}

	public void updateCount(int SongID) {
		Database.getInstance().countUpdate(SongID);
	}
	public void favoritingPlaylist(String PlaylistID, String PlaylistName) {
		Database.getInstance().favoritingPlaylist(PlaylistID, PlaylistName);
	}
	public void makingPrivatePlaylist(String PlaylistIDPrivate,String PlaylistNamePrivate) {
		Database.getInstance().privacyPlaylist(PlaylistIDPrivate,PlaylistNamePrivate);
	}
	
	public void favoritingSongs(String SongID, String SongName) {
		Database.getInstance().favoritingSong(SongID, SongName);
	}

	public void gettingSongCounts(String username){
		
	}
	public ArrayList<Playlist> gettingFavoritePlaylist(String t) {
		return Database.getInstance().getFavoritePlaylist(t);
	}
	
	public ArrayList<Playlist> gettingPrivatePlaylists(String t){
		return Database.getInstance().getPrivatePlaylist(t);
	}
	
//	public ArrayList<account> gettingListenersFollowing(String a){
//		return Database.getInstance().getListenerFollowers(a);
//	}
	public ArrayList<Song> gettingFavoriteSong(String t)
	{
		return Database.getInstance().getFavoriteSong(t);
	}

	//=========================================================================== Everything Sorting
	
	public ArrayList<Song> getSongsByGenre(String username)
	{
		return Database.getInstance().getSongsByGenre(username);
	}
	
	public ArrayList<Song> getSongsByAlbum(String username)
	{
		return Database.getInstance().getSongsByAlbum(username);
	}
	
	public ArrayList<Song> getSongsByYear(String username)
	{
		return Database.getInstance().getSongsByYear(username);
	}
	
	public ArrayList<Song> getMostPlayed(String username)
	{
		return Database.getInstance().getMostPlayed(username);
	}
	
	public ArrayList<Playlist> getUserPlaylist(String username)
	{
		return Database.getInstance().gettingUserPlaylist(username);
	}

	public ArrayList<Song> getSortByTitle(String username) {
		return Database.getInstance().sortByTitle(username);
	}
	
	public ArrayList<Song> getSortByArtist(String username) {
		return Database.getInstance().sortByArtist(username);

	}
	
	//=========================================================================== Everything Editing
	public void editSongData(String username,String oldSongName, String newSongName,String newArtistName, String newAlbumName,String newGenreName ,String newYearDate) {
		Database.getInstance().editSongName(username,oldSongName,newSongName);
		Database.getInstance().editArtistName(username,oldSongName,newSongName,newArtistName);
		Database.getInstance().editAlbumName(username,oldSongName,newSongName,newAlbumName);
		Database.getInstance().editGenreName(username,oldSongName,newSongName,newGenreName);
		Database.getInstance().editYearDate(username,oldSongName,newSongName,newYearDate);
	}
}

