package model;
import java.io.File;
import javax.swing.*;
import javax.swing.JOptionPane;

import controller.PlaylistBuilder;
import controller.SongBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import view.LoggingInView;

public class Database{
	
	//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.95.65:3306/","superuser","kathyemir","swdespa"
	//arielariel0
	private volatile static Database instance = null;
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private String URL;
	private String USERNAME;
	private String PASSWORD;
	private String DATABASE;
	LoggingInView entrance;
	
	public static Database getInstance() {
        if (instance == null) {
        	instance = new Database();
        }
		return instance;
	}
	
	public boolean setConnection(String URL, String USERNAME, String PASSWORD, String DATABASE) {

		this.URL = URL;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.DATABASE = DATABASE;
		
		if(getConnection() == null)
			return false;
		//CREATE TABLE IF NOT EXISTS
		
		String query = "CREATE TABLE IF NOT EXISTS accounts (Username varchar(255) PRIMARY KEY, Password varchar(255), Type varchar(255));"; //creating table
		String query2 = "CREATE TABLE IF NOT EXISTS playlists(PlaylistID int NOT NULL AUTO_INCREMENT PRIMARY KEY, PlaylistName varchar(255), Username varchar(255));";
		String query3 = "CREATE TABLE IF NOT EXISTS songs(SongID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, Title varchar(255), "
				+ "Artist varchar(255),Album varchar(255),Genre varchar(255), Year varchar(255), Username varchar(255), Play_Count int(11), Favorite varchar(255));";
		String query4 = "CREATE TABLE IF NOT EXISTS user_playlists(PlaylistID int NOT NULL AUTO_INCREMENT PRIMARY KEY,Username varchar(255), PlaylistName varchar(255), Favorite varchar(255), Privacy varchar(255));";
		String query5 = "CREATE TABLE IF NOT EXISTS songData(SongID int NOT NULL AUTO_INCREMENT PRIMARY KEY, data LONGBLOB, SongName varchar(255));";
		String query6 = "CREATE TABLE IF NOT EXISTS songs_in_playlist(PlaylistID int PRIMARY KEY, PlaylistName varchar(255),SongID int(11), SongName varchar(255));";
		String query7 = "CREATE TABLE IF NOT EXISTS playlistData(PlaylistID int NOT NULL AUTO_INCREMENT PRIMARY KEY, picture BLOB,PlaylistName varchar(255), description varchar(255));";
		String query8 = "CREATE TABLE IF NOT EXISTS accountData(Username varchar(255) PRIMARY KEY, Profile_Picture BLOB);";
		String query9 = "CREATE TABLE IF NOT EXISTS album(albumid int NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255), username varchar(255), albumcover LONGBLOB);";
		
		String packetQuery = "SET GLOBAL max_allowed_packet=16777216;";
		
		String queryIncrement = "ALTER TABLE accounts auto_increment = 1";
		String queryIncrement2 = "ALTER TABLE playlists auto_increment = 1";
		String queryIncrement3 = "ALTER TABLE songs auto_increment = 1";
		String queryIncrement4 = "ALTER TABLE user_playlists auto_increment = 1";
		String queryIncrement5 = "ALTER TABLE songData auto_increment = 1";
		String queryIncrement7 = "ALTER TABLE playlistData auto_increment = 1";
		String queryIncrement8 = "ALTER TABLE accountData auto_increment = 1";
//		String queryIncrement7 = "ALTER TABLE user_songs auto_increment = 1";
//		String queryIncrement6 = "ALTER TABLE song_in_playlist = 1";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			PreparedStatement ps2 = getConnection().prepareStatement(query2);
			ps2.execute();
			PreparedStatement ps3 = getConnection().prepareStatement(query3);
			ps3.execute();
			PreparedStatement ps4 = getConnection().prepareStatement(query4);
			ps4.execute();
			PreparedStatement ps5 = getConnection().prepareStatement(query5);
			ps5.execute();
			PreparedStatement ps6 = getConnection().prepareStatement(query6);
			ps6.execute();
			PreparedStatement ps7 = getConnection().prepareStatement(query7);
			ps7.execute();
			PreparedStatement ps8 = getConnection().prepareStatement(query8);
			ps8.execute();
			
			PreparedStatement pq = getConnection().prepareStatement(packetQuery);
			pq.execute();
			
			ps = getConnection().prepareStatement(queryIncrement);
			ps.execute();
			ps2 = getConnection().prepareStatement(queryIncrement2);
			ps2.execute();
			ps3 = getConnection().prepareStatement(queryIncrement3);
			ps3.execute();
			ps4 = getConnection().prepareStatement(queryIncrement4);
			ps4.execute();
			ps5 = getConnection().prepareStatement(queryIncrement5);
			ps5.execute();
//			ps6 = getConnection().prepareStatement(queryIncrement6);
//			ps6.execute();
			ps7 = getConnection().prepareStatement(queryIncrement7);
			ps7.execute();
			ps8 = getConnection().prepareStatement(queryIncrement8);
			ps8.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return true;
	}
	
	public Connection getConnection () {
		try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(
					URL + 
					DATABASE + "?serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false", 
					USERNAME,
					PASSWORD);
			return connection;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected Database() {
		
	}
	
//	public void newClassTemplate()
//	{
//		Connection cnt = getConnection(); 
//		boolean loggedIn = false;
//		
//		String query = "";
//		
//		try {
//			//create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//			
//			//get result and store in result set
//			ResultSet rs = ps.executeQuery();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//	}
	
	public boolean addingAccount(account newAccount){ //Signing Up
		String x,y;
		boolean unique = false;
		//get getConnection() from db
		Connection cnt = getConnection();
		x = newAccount.getUsername();
		y = newAccount.getPassword();
		
		
		String query2 = "SELECT * FROM udc.accounts WHERE username =('"+newAccount.getUsername()+"') AND password = ('"+newAccount.getPassword()+"')";

		//create string query
		
		try {
			
			PreparedStatement ps2 = getConnection().prepareStatement(query2);
		
			
			ResultSet rs = ps2.executeQuery();
	
			if(rs.next()) { //User already exists
				unique = true;
			}
			else {
				unique = false;
				String query = "insert into accounts values ('"+x+"','"+y+"')";
				PreparedStatement ps = getConnection().prepareStatement(query);
				ps.execute();		
				ps.close();
			}
			
			//close all the resources
			
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unique;
	}
	
	public boolean loggingAccount(account registeredAccount) { //Logging In
		Connection cnt = getConnection(); 
		boolean loggedIn = false;
		
		String query = "SELECT * FROM udc.accounts WHERE username = ('"+registeredAccount.getUsername()+"') AND password = ('"+registeredAccount.getPassword()+"');";
		
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				loggedIn = true;
			}
			else {
				loggedIn = false;
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return loggedIn;
		
	}
	

	public int getIDforArtist(String username)
	{
		int result = 0;
		Connection cnt = getConnection();
		String query = "SELECT artistid FROM udc.artist WHERE username = '" + username + "'";
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return result;
		
	}
	
	public boolean loggingArtistAccount(account registeredAccount) { //Logging In
		Connection cnt = getConnection(); 
		boolean loggedIn = false;
		
		String query = "SELECT * FROM udc.accounts WHERE username = ('"+registeredAccount.getUsername()+"') AND password = ('"+registeredAccount.getPassword()+"') AND Type = 'artist'";
		
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				loggedIn = true;
			}
			else {
				loggedIn = false;
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return loggedIn;
		
	}

	public void addArtistPlaylist(ArtistPlaylist pl)
	{
		Connection cnt = getConnection(); 
		boolean loggedIn = false;
		
//		String query = "INSERT INTO artist_playlist (playlistid, name, userid, description, picture) VALUES (?,?,?,?,?)";
		String query = "INSERT INTO playlistdata (picture, PlaylistName, description) VALUES (?,?,?)";
		String query2 = "INSERT INTO user_playlists (Username, PlaylistName, Favorite, Privacy) VALUES (?,?,?,?)";
		String query3 = "INSERT INTO playlists (PlaylistName, Username) VALUES (?,?)";
		
		try {
			//create prepared statement
			//insert to playlistdata
			PreparedStatement ps = cnt.prepareStatement(query);
			File image = new File(pl.getPath());
			FileInputStream fis = new FileInputStream(image);
			ps.setBinaryStream(1, (InputStream)fis);
			ps.setString(2, pl.getName());
			ps.setString(3, pl.getDescription());
			ps.execute();
			
			//insert to user_playlists
			PreparedStatement ps2 = cnt.prepareStatement(query2);
			ps2.setString(1, pl.getUsername());
			ps2.setString(2, pl.getName());
			ps2.setString(3, "0");
			ps2.setString(4, "0");
			ps2.execute();
			
			//insert to playlists
			PreparedStatement ps3 = cnt.prepareStatement(query3);
			ps3.setString(1, pl.getName());
			ps3.setString(2, pl.getUsername());
			ps3.execute();
			System.out.println("Successfully added artist playlist!");
			
		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
		catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public void addAlbum(Album a)
	{
		Connection cnt = getConnection();
		String query = "INSERT INTO album (name, username, albumcover) VALUES (?,?,?)";
		
		try {
			//create prepared statement
			//insert to playlistdata
			PreparedStatement ps = cnt.prepareStatement(query);
			File image = new File(a.getPath());
			FileInputStream fis = new FileInputStream(image);
			ps.setBinaryStream(3, (InputStream)fis);
			ps.setString(1, a.getAlbumName());
			ps.setString(2, a.getUsername());
			ps.execute();
			
			System.out.println("Successfully added album " + a.getAlbumName() + "!");
		}
		
		catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}

	public void addSong(Song s)
	{
		Connection cnt = getConnection();

		String query = "INSERT INTO songs (Title, Artist, Album, Genre, Year, Username) VALUES (?,?,?,?,?,?)";
		String query2 = "INSERT INTO songdata (data) VALUES (?)";
		
		try {
			//create prepared statement
			//insert to playlistdata
			PreparedStatement ps = cnt.prepareStatement(query);
			File image = new File(s.getPath());
			FileInputStream fis = new FileInputStream(image);
			
			//load data into songs
			ps.setString(1, s.getSongName());
			ps.setString(2, s.getArtistName());
			ps.setString(3, s.getAlbum());
			ps.setString(4, s.getGenre());
			ps.setString(5, s.getYear());
			ps.setString(6, s.getUserName());
			ps.execute();
			
			PreparedStatement ps2 = cnt.prepareStatement(query2);
			ps2.setBinaryStream(1, (InputStream)fis);
			ps2.execute();
			
//			System.out.println("Successfully added album " + a.getAlbumName() + "!");
		}
		
		catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	
	public void writeSongBLOB(int SongID, String path,String songName) {

			
			Connection cnt = getConnection();
			FileInputStream input = null;
			PreparedStatement myStatement = null;
			
			String query = "INSERT INTO songData VALUES (?,?,?)";
			
			//create string qu
			
			try {
				myStatement = cnt.prepareStatement(query);
				
				File theSongFile = new File(path); //Place instead of song.getSongName()
				input = new FileInputStream(theSongFile);
				myStatement.setBinaryStream(2, input);
				myStatement.setInt(1, SongID);
				myStatement.setString(3,songName);
				
				System.out.println("Reading the MP3 file: " + theSongFile.getAbsolutePath());
				System.out.println("Storing MP3 into the database " + theSongFile);
				System.out.println(query);
				
				myStatement.execute();
				
				myStatement.close();
	
			} catch (Exception ecx) {
				ecx.printStackTrace();
			} 
			
		}
	
	public void writeDisplayPictureBLOB(String username, String path) {
		
		Connection cnt = getConnection();
		FileInputStream input = null;
		PreparedStatement myStatement = null;
		
		String query = "INSERT INTO accountData VALUES (?,?)";
		
		//create string qu
		
		try {
			myStatement = cnt.prepareStatement(query);
			
			File theDisplayPictureFile = new File(path); //Place instead of song.getSongName()
			input = new FileInputStream(theDisplayPictureFile);
			myStatement.setBinaryStream(2, input);
			myStatement.setString(1, username);
			
			System.out.println("Reading the jpeg file: " + theDisplayPictureFile.getAbsolutePath());
			System.out.println("Storing picture into the database " + theDisplayPictureFile);
			System.out.println(query);
			
			myStatement.execute();
			
			myStatement.close();

		} catch (Exception ecx) {
			ecx.printStackTrace();
		} 
		
	}
	
	public void writePlaylistBLOB(String playlistName, String path, String description) {
		
		Connection cnt = getConnection();
		FileInputStream input = null;
		PreparedStatement myStatement = null;
		
		
		String query = "INSERT INTO playlistData VALUES (?,?,?,?)";
		int x = 0;
		//create string qu
		
		try {
			myStatement = cnt.prepareStatement(query);
			
			File thePlaylistPicture = new File(path); 
			input = new FileInputStream(thePlaylistPicture);
			myStatement.setInt(1, x);
			myStatement.setBinaryStream(2, input);
			myStatement.setString(3, playlistName);
			myStatement.setString(4, description);
			
			System.out.println("Reading the jpeg file: " + thePlaylistPicture.getAbsolutePath());
			System.out.println("Storing Playlist picture into Database " + thePlaylistPicture);
			System.out.println(query);
			
			myStatement.execute();
			
			myStatement.close();

		} catch (Exception ecx) {
			ecx.printStackTrace();
		} 
		
	}
	
	
	
	public void readBLOB(int SongID) {
		Connection cnt = getConnection();
		PreparedStatement myReadingStatement = null;
		
		String query = "SELECT data FROM songData WHERE SongID = ?;";
		ResultSet rs = null;
		
		try {
			myReadingStatement = cnt.prepareStatement(query);
			myReadingStatement.setInt(1, SongID);
			
			rs = myReadingStatement.executeQuery();
			
			File file = new File("currentSong.mp3");
			FileOutputStream output = new FileOutputStream(file);
			
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("data");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                input.close();
            }
            
            myReadingStatement.close();
            output.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}
	
	public void readDisplayPictureBLOB(String username) {
		Connection cnt = getConnection();
		PreparedStatement myReadingStatement = null;
		
		String query = "SELECT data FROM accountData WHERE username = ('"+username+"');";
		ResultSet rs = null;
		
		try {
			myReadingStatement = cnt.prepareStatement(query);
			myReadingStatement.setString(1, username);
			
			rs = myReadingStatement.executeQuery();
			
			File file = new File("DisplayPicture.jpeg");
			FileOutputStream output = new FileOutputStream(file);
			
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("data");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                input.close();
            }
            
            myReadingStatement.close();
            output.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}
	

	public void queryTemplate(String parameters) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String query = "SELECT * FROM accounts";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			//transform set into list
			while(rs.next()) {
				System.out.println(rs.getString("Username"));
				System.out.println(rs.getString("Password"));
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public ArrayList<Song> getSongs(String username) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String query = "SELECT * FROM songs WHERE username = '"+username+"';";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Song> sl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Song newSong = new SongBuilder()
						 .setSongID(rs.getInt("SongID"))
						 .setUserName(rs.getString("Username"))
						 .setSongName(rs.getString("Title"))
						 .setArtistName(rs.getString("Artist"))
						 .setAlbum(rs.getString("Album"))
						 .setGenre(rs.getString("Genre"))
						 .setYear(rs.getString("Year"))
						 .setPath("")
						 .setCount(0)
						 .setFavorite(rs.getString("Favorite"))
						 .getSong();
				 sl.add(newSong);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return sl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public ArrayList<Song> getSearchSongs(String searchText) {
			
			//get getConnection() from db
			Connection cnt = getConnection();
			
			String query = "SELECT * FROM songs WHERE title =('"+searchText+"');";
			//create string qu
			
			try {
				//create prepared statement	
				PreparedStatement ps = cnt.prepareStatement(query);
				
				//get result and store in result set
				ResultSet rs = ps.executeQuery();
				
				ArrayList<Song> sl = new ArrayList<>();
				//transform set into list
				while(rs.next()) {
					 Song newSong = new SongBuilder()
							 .setSongID(rs.getInt("SongID"))
							 .setUserName(rs.getString("Username"))
							 .setSongName(rs.getString("Title"))
							 .setArtistName(rs.getString("Artist"))
							 .setAlbum(rs.getString("Album"))
							 .setGenre(rs.getString("Genre"))
							 .setYear(rs.getString("Year"))
							 .setPath("")
							 .setCount(0)
							 .getSong();
					 sl.add(newSong);
				}
				
				//close all the resources
				ps.close();
				rs.close();
				cnt.close();
				
				return sl;
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null; 
			
		}
	
	public void addSearchSongs(String songName,String username) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		int x = 0;
		int y = 0;
		String query = "INSERT INTO udc.songs (Title,Artist,Album,Genre,Year,Username,Play_Count,Favorite) SELECT Title,Artist,Album,Genre,Year,('"+username+"'),('"+x+"'),('"+y+"') FROM swdespa.songs WHERE Title = ('"+songName+"');";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			ps.execute();
			//get result and store in result set
			
			
			//close all the resources
			ps.close();
			cnt.close();
			
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null; 
		
	}
	
public void addSearchPlaylists(String playlistName,String username) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		int x = 0;
		int y = 0;
		int z = 0;
		String query = "INSERT INTO udc.playlists (Username,Playlist,Favorite,Privacy) SELECT ('"+username+"'),PlaylistName,('"+x+"'),('"+y+"'), FROM swdespa.playlists WHERE PlaylistName = ('"+playlistName+"') AND Privacy = ('"+z+"');";
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			ps.execute();
			//get result and store in result set
			
			
			//close all the resources
			ps.close();
			cnt.close();
			
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null; 
		
	}
	
public ArrayList<Playlist> getSearchPlaylist(String searchText) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		String x = "0";
		
		String query = "SELECT * FROM user_playlists WHERE PlaylistName =('"+searchText+"') AND Privacy = ('"+x+"');";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Playlist> p = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Playlist newPlaylist = new PlaylistBuilder()
						 .setPlaylistName(searchText)
						 .setUsername("username")
						 .getPlaylist();
				 p.add(newPlaylist);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return p;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public ArrayList<Playlist> getPlaylist(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				
				String query = "SELECT * FROM udc.playlists WHERE username = '"+username+"';";
				//create string qu
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Playlist> pl = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Playlist newPlaylist = new PlaylistBuilder()
								 .setPlaylistName(rs.getString("playlistName"))
								 .setUsername(rs.getString("username"))
								 .getPlaylist();
						 pl.add(newPlaylist);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return pl;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}
	
	public ArrayList<Playlist> getFavoritePlaylist(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				String y = "1";
				String query = "SELECT * FROM user_playlists WHERE username = ('"+username+"') AND Favorite = ('"+y+"');";
				//create string query
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Playlist> pl = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Playlist newPlaylist = new PlaylistBuilder()
								 .setPlaylistName(rs.getString("playlistName"))
								 .setUsername(rs.getString("username"))
								 .getPlaylist();
						 pl.add(newPlaylist);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return pl;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}
	
	public ArrayList<Playlist> getPrivatePlaylist(String username){
		//get getConnection() from db
		Connection cnt = getConnection();
		String y = "0";
		String query = "SELECT * FROM user_playlists WHERE username = ('"+username+"') AND Privacy = ('"+y+"');";
		//create string query
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Playlist> pl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Playlist newPlaylist = new PlaylistBuilder()
						 .setPlaylistName(rs.getString("playlistName"))
						 .setUsername(rs.getString("username"))
						 .getPlaylist();
				 pl.add(newPlaylist);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return pl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public ArrayList<Song> getFavoriteSong(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				String y = "1";
				String query = "SELECT * FROM songs WHERE username = ('"+username+"') AND Favorite = ('"+y+"');";
				//create string query
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Song> s = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Song newSong = new SongBuilder()
								 //.setSongName(rs.getString("songName"))
								 //.setUsername(rs.getString("username"))
								 .setSongName(rs.getString("title"))
								 .setUserName(rs.getString("username"))
								 .getSong();
						 s.add(newSong);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return s;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}

	public int addingSong(Song s){ //Signing Up
		String getSongName, getArtistName, getAlbumName, getGenre;
		String getYear, getUsername;
		int getCount;
		//get getConnection() from db
		Connection cnt = getConnection();
		getSongName = s.getSongName();
		getArtistName = s.getArtistName();
		getAlbumName = s.getAlbum();
		getGenre = s.getGenre();
		getYear = s.getYear();
		getUsername = s.getUserName();
		getCount = s.getCount();
		String x = s.getFavorite();
		
		
		String query = "insert into songs values ("+0+",'"+getSongName+"','" 
															+getArtistName+"','" 
															+getAlbumName+ "','"
															+getGenre+ "','"
															+getYear+"','"
															+getUsername+"','"
															+getCount+"','"
															+x+"')"; 
		

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int pk = rs.getInt(1);
			System.out.println(pk);
			//close all the resources
			ps.close();
			cnt.close();
			
			return pk;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public void countUpdate(int SongID) {
		Connection cnt = getConnection();
		PreparedStatement myReadingStatement = null;
		int ID = SongID;
		String query = "UPDATE udc.songs SET Play_Count = Play_Count + 1 WHERE SongID = ('"+ID+"');";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}

	
	public int addingPlaylist(Playlist p){
		String getPlaylistName, getUsername;
		
		
		//get getConnection() from db
		Connection cnt = getConnection();
		getPlaylistName = p.getPlaylistName();
		getUsername = p.getUsername();
		String x = "0";
		int y = 0;
		
		String query = "insert into playlists values ('"+y+"','"+getPlaylistName+"','"+getUsername+"');";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public void addingUserPlaylist(Playlist p){ 
		String getPlaylistName, getUsername;
		int y = 0;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		getPlaylistName = p.getPlaylistName();
		getUsername = p.getUsername();
		String x = p.getFavorite(); // if favorite or not
		String z = p.getPrivacy();
		
		String query = "insert into user_playlists values ('"+y+"','"+getUsername+"','"+getPlaylistName+"','"+x+"', '"+z+"')";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void favoritingPlaylist(String PlaylistID, String PlaylistName){ 
		String ID = PlaylistID;
		String Name = PlaylistName;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if favorite or not
		String y = "1";
		
		
		String query = "UPDATE udc.user_playlists SET Favorite = ('"+y+"') WHERE Username = ('"+ID+"') AND PlaylistName = ('"+Name+"');";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void privacyPlaylist(String PlaylistIDPrivate, String PlaylistNamePrivate) {
		String ID = PlaylistIDPrivate;
		String Name = PlaylistNamePrivate;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if private or not
		String y = "1";
		
		
		String query = "UPDATE udc.user_playlists SET Privacy = ('"+y+"') WHERE Username = ('"+ID+"') AND PlaylistName = ('"+Name+"');";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void favoritingSong(String SongID, String SongName){ 
		String ID = SongID;
		String Name = SongName;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if favorite or not
		String y = "1";
		
		
		String query = "UPDATE udc.songs SET Favorite = ('"+y+"') WHERE Username = ('"+ID+"') AND Title = ('"+Name+"');";
		System.out.println(ID);
		System.out.println(Name);

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	//======================================================================================All editing
	public void editSongName(String username,String oldSongName, String newSongName){
		String userName = username;
		String oldSong = oldSongName;
		String newSong = newSongName;
		
	
		
		
		String query = "UPDATE udc.songs SET Title = ('"+newSong+"') WHERE username = ('"+username+"') AND Title = ('"+oldSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			//get result and store in result set
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editArtistName(String username,String oldSongName,String newSongName, String newArtistName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newArtist = newArtistName;
		
		String query = "UPDATE udc.songs SET Artist = ('"+newArtist+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editAlbumName(String username,String oldSongName, String newSongName, String newAlbumName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newAlbum = newAlbumName;
		
		String query = "UPDATE udc.songs SET Album = ('"+newAlbum+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editGenreName(String username,String oldSongName, String newSongName, String newGenreName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newGenre = newGenreName;
		
		String query = "UPDATE udc.songs SET Genre = ('"+newGenre+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editYearDate(String username,String oldSongName, String newSongName, String newYearDate){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newYear = newYearDate;
		
		String query = "UPDATE udc.songs SET Year = ('"+newYear+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//======================================================================================All editing
	
	
	public void addingSongsInPlaylist(Playlist p, Song s){ 	
		int getPlaylistID;
		int getSongID; 
		String getPlaylistName;
		String getSongName;
		
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
	//	getPlaylistID = 0;
		getPlaylistName = p.getPlaylistName();
		getSongID = 0;
		getSongName = s.getSongName();
		
		String query = "insert into user_playlists values ('"+0+"','"
																+getPlaylistName+"','"
																+getSongID+"','"
																+getSongName+"')";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
public ArrayList<Song> getSongsByGenre(String username) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Genre;";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Song> sl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Song newSong = new SongBuilder()
						 .setSongID(rs.getInt("SongID"))
						 .setUserName(rs.getString("Username"))
						 .setSongName(rs.getString("Title"))
						 .setArtistName(rs.getString("Artist"))
						 .setAlbum(rs.getString("Album"))
						 .setGenre(rs.getString("Genre"))
						 .setYear(rs.getString("Year"))
						 .setPath("")
						 .setCount(0)
						 .setFavorite(rs.getString("Favorite"))
						 .getSong();
				 sl.add(newSong);
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return sl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
public ArrayList<Song> getSongsByAlbum(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Album;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> getSongsByYear(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Year DESC;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> getMostPlayed(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Play_Count DESC;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(rs.getInt("Play_Count"))
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Playlist> gettingUserPlaylist(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM udc.user_playlists WHERE username = '"+username+"';";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Playlist> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Playlist newPlaylist = new PlaylistBuilder()
					 .setUsername(rs.getString("Username"))
					 .setPlaylistName(rs.getString("PlaylistName"))
					 .getPlaylist();
					 
			 sl.add(newPlaylist);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> sortByTitle(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Title;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> sortByArtist(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Artist;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> sortByFavorite(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs WHERE username = ('"+username+"') ORDER BY Favorite;";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .setFavorite(rs.getString("Favorite"))
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}
//	public void testerTemplate() {
//		String x = "dad";
//		String y = "d";
//		Connection cnt = getConnection(); 
//		String query = "SELECT * FROM accounts WHERE Username = ('"+x+"') AND Password = ('"+y+"')"; 
//		
//		try {
//			//create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//			
//			//get result and store in result set
//			ResultSet rs = ps.executeQuery();
//			
//			//transform set into list
//			while(rs.next()) {
//				System.out.println(rs.getString("Username"));
//				System.out.println(rs.getString("Password"));
//			}
//			
//			//close all the resources
//			ps.close();
//			rs.close();
//			cnt.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//	}

}